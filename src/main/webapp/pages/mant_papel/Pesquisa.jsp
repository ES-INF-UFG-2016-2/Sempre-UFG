<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
    <head>
        <style>
            .tabcontent {
                -webkit-animation: fadeEffect 1s;
                animation: fadeEffect 1s; /* Fading effect takes 1 second */
            }
            @-webkit-keyframes fadeEffect {
                from {
                    opacity: 0;
                }
                to {
                    opacity: 1;
                }
            }
            @keyframes fadeEffect {
                from {
                    opacity: 0;
                }
                to {
                    opacity: 1;
                }
            }
            .corpo {
                padding-left: 270px;
            }
            .corpointerno {
                padding-left: 20px;
            }
            .barrapesquisa {
                width: 500px;
                margin: 5px;
            }
        </style>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>SB Admin 2 - Bootstrap Admin Theme</title>

        <!-- Bootstrap Core CSS -->
        <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    </head>

    <body>
        <div id="wrapper"> 

            <jsp:include page="../includes/navbar.jsp"/>

            <!-- Page Content -->
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <nav id="menuSuperior">
                            <ul class="nav navbar-top-links navbar-left">
                                <li><a href="Pesquisa.html">InÃ­cio</a></li>
                                <li><a href="Pesquisa.html">Cadastros</a></li>
                                <li><a href="#">Contatos</a></li>
                                <li><a href="#">Eventos</a></li>
                                <li><a href="#">RelatÃ³rios</a></li>
                            </ul>
                        </nav>
                        <!-- /.col-lg-12 --> 
                    </div>
                    <h3>Grupos de Acesso (Direitos) - Pesquisa</h3>
                    <hr>
                    <!-- /.row --> 
                </div>
                <div class="barrapesquisa">
                    <div class="container-fluid">
                        <div class="input-group custom-search-form">
                            <h5>Nome do Grupo: </h5>
                            <input type="text" class="form-control" placeholder="Search...">
                        </div>
                        <hr>
                    </div>
                    <div class="container-fluid">
                        <a href="Incluir.html"><button type="button" class="btn btn-default"> Incluir </button></a>
                        <a href="Listagem.html"><button type="button" class="btn btn-default"> Procurar </button></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- /#wrapper --> 

    <!-- jQuery --> 
    <script src="../vendor/jquery/jquery.min.js"></script> 

    <!-- Bootstrap Core JavaScript --> 
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script> 

    <!-- Metis Menu Plugin JavaScript --> 
    <script src="../vendor/metisMenu/metisMenu.min.js"></script> 

    <!-- Custom Theme JavaScript --> 
    <script src="../dist/js/sb-admin-2.js"></script> 

    <jsp:include page="../includes/footer.jsp"/>
    <jsp:include page="../includes/scripts.jsp"/>

</body>
</html>
