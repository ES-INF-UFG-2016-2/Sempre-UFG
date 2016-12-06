<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SB Admin 2 - Bootstrap Admin Theme</title>
        
        <jsp:include page="../includes/header.jsp"/>
        
    </head>

    <body>
        
        <jsp:include page="template-filtro-html.jsp"/>
        <jsp:include page="template-disjuncao-filtro-html.jsp"/>
        <jsp:include page="template-item-filtro-html.jsp"/>

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
                    <form id="formularioConsulta" role="form">
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
                            <div class="col-lg-2">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        Campos para Seleção
                                    </div>
                                    <div class="panel-body">
                                        <div class="list-group">
                                            <a href="#" class="list-group-item">Nome da Regional</a>
                                            <a href="#" class="list-group-item">Idade do Egresso</a>
                                            <a href="#" class="list-group-item">Nome da Mãe</a>
                                            <a href="#" class="list-group-item">Nome da Instituição de Ensino Médio</a>
                                            <a href="#" class="list-group-item">Turno</a>
                                            <a href="#" class="list-group-item">Cidade de Origem</a>
                                            <a href="#" class="list-group-item">Sexo</a>
                                            <a href="#" class="list-group-item">Área de Atuação</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-2">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        Campos Selecionados
                                    </div>
                                    <div class="panel-body" style="height: available">
                                        <div class="list-group">
                                            <a href="#" class="list-group-item">Curso</a>
                                            <a href="#" class="list-group-item">Nome do Egresso</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-8">
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