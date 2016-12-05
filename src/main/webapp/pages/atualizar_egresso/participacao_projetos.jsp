<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="pt-br">

<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Minha Conta</title>

    <jsp:include page="../includes/header.jsp"/>

</head>

<body>

<div id="wrapper">

    <jsp:include page="../includes/navbar.jsp"/>

    <div id="page-wrapper">

        <div class="row">
            <div class="col-lg-12">
                <h2>Atualizar participação</h2>
                <h4 class="page-header"><jsp:include page="menunav.jsp"/></h4>
            </div>
            <!-- /.col-lg-12 -->
        </div>

        <!-- /.row -->
        <div class="row">

            <div class="col-lg-offset-1 col-lg-9">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Participação
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <form role="form">
                            <fieldset id="project_participation">
                                <div class="row">
                                    <div class="col-lg-offset-2 col-lg-8">
                                        <div class="form-group">
                                            <label for="participation_type">Tipo</label>
                                            <select id="participation_type" class="form-control">
                                                <option>Monitoria</option>
                                                <option>Iniciação Científica</option>
                                                <option>Outro</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Datas</label>
                                            <div class="row">
                                                <div class="col-lg-2">
                                                    <span class="help-block">Início</span>
                                                </div>
                                                <div class="col-lg-3">
                                                    <input id="start_month" type="number" min="1" max="12" placeholder="Mês" class="form-control input-sm">
                                                    <input id="start_year" type="number" min="1899" max="2099" placeholder="Ano" class="form-control input-sm">
                                                </div>
                                                <div class="col-lg-offset-2 col-lg-2">
                                                    <span class="help-block">Conclusão</span>
                                                </div>
                                                <div class="col-lg-3">
                                                    <input id="end_month" type="number" min="1" max="12" placeholder="Mês" class="form-control input-sm">
                                                    <input id="end_year" type="number" min="1899" max="2099" placeholder="Ano" class="form-control input-sm">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="description">Descrição</label>
                                            <textarea id="description" class="form-control" rows="5"></textarea>
                                        </div>
                                    </div>
                                </div>
                            </fieldset>
                            <input type="button" value="Salvar" onClick="saveModifications(this)" class="btn btn-primary pull-right">
                        </form>
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-8 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->

<jsp:include page="../includes/footer.jsp"/>
<jsp:include page="../includes/scripts.jsp"/>
<script src="../../js/atualizar_egresso/menunav.js"></script>
<script src="../../js/atualizar_egresso/buttons.js"></script>

</body>

</html>
