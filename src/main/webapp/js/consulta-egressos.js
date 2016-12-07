$(function () {
    $("#formularioConsulta").on("submit", function (event) {
        event.preventDefault();
        
        var formularioArray = $("#formularioConsulta").serializeArray();
        var dadosConsulta = {}
        
        
        dadosConsulta["nome"] = $($.find("input[name=nome-consulta]")).val();
        if($($.find("input[name=consulta-publica]:checked")).length > 0){
            dadosConsulta["ePublica"] = true;
        } else {
            dadosConsulta["ePublica"] = false;
        }
        
        dadosConsulta["filtros"] = estruturarFiltros(formularioArray);

        var dados = "acao=definirConsulta";
        dados += "&dadosConsulta=" + JSON.stringify(dadosConsulta);

        var $form = $(this);
        $.ajax({
            type: $form.attr("method"),
            url: $form.attr("action"),
            data: dados,
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                var resultado = JSON.parse(data);
                if (resultado["resultado"] == 0) {
                    console.log("Sucesso" + resultado["mensagem"]);
                    $("#modal-notificacao").find("#titulo-modal-notificao").html("Sucesso!");
                    $("#modal-notificacao").find("#corpo-modal-notificacao").html(resultado["mensagem"]);
                    $form[0].reset();
                } else {
                    $("#modal-notificacao").find("#titulo-modal-notificao").html("Erro!");
                    $("#modal-notificacao").find("#corpo-modal-notificacao").html(resultado["mensagem"]);
                    consoloe.log("Erro" + resultado["mensagem"]);
                }
                $("#modal-notificacao").modal();
            }
        });
    });
});

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

function removerItemFiltro(elemento) {
    var divItemFiltro = $(elemento).parent().parent();
    $(divItemFiltro).remove();
}

function onChangeSelect(elemento) {
    var linhaItemFiltro = $(elemento).parent().parent();
    var parametroSelecionado = $(linhaItemFiltro).find(".select-parametro").val();
    var operadorSelecionado = $(linhaItemFiltro).find(".select-operador").val();
    var primeiroArgumento = $(linhaItemFiltro).find(".primeiro-argumento");
    var segundoArgumento = $(linhaItemFiltro).find(".segundo-argumento");

    if (parametroSelecionado == "data" && operadorSelecionado == "entre") {
        $(primeiroArgumento).removeClass("col-md-6");
        $(primeiroArgumento).removeClass("col-sm-12");
        $(primeiroArgumento).addClass("col-md-3");
        $(primeiroArgumento).addClass("col-sm-6");

        $(segundoArgumento).removeClass("hidden");
    } else {
        $(primeiroArgumento).removeClass("col-md-3");
        $(primeiroArgumento).removeClass("col-sm-6");
        $(primeiroArgumento).addClass("col-md-6");
        $(primeiroArgumento).addClass("col-sm-12");

        $(segundoArgumento).addClass("hidden");
    }
}

function gerarPrefixo() {
    var tamanho = 7;
    return Math.random().toString(36).replace(/[^a-z]+/g, '').substr(0, tamanho);
}

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
        console.log(filtro);
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
