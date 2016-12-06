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
});

function adicionarFiltro(elemento) {
    var divFiltros = $(elemento).parent().parent().find("#filtros");
    var filtroHTML = $(".filtro").get(0).outerHTML;
    var filtroObject = $($.parseHTML(filtroHTML));
    $(filtroObject).removeClass("hidden");
    if($(divFiltros).children().length != 0) {
        $(divFiltros).append($(".disjuncao-filtro").get(0).outerHTML);
    }
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
    $(divItens).append($(itemFiltroObject).get(0).outerHTML);
}

function removerItemFiltro(elemento){
    var divItemFiltro = $(elemento).parent().parent();
    $(divItemFiltro).remove();
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