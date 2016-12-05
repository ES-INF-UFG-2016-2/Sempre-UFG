<html>
<body>
	
	<%@ page import="br.ufg.inf.sempreufg.modelo.MensagemManutencao" %>
	<%@ page import="br.ufg.inf.sempreufg.utils.PrevManutStub" %>
	<%
	// Grab the variables from the form.
  	String dataInicial= request.getParameter("dataInicial");
	String dataFinal = request.getParameter( "dataFinal");
	String horaInicial = request.getParameter("horaInicial");
	String horaFinal = request.getParameter("horaFinal");
	String abrangencia = request.getParameter("optradio");
	String motivo = request.getParameter("motivo");
	String mensagem = request.getParameter("mensagem");
	
	MensagemManutencao msg = new MensagemManutencao(dataInicial, dataFinal, horaInicial, horaFinal, abrangencia, motivo, mensagem);
	PrevManutStub prevManut = new PrevManutStub();
	prevManut.enviarMensagemManutencao(msg);
	
	%>

<%-- Print out the variables. --%>
<h1>data inicial: <%=dataInicial%></h1>
<h1>data final: <%=dataFinal%></h1>
<h1>hora inicial: <%=horaInicial%></h1>
<h1>hora final: <%=horaFinal%></h1>
<h1>abrangencia: <%=abrangencia%></h1>
<h1>motivo: <%=motivo%></h1>
<h1>mensagem: <%=mensagem%></h1>
</body>
</html>