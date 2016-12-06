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
                <h2>Atualizar dados pessoais</h2>
                <h4 class="page-header"><jsp:include page="menunav.jsp"/></h4>
            </div>
            <!-- /.col-lg-12 -->
        </div>

        <!-- /.row -->
        <div class="row">

            <div class="col-lg-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Identificação
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form role="form">
                                    <fieldset id="identification" disabled>
                                        <div class="form-group">
                                            <label for="name">Nome</label>
                                            <input class="form-control" id="name" type="text" maxlength="150" placeholder="José João Neto">
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Email</label>
                                            <input class="form-control" id="email" type="text" maxlength="80" placeholder="dummy@email.com">
                                        </div>
                                        <div class="form-group">
                                            <label for="pass">Senha</label>
                                            <input class="form-control" id="pass" type="password" maxlength="20" placeholder="umasenha">
                                        </div>
                                        <div class="form-group">
                                            <label for="cpf">CPF</label>
                                            <input class="form-control" id="cpf" type="number" min="11111111111" max="99999999999" placeholder="12345678912">
                                        </div>
                                        <div class="form-group">
                                            <label>Matrícula</label>
                                            <p class="form-control-static" id="enrollment">123456789</p>
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
            <!-- /.col-lg-4 -->
            <div class="col-lg-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Pessoal
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form role="form">
                                    <fieldset id="personal" disabled>
                                        <div class="form-group">
                                            <label>Nome da Mãe</label>
                                            <input class="form-control" id="mother_name" type="text" maxlength="150" placeholder="Maria Sebastiana da Silva">
                                        </div>
                                        <div class="form-group">
                                            <label for="sex">Sexo do Egresso</label>
                                            <select id="sex" class="form-control">
                                                <option>Masculino</option>
                                                <option>Feminino</option>
                                                <option>Outro</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="visibility">Visibilidade</label>
                                            <select id="visibility" class="form-control">
                                                <option>Pública</option>
                                                <option>Privada</option>
                                            </select>
                                        </div><br>
                                        <div class="form-group">
                                            <label>Data de Nascimento</label><br><br>
                                            <div class="row">
                                                <div class="col-md-4">
                                                    <span class="help-block">Dia</span>
                                                    <input id="day" type="number" min="1" max="31" placeholder="Dia" class="form-control input-md">
                                                </div>
                                                <div class="col-md-4">
                                                    <span class="help-block">Mês</span>
                                                    <input id="Month" type="number" min="1" max="12" placeholder="Mês" class="form-control input-md">
                                                </div>
                                                <div class="col-md-4">
                                                    <span class="help-block">Ano</span>
                                                    <input id="Year" type="number" min="1899" max="2099" placeholder="Ano" class="form-control input-md">
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
            <!-- /.col-lg-4 -->
            <div class="col-lg-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Endereço
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form role="form">
                                    <fieldset id="address" disabled>
                                        <div class="form-group">
                                            <label>Logradouro</label>
                                            <input class="form-control" id="road" type="text" maxlength="150" placeholder="Rua, Avenida, Outros">
                                        </div>
                                        <div class="form-group">
                                            <label>Bairro</label>
                                            <input class="form-control" id="district" type="text" maxlength="150" placeholder="Distrito">
                                        </div>
                                        <div class="form-group">
                                            <label>Número</label>
                                            <input class="form-control" id="number" type="number" min="0" max="99999" placeholder="0">
                                        </div>
                                        <div class="form-group">
                                            <label>Quadra</label>
                                            <input class="form-control" id="block" type="number" min="0" max="99999" placeholder="40">
                                        </div>
                                        <div class="form-group">
                                            <label>Lote</label>
                                            <input class="form-control" id="slot" type="number" min="0" max="99999" placeholder="10">
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
            <!-- /.col-lg-4 -->
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
