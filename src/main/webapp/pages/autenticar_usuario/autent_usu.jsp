<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Sempre Ufg - Login</title>

        <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
        <link href="../dist/css/sb-admin-2.css" rel="stylesheet">
        <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div id="wrapper">
            <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" >Sempre UFG</a>
                </div>
                <div class="navbar-default sidebar" role="navigation">
                </div>
            </nav>
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Bem-Vindo ao Sempre UFG</h1>
                        </div>
                        <div class="container">
                            <div class="row">
                                <div class="col-md-4 col-md-offset-4">
                                    <div class="login-panel panel panel-default">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">Please Sign In</h3>
                                        </div>
                                        <div class="panel-body">
                                            <form role="form">
                                                <fieldset>
                                                    <div class="form-group">
                                                        <input class="form-control" placeholder="E-mail" name="email" type="email" autofocus>
                                                    </div>
                                                    <div class="form-group">
                                                        <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                                    </div>
                                                    <div class="checkbox">
                                                        <label>
                                                            <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                                        </label>
                                                    </div>
                                                    <!-- Change this to a button or input when using this as a form -->
                                                    <a href="index.html" class="btn btn-lg btn-success btn-block">Login</a>
                                                </fieldset>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="../vendor/jquery/jquery.min.js"></script>
        <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="../vendor/metisMenu/metisMenu.min.js"></script>
        <script src="../dist/js/sb-admin-2.js"></script>
    </body>
</html>
