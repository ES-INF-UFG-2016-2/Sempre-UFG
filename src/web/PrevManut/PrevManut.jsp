<HTML>
<HEAD>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <link rel="stylesheet" href="css/">
    <script src="js/bootstrap-datepicker.js"></script>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

            <script>
                $(function () {
                 $('.datepicker').datepicker();
                });
             </script>
</HEAD>

<BODY>

    <div class="panel panel-primary">
      <div class="panel-heading">Sempre UFG</div>

      <!-- Conteúdo do Painel -->
      <div class="panel-body">
          <!-- barra de navegação e página de conteúdo -->
          <nav class="navbar navbar-default">
            <div class="container-fluid">
                <ul class="nav navbar-nav">
                    <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
                    <li><a data-toggle="tab" href="#gerencial">Gerencial</a></li>
                    <li><a data-toggle="tab" href="#manutencao">Aviso de Manutenção</a></li>
                </ul>
            </div>
        </nav>
  
    <!-- Countúdo das Tabs -->
        <div class="tab-content">
            <div id="home" class="tab-pane fade in active">
                <h3>HOME</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                </div>
            <div id="gerencial" class="tab-pane fade">
                <h3>Menu 1</h3>
                <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                </div>
            <div id="manutencao" class="tab-pane fade">
                <!-- Colunas de datepickers-->
                <div class="row">
                    <div class="col-md-3">
                        <!-- Date picker -->
                        <div>
                            Manutenção Programada: <input class="datepicker" type="text" name="date">
                        </div>
                    </div>
                    <div class="col-md-3">
                        <!-- Date picker -->
                        <div>
                            Data Final: <input class="datepicker" type="text" name="date">
                        </div>
                    </div>
                    <div class="col-md-3">
                        <!-- Date picker -->
                        <div>
                         Hora Inicial: <input class="datepicker" type="text" name="date">
                        </div>                        
                    </div>
                    <div class="col-md-3">
                        <!-- Date picker -->
                        <div>
                         Hora Final: <input class="datepicker" type="text" name="date">
                        </div>                        
                    </div>
                </div>
                
                
        </div>



      </div>
    </div>

</BODY>

</HTML>