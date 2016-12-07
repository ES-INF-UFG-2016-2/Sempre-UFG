<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html lang="pt-br">

<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Sempre UFG</title>

<jsp:include page="../includes/header.jsp" />

</head>

<body>

	<div id="wrapper">

	<jsp:include page="../includes/navbar.jsp"/>

		<div id="page-wrapper">

			<div class="row">
				<div class="col-lg-12">
					<h2 style="padding-left: 10px;">Egressos</h2>
				</div>
				<!-- /.col-lg-12 -->
			</div>

			<!-- /.row -->
			<div class="row">

				<div class="col-lg-offset-1 col-lg-9">
					<div class="panel panel-default">
						<div class="panel-heading">Importar Egressos</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<form role="form">
										<fieldset id="career">
											<div class="row">
												<div class="col-lg-12">
													<div class="form-group">
														<label for="actuation">Período</label>
														<div id="actuation">
															<select id="periodoInicial" class="form-control"
																style="width: 15%; display: initial !important;">
																<option>2016.1</option>
															</select> 
															<label style="padding: 2px;">a</label> 
															<select id="periodoFinal" class="form-control"
																style="width: 15%; display: initial !important;">
																<option>2016.2</option>
															</select> 
															<label style="padding: 2px;">* Obrigatório</label>
														</div>
													</div>
												</div>
												<div class="col-lg-6">
													<div class="form-group">
														<label for="matricula_egresso">Matrícula do Egresso</label> 
														<input id="matricula_egresso" class="form-control" />
													</div>
													<div class="form-group">
														<label for="curso_ufg">Curso da UFG</label>
														<select id="curso_ufg" class="form-control">
															<option>Escolha o curso</option>
														</select>
													</div>
													<div class="form-group">
														<label for="unid_academica">Unidade Acadêmica</label>
														<select id="unid_academica" class="form-control">
															<option>Escolha a unidade acadêmica</option>
														</select>
													</div>
													<div class="form-group">
														<label for="regional">Regional</label>
														<select id="regional" class="form-control">
															<option>Escolha a unidade acadêmica</option>
														</select>
													</div>
												</div>
											</div>
										</fieldset>
										<input id="btn_importar" type="button" value="Importar"
											onClick="releaseEditLock(this)"
											class="btn btn-primary pull-right">
									</form>
								</div>
							</div>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-9 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->

	<jsp:include page="../includes/footer.jsp" />
	<jsp:include page="../includes/scripts.jsp" />
	<script src="../../js/atualizar_egresso/menunav.js"></script>
	<script src="../../js/atualizar_egresso/buttons.js"></script>

</body>

</html>
