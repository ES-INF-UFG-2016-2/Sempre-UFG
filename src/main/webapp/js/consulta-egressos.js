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

function removerItemFiltro(element){
    console.log("removendo");
    console.log(element);
    var divItemFiltro = $(element).parent().parent();
    console.log(divItemFiltro);
    $(divItemFiltro).remove();
}

function adicionarItemFiltro(element) {
    console.log("adicionando item de filtro");
    var divItens = $(element).parent().parent().children().get(0);
    var itemFiltroHTML = $(".itemFiltro").get(0).outerHTML;
    var itemFiltroObject = $($.parseHTML(itemFiltroHTML));
    $(itemFiltroObject).removeClass("hidden");
    $(itemFiltroObject).removeClass("template");
    $(divItens).append($(itemFiltroObject).get(0).outerHTML);
}