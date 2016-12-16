<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt-br">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SempreUFG - Definir Consulta de Egressos</title>

        <jsp:include page="../includes/header.jsp"/>
    </head>

    <body>

        <jsp:include page="template-filtro-html.jsp"/>
        <jsp:include page="template-disjuncao-filtro-html.jsp"/>
        <jsp:include page="template-item-filtro-html.jsp"/>
        <jsp:include page="modal-notificacao.jsp"/>

        <div id="wrapper">

            <jsp:include page="../includes/navbar.jsp"/>

            <!-- Page Content -->
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Definir Consulta de Egressos</h1>
                        </div>
                    </div>
                    <form id="formularioConsulta" role="form" method="POST" action="nova-consulta">
                        <div class="row">
                            <div class="form-group col-md-5 col-sm-8">
                                <input name="nome-consulta" class="form-control" placeholder="Nome da consulta" />
                            </div>
                            <div class="form-group col-md-3 col-sm-4">
                                <div class="checkbox">
                                    <label>
                                        <input name="consulta-publica" type="checkbox">Consulta pública
                                    </label>
                                </div>
                            </div>
                            <div class="form-group col-md-4 col-sm-12 col-xs-12">
                                <button class="btn btn-primary col-md-12 col-sm-12 col-xs-12" type="submit">Salvar definição de consulta</button>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-3 col-md-6">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        Campos para Seleção
                                    </div>
                                    <div class="panel-body">
                                        <div class="text-center"><p><i>Deixe aqui os itens que você não deseja ver na consulta.</i></p></div>
                                        <ul id="sortable-origem" style="list-style-type: none; margin: 0; padding: 0; min-height: 10px">
                                            <c:forEach var="campo" items="${mapaCampos}">
                                                <li class="ui-state-default list-group-item" value="${campo.key}">${campo.value}</li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-md-6">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        Campos Selecionados
                                    </div>
                                    <div class="panel-body">
                                        <div class="text-center"><p><i>Arraste os itens que você deseja ver na consulta para este painel.</i></p></div>
                                        <ul id="sortable-destino" style="list-style-type: none; margin: 0; padding: 0; min-height: 10px">
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-12">
                                <h3>Filtros da Consulta</h3>
                                <div id="filtros">
                                    <!-- <!-- Filtros serão inseridos aqui dinamicamente -->
                                </div>
                                <div class="col-md-12 text-center">
                                    <button type="button" onclick="adicionarFiltro(this)" class="btn btn-primary">Adicionar Filtro</button>
                                </div>
                            </div>
                        </div>
                    </form>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /#page-wrapper -->

        </div>
        <!-- /#wrapper -->

        <jsp:include page="../includes/footer.jsp"/>
        <jsp:include page="../includes/scripts.jsp"/>
        <script src="../../js/consulta-egressos.js"></script>

    </body>

</html>