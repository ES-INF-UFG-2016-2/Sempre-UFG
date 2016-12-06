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
                    <form role="form">
                        <div class="row">
                            <div class="form-group col-md-5 col-sm-8">
                                <input class="form-control" placeholder="Nome da consulta">
                            </div>
                            <div class="form-group col-md-3 col-sm-4">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="">Consulta pública
                                    </label>
                                </div>
                            </div>
                            <div class="form-group col-md-4 col-sm-12 col-xs-12">
                                <button type="button" class="btn btn-primary col-md-12 col-sm-12 col-xs-12">Salvar definição de consulta</button>
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
                                
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        Filtro #1
                                        <button type="button" class="close" 
                                                data-target="#id_of_panel" 
                                                data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                                        </button>
                                    </div>
                                    <div class="panel-body">
                                        <div id="itensFiltros">
                                            <div class="itemFiltro row hidden template">
                                                <div class="row col-md-11">
                                                    <div class="form-group col-md-3 col-sm-6">
                                                        <select class="form-control select-parametro" onchange="onChangeSelect(this)">
                                                            <option>Idade</option>
                                                            <option>Nome</option>
                                                            <option>Sexo</option>
                                                            <option>data</option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group col-md-3 col-sm-6">
                                                        <select class="form-control select-operador" onchange="onChangeSelect(this)">
                                                            <option value="maior">maior que</option>
                                                            <option value="menor">menor que</option>
                                                            <option value="igual">igual</option>
                                                            <option value="entre">entre</option>
                                                            <option value="contem">contém</option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group col-md-6 col-sm-12 primeiro-argumento">
                                                        <input class="form-control" placeholder="valor">
                                                    </div>
                                                    <div class="form-group col-md-3 col-sm-6 segundo-argumento hidden">
                                                        <input class="form-control" placeholder="valor">
                                                    </div>
                                                </div>
                                                <div class="form-group col-md-1 text-center">
                                                    <button type="button" onclick="removerItemFiltro(this)" class="btn btn-danger btn-circle"><i class="fa fa-times"></i></button>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-12 text-center">
                                            <button type="button" onclick="adicionarItemFiltro(this)" class="btn btn-primary">Adicionar Condição</button>
                                        </div>
                                    </div>
                                </div>
                                
                                    <div class="text-center"><p>OU</p></div>
                                
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        Filtro #2
                                        <button type="button" class="close" 
                                                data-target="#id_of_panel" 
                                                data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                                        </button>
                                    </div>
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="row col-md-11">
                                                <div class="form-group col-md-3 col-sm-6">
                                                    <select class="form-control">
                                                        <option>Idade</option>
                                                        <option>Nome</option>
                                                        <option>Sexo</option>
                                                    </select>
                                                </div>
                                                <div class="form-group col-md-3 col-sm-6">
                                                    <select class="form-control">
                                                        <option>maior que</option>
                                                        <option>menor que</option>
                                                        <option>igual</option>
                                                        <option>entre</option>
                                                        <option>contém</option>
                                                    </select>
                                                </div>
                                                <div class="form-group col-md-3 col-sm-6">
                                                    <input class="form-control" placeholder="valor">
                                                </div>
                                                <div class="form-group col-md-3 col-sm-6">
                                                    <input class="form-control" placeholder="valor">
                                                </div>
                                            </div>
                                            <div class="form-group col-md-1 text-center">
                                                <button type="button" class="btn btn-danger btn-circle"><i class="fa fa-times"></i></button>
                                            </div>

                                        </div>
                                        <div class="row">
                                            <div class="row col-md-11">
                                                <div class="form-group col-md-3 col-sm-6">
                                                    <select class="form-control">
                                                        <option>Idade</option>
                                                        <option>Nome</option>
                                                        <option>Sexo</option>
                                                    </select>
                                                </div>
                                                <div class="form-group col-md-3 col-sm-6">
                                                    <select class="form-control">
                                                        <option>maior que</option>
                                                        <option>menor que</option>
                                                        <option>igual</option>
                                                        <option>entre</option>
                                                        <option>contém</option>
                                                    </select>
                                                </div>
                                                <div class="form-group col-md-6 col-sm-12">
                                                    <input class="form-control" placeholder="valor">
                                                </div>
                                            </div>
                                            <div class="form-group col-md-1 text-center">
                                                <button type="button" class="btn btn-danger btn-circle"><i class="fa fa-times"></i></button>
                                            </div>
                                        </div>
                                        <div class="col-md-12 text-center">
                                            <button type="button" class="btn btn-success btn-circle"><i class="fa fa-plus"></i></button>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-12 text-center">
                                    <button type="button" class="btn btn-success btn-circle"><i class="fa fa-plus"></i></button>
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