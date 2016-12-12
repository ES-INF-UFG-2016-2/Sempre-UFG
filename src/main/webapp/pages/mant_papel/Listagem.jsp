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
                    <h3>Grupos de Acesso (Direitos) - Listagem</h3>
                    <hr>
                    <!-- /.row --> 
                </div>
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li><a href="Acessos.html" class="tablinks">
                                <h4>Egresso</h4>
                            </a></li>
                        <li><a href="Acessos.html" class="tablinks">
                                <h4>CAVI</h4>
                            </a></li>
                        <li><a href="Acessos.html" class="tablinks">
                                <h4>PRPG</h4>
                            </a></li>
                        <li><a href="Acessos.html" class="tablinks">
                                <h4>Administrador</h4>
                            </a></li>
                        <li><a href="Acessos.html" class="tablinks">
                                <h4>Prograd</h4>
                            </a></li>
                    </ul>
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
<script>
    function openList(evt, cityName) {
        // Declare all variables
        var i, tabcontent, tablinks;

        // Get all elements with class="tabcontent" and hide them
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++) {
            tabcontent[i].style.display = "none";
        }

        // Get all elements with class="tablinks" and remove the class "active"
        tablinks = document.getElementsByClassName("tablinks");
        for (i = 0; i < tablinks.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" active", "");
        }

        // Show the current tab, and add an "active" class to the link that opened the tab
        document.getElementById(cityName).style.display = "block";
        evt.currentTarget.className += " active";
    }
</script> 
<script>
// Get the element with id="defaultOpen" and click on it
    document.getElementById("defaultOpen").click();
</script>

<jsp:include page="../includes/footer.jsp"/>
<jsp:include page="../includes/scripts.jsp"/>
</body>
</html>
