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
                <h2>Incluir Carreira</h2>
                <h4 class="page-header"><jsp:include page="menunav.jsp"/></h4>
            </div>
            <!-- /.col-lg-12 -->
        </div>

        <!-- /.row -->
        <div class="row">

            <div class="col-lg-offset-1 col-lg-9">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Carreira
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form role="form">
                                    <fieldset id="career" disabled>
                                        <div class="row">
                                            <div class="col-lg-6">
                                                <div class="form-group">
                                                    <label for="actuation">Atua na área de formação?</label>
                                                    <select id="actuation" class="form-control">
                                                        <option>Sim</option>
                                                        <option>Não</option>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label for="time_to_actuation">Tempo para atuar na área</label>
                                                    <input class="form-control" id="time_to_actuation" type="number" min="1" max="999" placeholder="em meses">
                                                </div>
                                                <div class="form-group">
                                                    <label for="ingress_type">Forma de Ingresso</label>
                                                    <select id="ingress_type" class="form-control">
                                                        <option>Entrevista</option>
                                                        <option>Indicação</option>
                                                        <option>Outro</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="form-group">
                                                    <label for="organization_type">Tipo de Organização</label>
                                                    <select id="organization_type" class="form-control">
                                                        <option>Privada</option>
                                                        <option>Pública</option>
                                                        <option>Outro</option>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label for="income">Renda Mensal</label>
                                                    <input class="form-control" id="income" type="number" min="100" max="999999999" placeholder="em R$">
                                                </div>
                                                <div class="form-group">
                                                    <label for="income_satisfaction">Nível de Satisfação com a Renda</label>
                                                    <select id="income_satisfaction" class="form-control">
                                                        <option>Muito satisfeito</option>
                                                        <option>Satisfeito</option>
                                                        <option>Não satisfeito</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <div class="form-group">
                                                    <label for="future_perspective">Perspectiva sobre o futuro da área</label>
                                                    <textarea id="future_perspective" class="form-control" rows="5"></textarea>
                                                </div>
                                            </div>
                                        </div>
                                    </fieldset>
                                    <input type="button" value="Atualizar" onClick="releaseEditLock(this)" class="btn btn-primary pull-right">
                                </form>
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
<script src="../../js/atualizar_egresso/menunav.js"></script>
<script src="../../js/atualizar_egresso/buttons.js"></script>

</body>

</html>
