<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="pt-br">

<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Lista de eventos egresso para aprovar divulgação</title>

    <jsp:include page="../includes/header.jsp"/>

</head>

<body>

<div id="wrapper">

    <jsp:include page="../includes/navbar.jsp"/>

    <div id="page-wrapper">

        <div class="row">
            <div class="col-lg-12">
                <h2>Lista de eventos egresso para aprovar divulgação</h2>
                <hr>
            </div>
            <!-- /.col-lg-12 -->
        </div>

        <!-- /.row -->
        <div class="row">

            <div class="col-lg-offset-1 col-lg-9">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Lista de Eventos
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Evento</th>
                                        <th>Data da Solicitação</th>
                                        <th>Status</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>Evento exemplo 1</td>
                                        <td>08/10/2016</td>
                                        <td class="success">Aprovado</td>
                                    </tr>
                                    <tr>
                                        <td>Evento exemplo 2</td>
                                        <td>08/10/2016</td>
                                        <td class="success">Aprovado</td>
                                    </tr>
                                    <tr>
                                        <td>Evento exemplo 3</td>
                                        <td>08/10/2016</td>
                                        <td class="danger">Reprovada</td>
                                    </tr>
                                    <tr>
                                        <td>Evento exemplo 4</td>
                                        <td>08/10/2016</td>
                                        <td class="warning"><a href="aprovar_reprovar_event_egress.jsp">Aguardando</a>  </td>
                                    </tr>
                                    <tr>
                                        <td>Evento exemplo 5</td>
                                        <td>08/10/2016</td>
                                        <td class="success">Aprovado</td>
                                    </tr>
                                    <tr>
                                        <td>Evento exemplo 6</td>
                                        <td>08/10/2016</td>
                                        <td class="success">Aprovado</td>
                                    </tr>
                                    <tr>
                                        <td>Evento exemplo 7</td>
                                        <td>08/10/2016</td>
                                        <td class="warning"><a href="aprovar_reprovar_event_egress.jsp">Aguardando</a></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
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

</body>

</html>
