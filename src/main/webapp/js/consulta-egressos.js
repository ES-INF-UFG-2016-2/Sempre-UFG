$(function () {

    $("#sortable-origem").sortable({
        connectWith: "#sortable-destino",
        revert: true
    });
    $("#sortable-destino").sortable({
        connectWith: "#sortable-origem",
        revert: true
    });
    $("ul, li").disableSelection();

    $("#formularioConsulta").on("submit", submeterConsulta);
    
    $("#botao-adicao-filtro").click();
    $("#filtros .btn").click();
});

/**
 * Submete os dados da consulta para o servlet definido no formulário.
 * @param {event} event Evento de clique do botão de submissão.
 * @returns {void}
 */
function submeterConsulta(event) {
    console.log(event);
    event.preventDefault();

    var formularioArray = $("#formularioConsulta").serializeArray();
    var dadosConsulta = {}


    dadosConsulta["nome"] = $($.find("input[name=nome-consulta]")).val();
    if ($($.find("input[name=consulta-publica]:checked")).length > 0) {
        dadosConsulta["ePublica"] = true;
    } else {
        dadosConsulta["ePublica"] = false;
    }

    dadosConsulta["campos"] = obterListaCamposConsulta();

    dadosConsulta["filtros"] = estruturarFiltros(formularioArray);

    var dados = "acao=definirConsulta";
    dados += "&dadosConsulta=" + JSON.stringify(dadosConsulta);

    var $form = $(this);
    $.ajax({
        type: $form.attr("method"),
        url: $form.attr("action"),
        data: dados,
        success: function (data, textStatus, jqXHR) {
            var resultado = JSON.parse(data);
            if (resultado["resultado"] == 0) {
                $("#modal-notificacao").find("#titulo-modal-notificao").html("Sucesso!");
                $("#modal-notificacao").find("#corpo-modal-notificacao").html(resultado["mensagem"]);
                $form[0].reset();
            } else {
                $("#modal-notificacao").find("#titulo-modal-notificao").html("Erro!");
                $("#modal-notificacao").find("#corpo-modal-notificacao").html(resultado["mensagem"]);
            }
            $("#modal-notificacao").modal();
        }
    });
}

/**
 * Adiciona uma div de filtro ao fim da lista de divs de filtros da página de consulta.
 * @param {botão HTML} elemento Botão acionador do evento.
 * @returns {void}
 */
function adicionarFiltro(elemento) {
    var divFiltros = $(elemento).parent().parent().find("#filtros");
    var filtroHTML = $(".filtro").get(0).outerHTML;
    var filtroObject = $($.parseHTML(filtroHTML));
    $(filtroObject).removeClass("hidden");

    if ($(divFiltros).children().length != 0) {
        var divDisjuncao = $($.parseHTML($(".disjuncao-filtro").get(0).outerHTML));
        $(divDisjuncao).removeClass("hidden");
        $(divFiltros).append($(divDisjuncao).get(0).outerHTML);
    }

    var prefixoItem = "filtro_" + gerarPrefixo() + "-";
    $(filtroObject).find("input").val(prefixoItem);

    $(divFiltros).append($(filtroObject).get(0).outerHTML);
}

/**
 * Remove uma div de filtro da lista de filtros da página de consulta.
 * @param {botão HTML} elemento Botão acionador do evento. Esse botão está inserido dentro da div que será removida e, 
 * sendo assim, servirá como referência para encontrar e remover a div de filtro.
 * @returns {void}
 */
function removerFiltro(elemento) {
    var divFiltro = $(elemento).parent().parent();
    var vizinhoAcima = $(divFiltro).prev();
    var vizinhoAbaixo = $(divFiltro).next();

    if ($(vizinhoAcima).length != 0) {
        $(vizinhoAcima).remove();
    } else if ($(vizinhoAbaixo).length != 0) {
        $(vizinhoAbaixo).remove();
    }

    $(divFiltro).remove();
}

/**
 * Adiciona um elemento de filtro ao fim da lista de itens de filtro de uma div de filtro.
 * @param {botão HTML} elemento Botão acionador do evento.
 * @returns {void}
 */
function adicionarItemFiltro(elemento) {
    var divItens = $(elemento).parent().parent().find(".itensFiltros");
    var itemFiltroHTML = $(".itemFiltro").get(0).outerHTML;
    var itemFiltroObject = $($.parseHTML(itemFiltroHTML));
    $(itemFiltroObject).removeClass("hidden");
    $(itemFiltroObject).removeClass("template");

    var prefixoItem = $(divItens).prev().val() + "item_filtro_" + gerarPrefixo() + "-";
    $.each($(itemFiltroObject).find(".form-control"), function (index, value) {
        $(value).attr("name", prefixoItem + $(value).attr("name"));
    });

    $(divItens).append($(itemFiltroObject).get(0).outerHTML);
}

/**
 * Remove um item de filtro de uma div de filtro.
 * @param {botão HTML} elemento Botão acionador do evento. Esse botão está inserido dentro da div de item de filtro que 
 * será removida e, sendo assim, servirá como referência para encontrar e remover a div de item de filtro.
 * @returns {void}
 */
