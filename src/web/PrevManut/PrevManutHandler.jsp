<html>
<body>
	<%
	// Grab the variables from the form.
  	String date= request.getParameter("date1");
	%>

<%-- Print out the variables. --%>
<h1>Hello! date: <%=date%></h1>
</body>
</html>