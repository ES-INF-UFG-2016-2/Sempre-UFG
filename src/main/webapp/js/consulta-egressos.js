$(function () {

    /**
     * Este objeto é responsável por definir cada item de um filtro criado pelo usuário para realizar uma consulta de egresso.
     * @param {string} parametro Parâmetro que será adicionado ao filtro (nome, data de nascimento, etc).
     * @param {string} operador Operador lógico que será adicionado ao filtro (maior, menor, etc).
     * @param {array} valores Valores para o parâmetro e o operador. Em geral, esse array contém apenas 1 elemento, mas quando o parâmetro é data e o operador é entre, 2 valores são esperados dentro desse array.
     * @returns {consulta-egressos_L1.ItemFiltro}
     */
    var ItemFiltro = function (parametro, operador, valores) {
        this.parametro = parametro;
        this.operador = operador;
        this.valores = valores;
    }
    
    /**
     * Este objeto é responsável por definir cada filtro criado pelo usuário para realizar uma consulta de egresso.
     * @param {array} itensFiltro Itens para serem adicionados ao filtro.
     * @returns {consulta-egressos_L1.Filtro}
     */
    var Filtro = function(itensFiltro){
        this.itensFiltro = itensFiltro;
    }
    
    $("#formularioConsulta").on("submit", function(event){
        event.preventDefault();
        var jsonFormulario = JSON.stringify($("#formularioConsulta").serializeArray());
        estruturarFiltros($("#formularioConsulta").serializeArray());
    });
});

function adicionarFiltro(elemento) {
    var divFiltros = $(elemento).parent().parent().find("#filtros");
    var filtroHTML = $(".filtro").get(0).outerHTML;
    var filtroObject = $($.parseHTML(filtroHTML));
    $(filtroObject).removeClass("hidden");
    
    if($(divFiltros).children().length != 0) {
        $(divFiltros).append($(".disjuncao-filtro").get(0).outerHTML);
    }
    
    var prefixoItem = "filtro_" + gerarPrefixo() + "-";
    $(filtroObject).find("input").val(prefixoItem);
    
    $(divFiltros).append($(filtroObject).get(0).outerHTML);   
}

function removerFiltro(elemento){
    var divFiltro = $(elemento).parent().parent();
    var vizinhoAcima = $(divFiltro).prev();
    var vizinhoAbaixo = $(divFiltro).next();

    if($(vizinhoAcima).length != 0){
        $(vizinhoAcima).remove();
    } else if($(vizinhoAbaixo).length != 0){
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
    $.each($(itemFiltroObject).find(".form-control"), function(index, value){
        $(value).attr("name", prefixoItem + $(value).attr("name"));
    });
    
    $(divItens).append($(itemFiltroObject).get(0).outerHTML);
}

function removerItemFiltro(elemento){
    var divItemFiltro = $(elemento).parent().parent();
    $(divItemFiltro).remove();
}

function onChangeSelect(elemento){
    var linhaItemFiltro = $(elemento).parent().parent();
    var parametroSelecionado = $(linhaItemFiltro).find(".select-parametro").val();
    var operadorSelecionado = $(linhaItemFiltro).find(".select-operador").val();
    var primeiroArgumento = $(linhaItemFiltro).find(".primeiro-argumento");
    var segundoArgumento = $(linhaItemFiltro).find(".segundo-argumento");
    
    if(parametroSelecionado == "data" && operadorSelecionado == "entre"){
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

function gerarPrefixo(){
    var tamanho = 7;
    return Math.random().toString(36).replace(/[^a-z]+/g, '').substr(0, tamanho);
}

function estruturarFiltros(arrayConsulta){
    var filtros = {};
    var filtrosEstruturados = [];
    $.each(arrayConsulta, function(indice, valor){
        if(valor["name"].startsWith("filtro") && valor["name"].indexOf("item_filtro") != -1){
            var nomeFiltro = valor["name"].split("-")[0];
            if(filtros[nomeFiltro] == null){
                filtros[nomeFiltro] = [];
            }
            filtros[nomeFiltro].push(valor);
        }
    });
    
    
    $.each(filtros, function(indiceFiltro, filtro){
        console.log(filtro);
        var itensFiltro = {};
        var itensFiltroEstruturados = [];
        $.each(filtro, function(indiceItemFiltro, itemFiltro){
            var arrayNome = itemFiltro["name"].split("-");
            var nomeItemFiltro = arrayNome[1];
            var nomeElemento = arrayNome[2];
            if(itensFiltro[nomeItemFiltro] == null){
                itensFiltro[nomeItemFiltro] = {};
            }
            itensFiltro[nomeItemFiltro][nomeElemento] = itemFiltro["value"];
        });
        
        $.each(itensFiltro, function(indiceItemFiltro, itemFiltro){
            //TODO: Validar dados inseridos.
            if(itemFiltro["parametro"] == "data" && itemFiltro["operador"] == "entre") {
                itemFiltro["argumento1"] = itemFiltro["argumento1"] + ".." + itemFiltro["argumento2"];
            }
            delete itemFiltro["argumento2"];
            itensFiltroEstruturados.push(itemFiltro);
        });
        filtrosEstruturados.push(itensFiltroEstruturados);
    });
    return filtrosEstruturados;    
}