function removerItemFiltro(elemento) {
    var divItemFiltro = $(elemento).parent().parent();
    $(divItemFiltro).remove();
}

/**
 * Controla um item de filtro para exibir a correta quantidade de inputs para argumentos dependendo do parâmetro e 
 * operador selecionado para aquele item de filtro. Quando o parâmetro selecionado for "data" e o operador selecionado 
 * for "entre", o item de filtro deve exibir duas entradas para argumentos em vez de um, como deve acontecer para 
 * qualquer outra combinação de parâmetro e operador.
 * @param {elemento 'select' HTML} elemento Elemento 'select' que teve o valor alterado (seletor de parâmetro ou 
 * operador).
 * @returns {void}
 */
function onChangeSelect(elemento) {
    var linhaItemFiltro = $(elemento).parent().parent();
    var parametroSelecionado = $(linhaItemFiltro).find(".select-parametro").val();
    var operadorSelecionado = $(linhaItemFiltro).find(".select-operador").val();
    var primeiroArgumento = $(linhaItemFiltro).find(".primeiro-argumento");
    var segundoArgumento = $(linhaItemFiltro).find(".segundo-argumento");

    if (parametroSelecionado.indexOf("data") !== -1 && operadorSelecionado == "entre") {
        $(primeiroArgumento).removeClass("col-md-4");
        $(primeiroArgumento).removeClass("col-sm-12");
        $(primeiroArgumento).addClass("col-md-2");
        $(primeiroArgumento).addClass("col-sm-6");

        $(segundoArgumento).removeClass("hidden");
    } else {
        $(primeiroArgumento).removeClass("col-md-2");
        $(primeiroArgumento).removeClass("col-sm-6");
        $(primeiroArgumento).addClass("col-md-4");
        $(primeiroArgumento).addClass("col-sm-12");

        $(segundoArgumento).addClass("hidden");
    }
}

/**
 * Gera uma string aleatória utilizada para identificar cada filtro e item de filtro na página de consulta.
 * @returns {String} String aleatória utilizada como identificador.
 */
function gerarPrefixo() {
    var tamanho = 7;
    return Math.random().toString(36).replace(/[^a-z]+/g, '').substr(0, tamanho);
}

/**
 * Estrutura o formulário de filtros para uma forma mais simples, sem índices, para que ele possa ser transformado em 
 * JSON.
 * @param {array} arrayConsulta Array contendo os campos do formulário para os filtros serializados pelo métodos 
 * <code>$().serializeArray()</code> do JQuery.
 * @returns {Array|estruturarFiltros.filtrosEstruturados} Array contendo conjuntos de itens de filtros. Cada conjunto 
 * de item de filtro corresponde a um filtro. Cada item de filtro é composto pelo parâmetro, o operador e seus 
 * argumentos, que são no mínimo 1 e no máximo 2.
 */
function estruturarFiltros(arrayConsulta) {
    var filtros = {};
    var filtrosEstruturados = [];
    $.each(arrayConsulta, function (indice, valor) {
        if (valor["name"].startsWith("filtro") && valor["name"].indexOf("item_filtro") != -1) {
            var nomeFiltro = valor["name"].split("-")[0];
            if (filtros[nomeFiltro] == null) {
                filtros[nomeFiltro] = [];
            }
            filtros[nomeFiltro].push(valor);
        }
    });


    $.each(filtros, function (indiceFiltro, filtro) {
        var itensFiltro = {};
        var itensFiltroEstruturados = [];
        $.each(filtro, function (indiceItemFiltro, itemFiltro) {
            var arrayNome = itemFiltro["name"].split("-");
            var nomeItemFiltro = arrayNome[1];
            var nomeElemento = arrayNome[2];
            if (itensFiltro[nomeItemFiltro] == null) {
                itensFiltro[nomeItemFiltro] = {};
            }
            itensFiltro[nomeItemFiltro][nomeElemento] = itemFiltro["value"];
        });

        $.each(itensFiltro, function (indiceItemFiltro, itemFiltro) {
            //TODO: Validar dados inseridos.
            if (itemFiltro["parametro"] == "data" && itemFiltro["operador"] == "entre") {
                itemFiltro["argumento1"] = itemFiltro["argumento1"] + ".." + itemFiltro["argumento2"];
            }
            delete itemFiltro["argumento2"];
            itensFiltroEstruturados.push(itemFiltro);
        });
        filtrosEstruturados.push(itensFiltroEstruturados);
    });
    return filtrosEstruturados;
}

/**
 * Obtém uma lista dos campos selecionados para a consulta.
 * @returns {Array|obterListaCamposConsulta.camposConsulta} lista de Strings que são os nomes dos campos selecionados 
 * para a consulta.
 */
function obterListaCamposConsulta() {
    var camposConsulta = [];
    $("#sortable-destino li").each(function (elemento) {
        camposConsulta.push($(this).attr("value"));
    });
    return camposConsulta;
}