<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt-br">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Sempre UFG</title>
<jsp:include page="../includes/header.jsp" />
<style type="text/css">
.erro {
	font-weight: bold;
	color: red; margin-top : 10px;
	margin-bottom: 10px;
	margin-top: 10px;
	margin-top: 10px;
}
</style>
</head>
<body>
	<div id="wrapper">
		<%-- 	<jsp:include page="../includes/navbar.jsp"/> --%>
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
									<form role="form" method="get">
										<fieldset id="career">
											<div class="row">
												<div class="col-lg-12">
													<div class="form-group">
														<div class="erro">${mensagem}</div>
														<label for="actuation">Período</label>
														<div id="actuation">
															<select id="periodoInicial" name="periodoInicial" class="form-control" style="width: 15%; display: initial !important;">
																<option value="">Período inicial</option>
																<c:forEach items="${listaPeriodo}" var="periodo">
																	<option value="${periodo}">${periodo}</option>
																</c:forEach>
															</select> <label style="padding: 2px;">a</label> <select id="periodoFinal" name="periodoFinal" class="form-control"
																style="width: 15%; display: initial !important;">
																<option value="">Período final</option>
																<c:forEach items="${listaPeriodo}" var="periodo">
																	<option>${periodo}</option>
																</c:forEach>
															</select> <label style="padding: 2px;">* Obrigatório</label>
														</div>
													</div>
												</div>
												<div class="col-lg-6">
													<div class="form-group">
														<label for="matriculaEgresso">Matrícula do Egresso</label> <input id="matriculaEgresso" name="matriculaEgresso" class="form-control" />
													</div>
													<div class="form-group">
														<label for="cursoUfg">Curso da UFG</label> <select id="cursoUfg" name="cursoUfg" class="form-control">
															<option value="">Escolha o curso</option>
															<c:forEach items="${listaCursoUFG}" var="curso">
																<option value="${curso.nome}">${curso.nome}</option>
															</c:forEach>
														</select>
													</div>
													<div class="form-group">
														<label for="unidadeAcademica">Unidade Acadêmica</label> <select id="unidadeAcademica" name="unidadeAcademica" class="form-control">
															<option value="">Escolha a unidade acadêmica</option>
															<c:forEach items="${listaUnidadeAcademica}" var="unidade">
																<option value="${unidade}">${unidade}</option>
															</c:forEach>
														</select>
													</div>
													<div class="form-group">
														<label for="regional">Regional</label> <select id="regional" name="regional" class="form-control">
															<option value="">Escolha a regional</option>
															<c:forEach items="${listaRegional}" var="regional">
																<option value="${regional}">${regional}</option>
															</c:forEach>
														</select>
													</div>
												</div>
											</div>
										</fieldset>
										<input id="btn_importar" type="submit" value="Importar" formmethod="post" class="btn btn-primary pull-right">
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
