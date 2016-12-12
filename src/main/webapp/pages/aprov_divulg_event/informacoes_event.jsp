<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="pt-br">

<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Informações do Evento</title>

    <jsp:include page="../includes/header.jsp"/>

</head>

<body>

<div id="wrapper">

    <jsp:include page="../includes/navbar.jsp"/>

    <div id="page-wrapper">

        <div class="row">
            <div class="col-lg-12">
                <h2>Informações do Evento</h2>
                <hr>
            </div>
            <!-- /.col-lg-12 -->
        </div>

        <!-- /.row -->
        <div class="row">

            <div class="col-lg-offset-1 col-lg-9">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        HACKaTRUCK na UFG
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <p><strong>Data de realização do evento:</strong> 15/11/2016</p>
                                <p><strong>Assunto:</strong> Evento Teste</p>
                                <p><strong>Público Alvo:</strong> Alunos da UFG</p>
                                <p><strong>Áreas Relacionadas:</strong> Informática, T.I., Computação e Engenharias</p>
                                <a href="aprov_divulg_event.jsp">voltar a aprovação de divulgação de eventos</a>
                            </div>
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
