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

function removerItemFiltro(elemento){
    var divItemFiltro = $(elemento).parent().parent();
    $(divItemFiltro).remove();
}

function adicionarItemFiltro(elemento) {
    var divItens = $(elemento).parent().parent().children().get(0);
    var itemFiltroHTML = $(".itemFiltro").get(0).outerHTML;
    var itemFiltroObject = $($.parseHTML(itemFiltroHTML));
    $(itemFiltroObject).removeClass("hidden");
    $(itemFiltroObject).removeClass("template");
    $(divItens).append($(itemFiltroObject).get(0).outerHTML);
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