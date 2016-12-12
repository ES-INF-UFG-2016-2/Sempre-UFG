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
<script type="text/javascript">
	$(document).ready(function() {
		$('#myTable').dataTable();
	});
</script>
</head>
<body>
	<div id="wrapper">
		<%-- 		    <jsp:include page="../includes/navbar.jsp"/> --%>
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
						<div class="panel-heading">Resultados da importação</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<form role="form" name="frm" method="post">
										<fieldset id="career">
											<div class="row">
												<div class="col-lg-12">
													<h4>Estatísticas de importação</h4>
													<div class="form-group">
														<label for="totalExpoCercomp">Total de egressos exportados pelo CERCOMP:</label>
														<output id="totalExpoCercomp" style="width: 15%; display: initial !important;">${totalExportadoCercomp}</output>
													</div>
													<div class="form-group">
														<label for="totalImportadoSucesso">Total de egressos importados com sucesso:</label>
														<output id="totalImportadoSucesso" style="width: 15%; display: initial !important;">${totalImportadoSucesso}</output>
													</div>
													<div class="form-group">
														<label for="totalNaoImportadoErro">Total de egressos não importados devido a erros:</label>
														<output id="totalNaoImportadoErro" style="width: 15%; display: initial !important;">${totalNaoImportadoErro}</output>
													</div>
													<div class="form-group">
														<label for="totalNaoImportadoReplicacao">Total de egressos não importados devido a replicação:</label>
														<output id="totalNaoImportadoReplicacao" style="width: 15%; display: initial !important;">${totalNaoImportadoReplicacao}</output>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-lg-12">
													<div id="panel" class="panel panel-default">
														<!-- Default panel contents -->
														<div class="panel-heading">Lista de egressos exportados pelo CERCOMP</div>
														<div class="panel-body">
															<div class="form-group">
																<label>Filtros:</label> <select id="periodo" name="periodo" class="form-control" style="width: 10%; display: initial !important;"
																	onchange="javascript:document.frm.submit();">
																	<option value="">Periodo</option>
																	<c:forEach items="${listaPeriodo}" var="periodo">
																		<option value="${periodo}" ${periodo == periodoSelect ? 'selected' : '' }>${periodo}</option>
																	</c:forEach>
																</select> <select id="curso" name="curso" onchange="javascript:document.frm.submit();" class="form-control"
																	style="width: 20%; display: initial !important;">
																	<option>Filtrar por curso</option>
																	<c:forEach items="${listaCursoUFG}" var="curso">
																		<option value="${curso.nome}" ${curso.nome == cursoSelect ? 'selected' : '' }>${curso.nome}</option>
																	</c:forEach>
																</select> <select id="unidadeAcademica" name="unidadeAcademica" onchange="javascript:document.frm.submit();" class="form-control"
																	style="width: 25%; display: initial !important;">
																	<option value="">Filtrar por unidade acadêmica</option>
																	<c:forEach items="${listaUnidadeAcademica}" var="unidade">
																		<option value="${unidade}" ${unidade == unidadeAcademicaSelect ? 'selected' : '' }>${unidade}</option>
																	</c:forEach>
																</select> <select id="regional" name="regional" onchange="javascript:document.frm.submit();" class="form-control"
																	style="width: 18%; display: initial !important;">
																	<option value="">Filtrar por regional</option>
																	<c:forEach items="${listaRegional}" var="regional">
																		<option value="${regional}" ${regional == regionalSelect ? 'selected' : '' }>${regional}</option>
																	</c:forEach>
																</select> <select id="status" name="status" onchange="javascript:document.frm.submit();" class="form-control"
																	style="width: 17%; display: initial !important;">
																	<option value="">Filtrar por status</option>
																	<c:forEach items="${listaStatus}" var="status">
																		<option value="${status}" ${status == statusSelect ? 'selected' : '' }>${status}</option>
																	</c:forEach>
																</select>
															</div>
														</div>
														<!-- Table -->
														<table id="myTable" class="table table-hover table-bordered">
															<thead>
																<tr>
																	<th>Id</th>
																	<th>Nome</th>
																	<th>Curso</th>
																	<th>Unidade Acadêmica</th>
																	<th>Regional</th>
																	<th>Status</th>
																	<th>Informação de Importação</th>
																</tr>
															</thead>
															<tbody>
																<c:forEach var="egresso" items="${listaEgresso}">
																	<tr>
																		<td>${egresso.id}</td>
																		<td>${egresso.nome}</td>
																		<td>${egresso.nome}</td>
																		<td>${egresso.nome}</td>
																		<td>${egresso.nome}</td>
																		<td>${egresso.nome}</td>
																		<td>${egresso.nome}</td>
																	</tr>
																</c:forEach>
															</tbody>
														</table>
														<div class="panel-footer" style="padding: 0px !important;">
															<div style="text-align: center;">
																<%--For displaying Page numbers.--%>
																<ul class="pagination">
																	<c:forEach begin="1" end="${noOfPages}" var="i">
																		<li><a href="/SempreUFG/pages/import_egres_period/resultado_importacao?page=${i}#panel">${i}</a></li>
																	</c:forEach>
																</ul>
															</div>
														</div>
													</div>
												</div>
											</div>
										</fieldset>
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
