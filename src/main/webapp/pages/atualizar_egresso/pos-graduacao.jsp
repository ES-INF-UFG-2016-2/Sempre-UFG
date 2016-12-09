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
                <h2>Adicionar Pós-Graduação</h2>
                <h4 class="page-header"><jsp:include page="menunav.jsp"/></h4>
            </div>
            <!-- /.col-lg-12 -->
        </div>

        <!-- /.row -->
        <div class="row">
            <div class="col-lg-offset-1 col-lg-9">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Pós-Graduação
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <form role="form">
                            <fieldset id="pos_graduation">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label for="course_name">Nome do Curso</label>
                                            <input class="form-control" id="course_name" type="text" maxlength="150" placeholder="Engenharia de Software">
                                        </div>
                                        <div class="form-group">
                                            <label for="level">Nível</label>
                                            <select id="level" class="form-control">
                                                <option>Mestrado</option>
                                                <option>Doutorado</option>
                                                <option>PhD</option>
                                                <option>Outro</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Datas</label>
                                            <div class="row">
                                                <div class="col-lg-offset-1 col-lg-2">
                                                    <span class="help-block">Início</span>
                                                </div>
                                                <div class="col-lg-3">
                                                    <input id="start_month" type="number" min="1" max="12" placeholder="Mês" class="form-control input-sm">
                                                    <input id="start_year" type="number" min="1899" max="2099" placeholder="Ano" class="form-control input-sm">
                                                </div>
                                                <div class="col-lg-2">
                                                    <span class="help-block">Conclusão</span>
                                                </div>
                                                <div class="col-lg-offset-1 col-lg-3">
                                                    <input id="end_month" type="number" min="1" max="12" placeholder="Mês" class="form-control input-sm">
                                                    <input id="end_year" type="number" min="1899" max="2099" placeholder="Ano" class="form-control input-sm">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label for="course_name">Nome da Instituição</label>
                                            <input class="form-control" id="institution" type="text" maxlength="150" placeholder="Universidade Católica de Goiás">
                                        </div>
                                        <div class="form-group">
                                            <label for="institution_type">Tipo de Instituição</label>
                                            <select id="institution_type" class="form-control">
                                                <option>Privada</option>
                                                <option>Pública</option>
                                                <option>Outro</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-lg-4">
                                                    <label for="city">Cidade</label>
                                                    <input class="form-control input-sm" id="city" type="text" maxlength="50" placeholder="Goiânia">
                                                </div>
                                                <div class=" col-lg-4">
                                                    <label for="state">UF</label>
                                                    <input class="form-control input-sm" id="state" type="text" maxlength="50" placeholder="Goiás">
                                                </div>
                                                <div class="col-lg-4">
                                                    <label for="country">País</label>
                                                    <input class="form-control input-sm" id="country" type="text" maxlength="50" placeholder="Brasil">
                                                </div>
                                            </div>
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
                <p>* Cursos de pós graduação cursados na UFG serão adicionados automaticamente<p>
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

</body>

</html>
