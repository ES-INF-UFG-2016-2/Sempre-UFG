<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="pt-br">

<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Configuração Log</title>

    <jsp:include page="../includes/header.jsp"/>

</head>

<body>

<div id="wrapper">

    <jsp:include page="../includes/navbar.jsp"/>

    <form>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Configurações do Log</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <span class="clearfix"></span>
            <div class="row">
                <div class="col-md-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Informações do log
                        </div>
                        <div class="panel-body">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="" checked> Nome da Aplicação
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="" checked> Tentativas de conexão
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="" checked> Autenticação com sucesso
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="" checked> Término da sessão
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="" checked> Duração de comando executado
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="" checked> Nível de detalhe escrito no log
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="" checked> Nome e endereço de IP do servidor
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="" checked> Prefixo do log
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="" checked> Sessão expirada
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="" checked> Comandos SQL
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="" checked> Fuso Horário
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="" checked> Data e hora
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Eventos de log
                                </div>
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-xs-6">
                                            <fieldset>
                                                <legend>Nível de mensagem</legend>
                                                <div>
                                                    <div class="form-group">
                                                        <label>Cliente</label>
                                                        <select class="form-control">
                                                            <option>DEBUG 5</option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Servidor</label>
                                                        <select class="form-control">
                                                            <option>DEBUG 5</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </fieldset>
                                        </div>
                                        <div class="col-xs-6">
                                            <fieldset>
                                                <legend>SQL</legend>
                                                <div class="form-group">
                                                    <label>Comandos gravados</label>
                                                    <select class="form-control">
                                                        <option>Tudo</option>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label>Duração máxima</label>
                                                    <select class="form-control">
                                                        <option>5 segundos</option>
                                                    </select>
                                                </div>
                                            </fieldset>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Informações técnicas
                                </div>
                                <div class="panel-body">
                                    <div class="container-fluid">
                                        <div class="row">
                                            <div class="col-xs-6">
                                                <div class="form-group">
                                                    <label for="diretorio">Diretório</label>
                                                    <input type="text" value="C://UFG/SempreUFG/Log"
                                                           class="form-control"
                                                           id="diretorio"/>
                                                </div>
                                                <div class="form-group">
                                                    <label for="nome_arquivos">Nomo dos arquivos de log</label>
                                                    <input type="text" value="SempreUFG_Log_Db" class="form-control"
                                                           id="nome_arquivos"/>
                                                </div>
                                                <div class="form-group">
                                                    <label>Tempo de vida</label>
                                                    <select class="form-control">
                                                        <option>1 Ano</option>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label>Tamanho Máximo</label>
                                                    <select class="form-control">
                                                        <option>200 Kb</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-xs-6">
                                                <div class="form-group">
                                                    <label>Destino</label>
                                                    <div class="checkbox">
                                                        <label>
                                                            <input type="checkbox" value="" checked> Stderr
                                                        </label>
                                                    </div>
                                                    <div class="checkbox">
                                                        <label>
                                                            <input type="checkbox" value=""> Csvlog
                                                        </label>
                                                    </div>
                                                    <div class="checkbox">
                                                        <label>
                                                            <input type="checkbox" value=""> Syslog
                                                        </label>
                                                    </div>
                                                    <div class="checkbox">
                                                        <label>
                                                            <input type="checkbox" value=""> Eventlog
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-offset-4 col-xs-4">
                            <button class="btn btn-danger btn-block" type="button">Cancelar</button>
                        </div>
                        <div class="col-xs-4">
                            <button class="btn btn-success btn-block" type="button">Salvar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->

<jsp:include page="../includes/footer.jsp"/>
<jsp:include page="../includes/scripts.jsp"/>

</body>

</html>
