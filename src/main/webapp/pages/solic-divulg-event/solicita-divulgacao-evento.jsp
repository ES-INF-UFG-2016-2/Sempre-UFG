<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="pt-br">

<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Divulgar Evento</title>

    <jsp:include page="../includes/header.jsp"/>

</head>

<body>

<div id="wrapper">

    <jsp:include page="../includes/navbar.jsp"/>

    <div id="page-wrapper">

        <div class="row">
            <div class="col-lg-12">
                <h2>Divulgar Evento</h2>
            </div>
        </div>

        <div class="row">

            <div class="col-lg-offset-1 col-lg-9">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Evento
                    </div>
                    <div class="panel-body">
                        <form role="form">
                            <fieldset id="project_participation">
                                <div class="row">
                                    <div class="col-lg-offset-2 col-lg-8">
                                        <div class="row">
                                            <div class="form-group col-md-3" style="margin-top: 5px">
                                                <label>Título</label>
                                            </div>
                                            <div class="col-md-9">
                                                <input id="titulo_evento" type="text" min="1" max="12"
                                                       placeholder="Dê um título para seu evento."
                                                       class="form-control input-sm">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-group col-md-3" style="margin-top: 5px">
                                                <label>Assunto</label>
                                            </div>
                                            <div class="col-md-9">
                                                <input id="assunto_evento" type="text" min="1" max="12"
                                                       placeholder="Identifique o assunto do evento."
                                                       class="form-control input-sm">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-group col-md-3" style="margin-top: 5px">
                                                <label>Tipo</label>
                                            </div>
                                            <div class="col-md-9">
                                                <select id="tipo_evento_select" class="form-control">
                                                    <option>Tipo 1</option>
                                                    <option>Tipo 2</option>
                                                    <option>Tipo 3</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-group col-md-3" style="margin-top: 5px">
                                                <label>Descrição</label>
                                            </div>
                                            <div class="col-md-9">
                                                <textarea id="descricao_evento" type="text" min="1" max="12"
                                                          placeholder="Descreva aqui o conteúdo do evento."
                                                          class="form-control input-sm" rows="10"/></textarea>
                                            </div>
                                        </div>
                                        <br>
                                        <div class="row">
                                            <div class="form-group col-md-3" style="margin-top: 5px">
                                                <label>Público-Alvo</label>
                                            </div>
                                            <div class="col-md-9">
                                                <input id="publico_alvo_evento" type="text" min="1" max="12"
                                                       placeholder="Defina o público alvo do evento."
                                                       class="form-control input-sm">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-group col-md-3" style="margin-top: 5px">
                                                <label>Áreas Relacionadas</label>
                                            </div>
                                            <div class="col-md-9">
                                            <textarea
                                                    id="areas_relacionadas_evento" type="text" min="1" max="12"
                                                    placeholder="Identifique as áreas de conhecimento relacionadas ao evento."
                                                    class="form-control input-sm"
                                                    rows="3"/></textarea><br>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-group col-md-3" style="margin-top: 5px">
                                                <label>Interessados</label>
                                            </div>
                                            <div class="col-md-9">
                                                <input id="interessados_evento" type="text" min="1" max="12"
                                                       placeholder="Identifique quem responderá por esta divulgação."
                                                       class="form-control input-sm">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-group col-md-3" style="margin-top: 5px">
                                                <label>E-mail</label>
                                            </div>
                                            <div class="col-md-9">
                                                <input id="email_evento" type="text" min="1" max="12"
                                                       placeholder="Informe e-mail para contato."
                                                       class="form-control input-sm">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </fieldset>
                            <div class="col-lg-offset-2 col-lg-8"><br>
                                <div class="row">
                                    <button type="submit" class="btn btn-default pull-left">
                                        Cancelar
                                    </button>
                                    <button type="submit" class="btn btn-primary pull-right">
                                        <i class="glyphicon glyphicon-send"></i> Solicitar Divulgação
                                    </button>
                                </div>
                            </div>
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
