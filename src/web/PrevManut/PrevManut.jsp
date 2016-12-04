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

      <!-- ConteÃºdo do Painel -->
      <div class="panel-body">
          <!-- barra de navegaÃ§Ã£o e pÃ¡gina de conteÃºdo -->
          <nav class="navbar navbar-default">
            <div class="container-fluid">
                <ul class="nav navbar-nav">
                    <li class="active"><a data-toggle="tab" href="#home">Configuracoes</a></li>
                    <li><a data-toggle="tab" href="#gerencial">Gerencial</a></li>
                    <li><a data-toggle="tab" href="#manutencao">Aviso de ManutenÃ§Ã£o</a></li>
                </ul>
            </div>
        </nav>
  
    <!-- CountÃºdo das Tabs -->
        <div class="tab-content">
            <div id="home" class="tab-pane fade in active">
                <h3>Configurações</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
            </div>  <!-- fim conteúdo configurações -->
            <div id="gerencial" class="tab-pane fade">
                <h3>Gerencial</h3>
                <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
            </div> <!-- Fim conteúdo gerencial -->
             
             
           <!-- Divisor de conteúdo da aba "Aviso de Manutenção" -->
            <div id="manutencao" class="tab-pane fade">
                    <form action="PrevManutHandler.jsp" method="get">
            
            	<h4> <b> Manutencao Programada </b></h4>   
            	<br>
                <!-- Linhas de datepickers-->
                <div class="row"> <b>
                    <div class="col-md-3">
                        <!-- Date picker -->
                        <div>
                            Data Inicial: <input class="datepicker" type="text" name="date1">
                        </div>
                    </div>
                    <div class="col-md-3">
                        <!-- Date picker -->
                        <div>
                            Data Final: <input class="datepicker" type="text" name="date2">
                        </div>
                    </div>

                    <div class="col-md-3">
                        <!-- Date picker -->
                        <div>
                         Hora Inicial: <input class="datepicker" type="text" name="date3">
                        </div>                        
                    </div>
                    <div class="col-md-3">
                        <!-- Date picker -->
                        <div class="pull-right">
                         Hora Final: <input class="datepicker" type="text" name="date4">
                        </div>                        
                    </div></b>
                </div> <!--  fim da linha de datepickers -->
                
                
                
                <!-- Divisor da Abrangência -->
                <div class="row">
                	<br>
                	  <div class=col-md-1>
                	  	<p><b>Abrangencia</b></p>
                	  	
                	  </div>
                	  <div class="col-md-10">
                            <label class="radio-inline"><input type="radio" name="optradio">Todos</label>
							<label class="radio-inline"><input type="radio" name="optradio">Responsaveis</label>
							<label class="radio-inline"><input type="radio" name="optradio">Engressos</label>                            
                     </div>
                </div> <!-- Fim do divisor da Abrangência -->
                
                
                
	               <!-- Divisor do Motivo -->
               <div>
					    <div class="form-group">
					    <br>
					    <div class="pull-left">
					      <label class="control-label col-sm-1" for="email">Motivo</label>
					    </div>
					    
					      <div class="col-sm-12">
					        	<input type="email" class="form-control" name ="motivo" id="motivo" placeholder="Manutencao Preventiva">
					    </div>
					    </div>
				</div> <!-- Fim do Divisor do Motivo -->   
               	
               	
               	
               	<div> <!-- Divisor de Visualização da mensagem -->
					    <div class="form-group">
					      <label for="inputlg">Visualizacao da Mensagem</label>
					      <div class="col-md-13">
					            <textarea class="form-control" rows="9" placeholder="Insira aqui a mensagem" required></textarea>
					        </div>
					    </div>
                </div> <!-- Fim do Divisor de Visualização da mensagem -->
                
                
                
                <div class="pull-right">
				  <button type="submit" class="btn btn-info">Enviar</button>
				</div>
		</form>
        	</div> <!-- Divisor de manutenção -->
      </div> <!-- Divisor tab-content -->
    </div> <!-- Divisor panel-body -->
    
</BODY>
</HTML>