<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<div class="itemFiltro row hidden template">
    <div class="row col-md-11">
        <div class="form-group col-md-4 col-sm-6">
            <select name="parametro" class="form-control select-parametro" onchange="onChangeSelect(this)">
                <c:forEach var="campo" items="${mapaCampos}">
                    <option value="${campo.key}">${campo.value}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-md-4 col-sm-6">
            <select name="operador" class="form-control select-operador" onchange="onChangeSelect(this)">
                <option value="maior">maior que</option>
                <option value="menor">menor que</option>
                <option value="igual">igual</option>
                <option value="entre">entre</option>
                <option value="contem">contém</option>
            </select>
        </div>
        <div class="form-group col-md-4 col-sm-12 primeiro-argumento">
            <input name="argumento1" class="form-control" placeholder="valor">
        </div>
        <div class="form-group col-md-2 col-sm-6 segundo-argumento hidden">
            <input name="argumento2" class="form-control" placeholder="valor">
        </div>
    </div>
    <div class="form-group col-md-1 text-center">
        <button type="button" onclick="removerItemFiltro(this)" class="btn btn-danger btn-circle"><i class="fa fa-times"></i></button>
    </div>
</div>