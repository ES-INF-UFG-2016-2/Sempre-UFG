<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="pt-br">

<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login</title>

    <jsp:include page="../includes/header.jsp"/>

</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">SempreUFG - Entrar</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="E-mail" name="email" type="email" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Senha" name="password" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Mantenha-me conectado
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <a href="index.jsp" class="btn btn-lg btn-success btn-block">Login</a>
                            </fieldset>
                            <br>
                            <a href="index.jsp" class="btn btn-lg btn-primary btn-block">Entrar como Visitante</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="../includes/footer.jsp"/>
    <jsp:include page="../includes/scripts.jsp"/>

</body>

</html>
