<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="pt-br">

<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Configurar Mensagens do Sistema</title>

    <jsp:include page="../includes/header.jsp"/>

</head>

<body>

<div id="wrapper">

    <jsp:include page="../includes/navbar.jsp"/>

    <div id="page-wrapper">

        <div class="row">
            <div class="col-lg-12">
                <h2>Configurar Mensagens do Sistema</h2>
                <hr>
            </div>
            <!-- /.col-lg-12 -->
        </div>

        <!-- /.row -->
        <div class="row">

            <div class="col-lg-offset-1 col-lg-9">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Política para recebimento de mensagens do sistema
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form role="form">
                                    <fieldset>
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <div class="form-group">
                                                    <label for="tipo_mensagem">Tipo de Mensagem</label>
                                                    <div class="radio">
                                                        <label>
                                                            <input type="radio" name="tipo_mensagem" id="mensagem_individual" value="mensagem_individual">Mensagem individual
                                                        </label>
                                                    </div>
                                                    <div class="radio">
                                                        <label>
                                                            <input type="radio" name="tipo_mensagem" id="mensagem_agrupada" value="mensagem_agrupada" checked>Mensagem agrupada
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row" id="frequencia">
                                            <div class="col-lg-12">
                                                <div class="form-group">
                                                    <label for="tipo_mensagem">Frequência</label>
                                                    <div class="radio">
                                                        <label>
                                                            <input type="radio" name="frequencia" value="dia">Dia
                                                        </label>
                                                    </div>
                                                    <div class="radio">
                                                        <label>
                                                            <input type="radio" name="frequencia" value="semana">Semana
                                                        </label>
                                                    </div>
                                                    <div class="radio">
                                                        <label>
                                                            <input type="radio" name="frequencia" value="mes">Mês
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <div class="form-group">
                                                    <label>* Marque caso não queira receber mensagens do sistema:</label>
                                                    <div class="checkbox">
                                                        <label>
                                                            <input type="checkbox" name="desabilitar_mensagens">Desabilitar mensagens do sistema
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </fieldset>
                                    <div class="row">
                                        <div class="col-lg-offset-1 col-lg-11">
                                            <div class="alert alert-success" style="display: none;">
                                                As alterações de Configuração de Mensagens do Sistema foram salvas com sucesso!
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-12 text-center">
                                            <input type="button" value="Salvar" class="btn btn-primary">
                                        </div>
                                    </div>
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
<script src="../../js/polit_receb_msg/polit_receb_msg.js"></script>

</body>

</html>
