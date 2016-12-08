<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>SempreUFG</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/style.css" rel="stylesheet">
    <link href="../../css/plugins/morris.css" rel="stylesheet">
    <link href="../../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Sempre UFG</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu message-dropdown">
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>Fulana de Tal da Silva</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                        <p>Solicitação de evento X</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>Fulana de Tal da Silva</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                        <p>Solicitação de evento X</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>Fulana de Tal da Silva</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                        <p>Solicitação de evento X</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-footer">
                            <a href="#">Read All New Messages</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu alert-dropdown">
                        <li>
                            <a href="#">Alert Name <span class="label label-default">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-primary">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-success">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-info">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-warning">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-danger">Alert Badge</span></a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">View All</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Fulana de Tal da Silva <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                  <li>
                      <a ><i class="fa fa-fw "></i><font size="4">Permissões</font></a>
                  </li>
                    <li class="active">
                        <a href="gestor.html"><i class="fa fa-fw "></i>Gestor do Sistema</a>
                    </li>
                    <li>
                        <a href="egresso.html"><i class="fa fa-fw "></i>Egresso</a>
                    </li>
                    <li>
                        <a href="cavi.html"><i class="fa fa-fw "></i>CAVI</a>
                    </li>
                    <li>
                        <a href="prograd.html"><i class="fa fa-fw "></i>PROGRAD</a>
                    </li>
                    <li>
                        <a href="prpg.html"><i class="fa fa-fw "></i>PRPG</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>



        <div class="form-group" >
            <label>
              <div class="titulo-checkbox">
                <font size="6">Executar consultas</font>
              </div>
            </label>

            <div class="checkbox">
                <label>
                    <input type="checkbox" value=""><font size="4">Consultas pré-definidas</font>
                </label>
            </div>
            <div class="paragrafo-checkbox">
            <p>Consultas pré-definidas são consultas geralmente realizadas com muita frequência, gravadas para facilitar o acesso do usuário à informação. Usuários com essa permissão não poderão criar consultas pré-definidas, mas poderâo executar qualquer consulta que já estiver registrada</p>
            </div>

            <div class="checkbox">
                <label>
                    <input type="checkbox" value=""><font size="4">Editar consultas pré-definidas</font>
            </div>
            <div class="paragrafo-checkbox">
            <p>Concede permissão de editar, adicionar, atualizar, e excluir consultas pré-definidas</p>
            </div>
            <div class="checkbox">
                <label>
                    <input type="checkbox" value=""><font size="4">Consultas ad-hoc</font>
            </div>
            <div class="paragrafo-checkbox">
            <p>Consultas ad-hoc são uma forma de montar consultas pela interface. Usuários com esta permissão poderão montar qualquer consulta, recebendo ou não parâmetros</p>
            </div>
        </div>

        <div class="form-group" >
            <label>
              <div class="titulo-checkbox">
                <font size="6">Dados de Egressos</font>
              </div>
            </label>

            <div class="checkbox">
                <label>
                    <input type="checkbox" value=""><font size="4">Editar dados de Egresso</font>
                </label>
            </div>
            <div class="paragrafo-checkbox">
            <p>Usuário com esta permissão pode editar os dados dos Egressos (Apenas relacionados à UFG)</p>
            </div>

            <div class="checkbox">
                <label>
                    <input type="checkbox" value=""><font size="4">Editar todos os dados de Egresso</font>
                </label>
            </div>
            <div class="paragrafo-checkbox">
            <p>Usuário com esta permissão pode editar todos os dados dos Egressos</p>
            </div>

            <div class="checkbox">
                <label>
                    <input type="checkbox" value=""><font size="4">Adicionar Egresso no sistema</font>
                </label>
            </div>
            <div class="paragrafo-checkbox">
            <p>Concede a permissão de adicionar novos Egressos ao sistema</p>
            </div>

            <div class="checkbox">
                <label>
                    <input type="checkbox" value=""><font size="4">Apagar Egresso</font>
                </label>
            </div>
            <div class="paragrafo-checkbox">
            <p>Concede a permissão de apagar Egresso do sistema</p>
            </div>

        </div>

        <div class="form-group" >
            <label>
              <div class="titulo-checkbox">
                <font size="6">Notícias</font>
                </div>
            </label>

            <div class="checkbox">
                <label>
                    <input type="checkbox" value=""><font size="4">Cadastrar notícias</font>
                </label>
            </div>
            <div class="paragrafo-checkbox">
            <p>Concede permissão apenas para cadastrar notícias</p>
            </div>
            <div class="checkbox">
                <label>
                    <input type="checkbox" value=""><font size="4">Receber notícias</font>
            </div>
            <div class="paragrafo-checkbox">
              <p>Permite ao usuário apenas ler e receber as notícias cadastradas
            </div>

            <div class="checkbox">
                <label>
                    <input type="checkbox" value=""><font size="4">Apagar notícias</font>
            </div>
            <div class="paragrafo-checkbox">
              <p>Concede permissão de apagar notícias do sistema
            </div>
        </div>
    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../../js/jquery.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <script src="../../js/plugins/morris/raphael.min.js"></script>
    <script src="../../js/plugins/morris/morris.min.js"></script>
    <script src="../../js/plugins/morris/morris-data.js"></script>

</body>

</html>
