<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Apresenta Planilha Egresso</title>
	
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

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Sempre UFG</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <!-- retirada tag ul -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <!--  retirada tag ul -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <!--  retirada tag ul -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <!--  retirada tag ul -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- Menu lateral -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Charts<span class="fa arrow"></span></a>
                            <!--  retirada tag ul -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-table fa-fw"></i> Tables</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-edit fa-fw"></i> Forms</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> UI Elements<span class="fa arrow"></span></a>
                            <!--  retirada tag ul -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
                            <!--  retirada tag ul -->
                        </li>
                        <li class="active">
                            <a href="#"><i class="fa fa-files-o fa-fw"></i> Sample Pages<span class="fa arrow"></span></a>
                            <!--  retirada tag ul -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Título e subtítulo -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Nome da Consulta</h1>
						<h4 class="text-right">Consulta pública</h4>
                    </div>
                </div>
                <!-- Tabela de resultante -->
            </div>
			<div <div class="col-lg-3">
				<div class="panel panel-primary text-ri">
                        <div class="panel-heading">
                            Campos selecionados
                        </div>
                        <div class="panel-body">
                            <div>
                                <table class="table table-striped">
                                    <tbody>
                                        <tr>
                                            <td>Curso</td>
                                        </tr>
																				<tr>
                                            <td>Nome Egresso</td>
                                        </tr>
																				<tr>
                                            <td>Código Área</td>
                                        </tr>
																				<tr>
                                            <td>Nome Instituição de Ensino Médio</td>
                                        </tr>
																				<tr>
                                            <td>Turno</td>
                                        </tr>
																				<tr>
                                            <td>Cidade de Origem</td>
                                        </tr>
																				<tr>
                                            <td>Sexo</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
				</div>
			</div>
				
			<div <div class="col-lg-9">	
				<div id="dataTables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
					<div class="col-sm-12">
						<table width="100%" class="table table-striped table-bordered table-hover dataTable no-footer dtr-inline" id="dataTables-example" role="grid" aria-describedby="dataTables-example_info" style="width: 100%;">
							<thead>
								<tr role="row">
									<th class="text-center" style="width: 78px;">Sexo</th>
									<th class="text-center" style="width: 78px;">Curso</th>
									<th class="text-center" style="width: 78px;">Cidade de Origem</th>
									<th class="text-center" style="width: 78px;">Turno</th>
									<th class="text-center" style="width: 78px;">Código Área</th>
									<th class="text-center" style="width: 78px;">Nome Instituição Ensino Médio</th>
									<th class="text-center" style="width: 78px;">Nome Egresso</th>
								</tr>
							</thead>
							<tbody>  
								<tr class="gradeA odd" role="row">
									<td>Masculino</td>
									<td>Engenharia de Software</td>
									<td>Goiânia</td>
									<td>Matutino</td>
									<td>1001</td>
									<td>Colégio Santo Agostinho</td>
									<td>João da Silva</td>
								</tr>
								<tr class="gradeA even" role="row">
									<td>Feminino</td>
									<td>Medicina</td>
									<td>Campo Grande</td>
									<td>Vespertino</td>
									<td>1004</td>
									<td>Colégio Ávila</td>
									<td>Amanda Cardoso</td>
								</tr>
								<tr class="gradeA odd" role="row">
									<td>Masculino</td>
									<td>Geografia</td>
									<td>Itumbiara</td>
									<td>Noturno</td>
									<td>1005</td>
									<td>Colégio Visão</td>
									<td>Renato Vieira</td>
								</tr>
							</tbody>
						</table>
					</div>
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

</body>

</html>
