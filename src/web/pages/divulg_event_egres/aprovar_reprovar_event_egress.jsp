<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="pt-br">

<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Evento Egresso</title>

    <jsp:include page="../includes/header.jsp"/>

</head>

<body>

<div id="wrapper">

    <jsp:include page="../includes/navbar.jsp"/>

    <div id="page-wrapper">

        <div class="row">
            <div class="col-lg-12">
                <h2>Evento Egresso</h2>
                <hr>
            </div>
            <!-- /.col-lg-12 -->
        </div>

        <!-- /.row -->
        <div class="row">

            <div class="col-lg-offset-1 col-lg-9">
                <div class="alert alert-success" style="display: none;">
                    <div class="row">
                        <div class="col-lg-6">
                            Evento publicado com sucesso!
                        </div>
                        <div class="col-lg-6 text-right">
                            <a href="lista_event_egres.jsp">Voltar</a>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Evento Exemplo 4
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-8">
                                <p><strong>Gestor:</strong> Fulano de tal</p>
                                <p><strong>Solicitante:</strong> Siclano de tal</p>
                                <p><strong>Data da solicitação:</strong> 08/10/2016</p>
                                <p><strong>Tema:</strong> Tema de exemplo legal</p>
                            </div>
                            <div class="col-lg-4 text-right">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button type="button" class="btn btn-success">Aprovar / Publicar</button>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <button type="button" data-toggle="collapse" data-target="#reprovar" class="btn btn-danger">Reprovar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row collapse" id="reprovar">
                            <div class="col-sm-12">
                                <hr>
                                <form role="form">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <p><strong>Parecer:</strong></p>
                                        </div>
                                        <div class="col-lg-6 text-right">
                                            <button type="submit" class="btn btn-primary">Enviar</button>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="form-group">
                                        <textarea class="form-control" name="parecer" rows="3"></textarea>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <hr>
                        <p><strong>Descrição:</strong></p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-9 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->

<jsp:include page="../includes/footer.jsp"/>
<jsp:include page="../includes/scripts.jsp"/>
<script src="../../js/divulg_event_egres/divulg_event_egres.js"></script>

</body>

</html>
