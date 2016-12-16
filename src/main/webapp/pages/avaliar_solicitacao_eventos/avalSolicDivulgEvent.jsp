<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<% List eventos = (List)session.getAttribute("evento"); %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Solicitação de Divulgação de Evento</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="avalSolicDivulgEvent.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
    <nav class="navbar navbar-default">
        <div container-fluid>
            <div navbar-header>
                <a id="title" class="navbar-brand" href="#">Sempre UFG</a>
            </div>
        </div>
    </nav>
    <div id="lateral">
        <!-- TODO: implementar a visualização de sidebar-->
    </div>
    <div id="forms">
        <div class="divulgarEventoTitle">
            <h3>Solicitações para Divulgação de Evento</h3>
            <hr id="hrtitle" />
        </div>
        <div class="listaSolicitacoes">
            <table id="tablelist">
                <thead>
                    <th class="thlist">
                        Título do Evento
                    </th>
                </thead>
                <tbody>
                    <form class="listForm" action="descricaoEvento." method="post">
                        <!-- <c:forEach var="evento" items="${dao.eventos}" varStatus="id"> -->
                        <tr>
                            <td class="tdlist">
                                <div class="tituloEvento">
                                    <p>Evento de Fulano teste</p>
                                    <c:out value="{evento.assunto}" />
                                    <input type="hidden" id="assunto" name="contador" value="${evento.assunto}">
                                    <input type="hidden" id="descricao" name="contador" value="${evento.des_evento}">
                                    <input type="hidden" id="solicitacao" name="contador" value="${evento.data-solicitacao}">
                                    <input type="hidden" id="expiracao" name="contador" value="${evento.data_expiracao}">
                                    <input type="hidden" id="idSolicitante" name="contador" value="${evento.id_solicitante}">
                                    <input type="hidden" name="contador" value="${id.count}">
                                </div>
                            </td>
                            <td class="tdlistButton">
                                <input type="button" class="btn btn-primary" data-toggle="modal" data-target="#eventoModal" name="abreEvento" value="Visualizar">
                            </td>
                        </tr>
                        <!-- este próximo <tr> é destinado a testes. TODO: retirar caso entre em produção -->
                        <tr>
                            <td class="tdlist">
                                <div class="tituloEvento">
                                    <p>Evento de Ciclano teste</p>
                                    <c:out value="{evento.assunto}" />
                                    <input type="hidden" name="contador" value="${id.count}">
                                </div>
                            </td>
                            <td class="tdlistButton">
                                <input type="button" class="btn btn-primary" data-toggle="modal" onclick="setaDadosModal(${id.count})" data-target="#eventoModal" name="abreEvento" value="Visualizar">
                            </td>
                        </tr>
                        <!-- </c:forEach> -->
                    </form>
                </tbody>
            </table>
        </div>
    </div>
    <div id="sidebarTitle">
        <div id="sidebarColor">
        </div>
        <p id="textSidebar">Solicitações Eventos</p>
    </div>

    <!-- modal Main -->

    <div class="modal fade" id="eventoModal" role="dialog">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Detalhamento da solicitação</h4>
                </div>
                <div class="modal-body">
                    <label for="recipient-name" class="control-label" id="assunto">Assunto:</label>
                    <p id="assuntoModal"></p>
                    <hr>
                    <label for="recipient-name" class="control-label" id="tipo">Tipo:</label>
                    <p id="tipoModal"></p>
                    <hr>
                    <label for="recipient-name" class="control-label" id="descricao">Descrição:</label>
                    <p id="descricaoModal"></p>
                    <hr>
                    <label for="recipient-name" class="control-label" id="solicitacao">Data Solicitação:</label>
                    <p id="solicitacaoModal"></p>
                    <hr>
                    <label for="recipient-name" class="control-label" id="expirar">Data Expirar:</label>
                    <p id="expirarModal"></p>
                    <hr>
                    <label for="recipient-name" class="control-label" id="id">ID solicitante:</label>
                    <p id="idModal"></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-toggle="modal" data-target="#closeModal">Negar</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal">Aceitar</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal Close-->

<div class="modal fade" id="closeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="exampleModalLabel">Negar solicitação de divulgação do evento</h4>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="form-group">
                            <label for="recipient-name" class="control-label">Negação</label>
                            <hr>
                        </div>
                        <div class="form-group">
                            <label for="message-text" class="control-label">Parecer:</label>
                            <textarea class="form-control" id="message-text" placeholder="Descreva aqui o parecer da negação"></textarea>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" id="cancelarModalParecer">Cancelar</button>
                    <button type="button" class="btn btn-primary" id="parecer">Enviar</button>
                </div>
            </div>
        </div>
    </div>
</body>

<script type="text/javascript">
    var assunto = document.getElementById('assunto');
    var descricaoJS = document.getElementById('descricao')
    var solicitacaoJS = document.getElementById('solicitacao')
    var expiracao = document.getElementById('expiracao')
    var id = document.getElementById('idSolicitante')

    document.getElementById("assuntoModal").innerHTML = assunto;
    document.getElementById("descricaoModal").innerHTML = descricaoJS;
    document.getElementById("solicitacaoModal").innerHTML = solicitacaoJS;
    document.getElementById("expiracaoModal").innerHTML = expiracao;
    document.getElementById("idModal").innerHTML = id;
</script>
<script type="text/javascript">
    $('#closeModal').on('show.bs.modal', function(event) {
        var button = $(event.relatedTarget)
        var recipient = button.data('whatever')
        var modal = $(this)
        modal.find('.modal-title').text('Negar solicitação de divulgação do evento')
        modal.find('.modal-body input').val(recipient)
    })
</script>

</html>