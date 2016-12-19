<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html lang="pt-br">

<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Divulgação Evento</title>

<jsp:include page="../includes/header.jsp" />

</head>

<body>

	<div id="wrapper">

		<jsp:include page="../includes/navbar.jsp" />

		<div id="page-wrapper">

			<div class="row">
				<div class="col-lg-12">
					<h2 style="padding-left: 10px;">Evento</h2>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->

			<div class="row">
				<div class="col-lg-offset-1 col-lg-9">
					<div class="panel panel-default">
						<div class="panel-heading">Divulgação Evento Comunidade</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<form role="form">
										<fieldset id="info_evento">
											<div class="row">
												<div class="col-lg-12">
													<div class="col-lg-8">
														<label>Evento</label> <select class="form-control"
															id="select">
															<option>Fim de Ano</option>
															<option>CBSoft 2017</option>
															<option>Campus Party 2017</option>
															<option>FLISol</option>
															<option>LATINOWARE</option>
														</select>
														<br></br>
														<div class="form-group">
															<label>Contatos a receberem a mensagem</label>
															<textarea id="matricula_egresso" class="form-control"
																placeholder="Insira os e-mails separados por ponto e virgula (;)" /></textarea>
														</div>
														<div class="form-group">
															<label>Propriedades do evento a serem divulgadas</label>
															<div class="checkbox">
																<label><input type="checkbox" value="">Assunto</label>
															</div>
															<div class="checkbox">
																<label><input type="checkbox" value="">Tipo
																	do Evento</label>
															</div>
															<div class="checkbox">
																<label><input type="checkbox" value="">Descrição
																	do Evento</label>
															</div>
															<div class="checkbox">
																<label><input type="checkbox" value="">Data
																	e hora da solicitação</label>
															</div>
															<div class="checkbox">
																<label><input type="checkbox" value="">Solicitante</label>
															</div>
															<div class="checkbox">
																<label><input type="checkbox" value="">E-mail
																	do Solicitante</label>
															</div>
															<div class="checkbox">
																<label><input type="checkbox" value="">Forma
																	de Divulgação</label>
															</div>
															<div class="checkbox">
																<label><input type="checkbox" value="">Escopo
																	da Divulgação</label>
															</div>
															<div class="checkbox">
																<label><input type="checkbox" value="">Data
																	de Expiração</label>
															</div>
														</div>
													</div>
												</div>
											</div>
										</fieldset>
										<input id="btn_enviar_analise" type="button"
											value="Enviar Para Análise"
											class="btn btn-primary pull-right" onclick=""> <input
											id="btn_cancelar" type="button" value="Cancelar"
											class="btn btn-secondary pull-right" onclick="">
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