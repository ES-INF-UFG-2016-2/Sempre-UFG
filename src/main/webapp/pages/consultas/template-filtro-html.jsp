<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<div class="panel panel-default filtro hidden">
    <div class="panel-heading">
        &emsp;
        <button type="button" class="close" onclick="removerFiltro(this)">
            <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
        </button>
    </div>
    <div class="panel-body">
        <input name="filtro_id" class="form-control" value="" type="hidden"/>
        <div class="itensFiltros">
            <!-- Itens de filtro serão inseridos aqui dinamicamente -->
        </div>
        <div class="col-md-12 text-center">
            <button type="button" onclick="adicionarItemFiltro(this)" class="btn btn-primary">Adicionar Condição</button>
        </div>
    </div>
</div>