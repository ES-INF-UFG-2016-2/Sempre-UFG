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
                <table class="table table-hover">
                    <thead>
                    <tr class="active">
                        <th>#</th>
                        <th>Aplicação</th>
                        <th>Servidor</th>
                        <th>IP</th>
                        <th>Data</th>
                        <th>Hora</th>
                        <th>Fuso Horário</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr style="cursor: pointer;" onclick="location.href='ver_log_operacoes.jsp';">
                        <td>1</td>
                        <td>Sempre UFG</td>
                        <td>Samambaia</td>
                        <td>254.254.254.254</td>
                        <td>02/11/2016</td>
                        <td>19:49:53</td>
                        <td>GTM -3</td>
                    </tr>
                    <tr style="cursor: pointer;"  onclick="location.href='ver_log_operacoes.jsp';">
                        <td>2</td>
                        <td>Sempre UFG</td>
                        <td>Samambaia</td>
                        <td>254.254.254.254</td>
                        <td>02/11/2016</td>
                        <td>19:49:53</td>
                        <td>GTM -3</td>
                    </tr>
                    <tr style="cursor: pointer;"  onclick="location.href='ver_log_operacoes.jsp';">
                        <td>3</td>
                        <td>Sempre UFG</td>
                        <td>Samambaia</td>
                        <td>254.254.254.254</td>
                        <td>02/11/2016</td>
                        <td>19:49:53</td>
                        <td>GTM -3</td>
                    </tr>
                    <tr style="cursor: pointer;"  onclick="location.href='ver_log_operacoes.jsp';">
                        <td>4</td>
                        <td>Sempre UFG</td>
                        <td>Samambaia</td>
                        <td>254.254.254.254</td>
                        <td>02/11/2016</td>
                        <td>19:49:53</td>
                        <td>GTM -3</td>
                    </tr>
                    <tr style="cursor: pointer;"  onclick="location.href='ver_log_operacoes.jsp';">
                        <td>5</td>
                        <td>Sempre UFG</td>
                        <td>Samambaia</td>
                        <td>254.254.254.254</td>
                        <td>02/11/2016</td>
                        <td>19:49:53</td>
                        <td>GTM -3</td>
                    </tr>
                    <tr style="cursor: pointer;"  onclick="location.href='ver_log_operacoes.jsp';">
                        <td>6</td>
                        <td>Sempre UFG</td>
                        <td>Samambaia</td>
                        <td>254.254.254.254</td>
                        <td>02/11/2016</td>
                        <td>19:49:53</td>
                        <td>GTM -3</td>
                    </tr>
                    <tr style="cursor: pointer;"  onclick="location.href='ver_log_operacoes.jsp';">
                        <td>7</td>
                        <td>Sempre UFG</td>
                        <td>Samambaia</td>
                        <td>254.254.254.254</td>
                        <td>02/11/2016</td>
                        <td>19:49:53</td>
                        <td>GTM -3</td>
                    </tr>
                    <tr style="cursor: pointer;"  onclick="location.href='ver_log_operacoes.jsp';">
                        <td>8</td>
                        <td>Sempre UFG</td>
                        <td>Samambaia</td>
                        <td>254.254.254.254</td>
                        <td>02/11/2016</td>
                        <td>19:49:53</td>
                        <td>GTM -3</td>
                    </tr>
                    <tr style="cursor: pointer;"  onclick="location.href='ver_log_operacoes.jsp';">
                        <td>9</td>
                        <td>Sempre UFG</td>
                        <td>Samambaia</td>
                        <td>254.254.254.254</td>
                        <td>02/11/2016</td>
                        <td>19:49:53</td>
                        <td>GTM -3</td>
                    </tr>
                    <tr style="cursor: pointer;"  onclick="location.href='ver_log_operacoes.jsp';">
                        <td>10</td>
                        <td>Sempre UFG</td>
                        <td>Samambaia</td>
                        <td>254.254.254.254</td>
                        <td>02/11/2016</td>
                        <td>19:49:53</td>
                        <td>GTM -3</td>
                    </tr>
                    </tbody>
                </table>
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
