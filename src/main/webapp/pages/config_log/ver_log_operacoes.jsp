<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="pt-br">

<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log de operações</title>

    <jsp:include page="../includes/header.jsp"/>

</head>

<body>

<div id="wrapper">

    <jsp:include page="../includes/navbar.jsp"/>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Log de operações</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <span class="clearfix"></span>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Aplicação</th>
                                <th>Servidor</th>
                                <th>IP</th>
                                <th>Data</th>
                                <th>Hora</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>1</td>
                                <td>Sempre UFG</td>
                                <td>Samambaia</td>
                                <td>254.254.254.254</td>
                                <td>02/11/2016</td>
                                <td>19:49:53</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-8">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Comandos SQL</th>
                                        <th>Tempo</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>SELECT * FROM TABLE_EXAMPLE WHERE 1</td>
                                        <td>00:00:00.0001MS</td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>SELECT * FROM TABLE_EXAMPLE WHERE 1</td>
                                        <td>00:00:00.0001MS</td>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td>SELECT * FROM TABLE_EXAMPLE WHERE 1</td>
                                        <td>00:00:00.0001MS</td>
                                    </tr>
                                    <tr>
                                        <td>4</td>
                                        <td>SELECT * FROM TABLE_EXAMPLE WHERE 1</td>
                                        <td>00:00:00.0001MS</td>
                                    </tr>
                                    <tr>
                                        <td>5</td>
                                        <td>SELECT * FROM TABLE_EXAMPLE WHERE 1</td>
                                        <td>00:00:00.0001MS</td>
                                    </tr>
                                    <tr>
                                        <td>6</td>
                                        <td>SELECT * FROM TABLE_EXAMPLE WHERE 1</td>
                                        <td>00:00:00.0001MS</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="col-md-4">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="jumbotron" style="padding: 15px">
                                            <b>Conexão estabelecida:</b> Sim<br/>
                                            <b>Termino de seleção:</b> 02/11/2016 ás 19:59:55<br/>
                                            <b>Fuso horário: </b> GTM -3 (Horário de verão +1h)<br/>
                                            <b>Tempo expirado: </b> Sim</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="panel panel-default">
                                            <div class="panel-heading text-center">
                                                Nível de detalhe
                                            </div>
                                            <div class="panel-body">
                                                <p>Detalhes</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->

<jsp:include page="../includes/footer.jsp"/>
<jsp:include page="../includes/scripts.jsp"/>

</body>

</html>
