<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Consulta - Mapa</title>

    <jsp:include page="../includes/header.jsp"/>

</head>

<body>

    <div id="wrapper">

        <jsp:include page="../includes/navbar.jsp"/>

        <div id="page-wrapper">
			<br>
            <div class="row">
                <div class="col-lg-8">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-map fa-fw"></i> Localizações no Mapa
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div id="map" style="width:100%;height:100%"></div>
                        </div>
                        <!-- /.panel-body -->
					</div>
				</div>
				<!-- /.col-lg-8 -->

				<div class="col-lg-4">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-info-circle fa-fw"></i> Detalhes da Consulta (por cidade)
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="list-group" id="detailsByCity">

							</div>
							<!-- /.list-group -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-4 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->

	<div id="cityModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" id="cityModalTitle"></h4>
				</div>
				<div id="cityModalBody" class="modal-body">

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

    <jsp:include page="../includes/footer.jsp"/>
    <jsp:include page="../includes/scripts.jsp"/>
	<script src="../../js/mapa/mapa.js"></script>
	<script src="https://maps.googleapis.com/maps/api/js?callback=initMap"></script>

</body>

</html>
