<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.EsercizioDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Esercizio</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a class="active"  href="EsercizioServlet?mode=eserciziolist">Esercizi</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%EsercizioDTO u = (EsercizioDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>Codice</th>
		<th>Nome</th>
		<th>Prezzo medio</th>
		<th>Id Tipologia</th>
		<th>Indirizzo</th>
		<th>Id Città</th>
	</tr>
	<tr>
		<td><%=u.getCodice()%></td>
		<td> <%=u.getNome()%></td>
		<td> <%=u.getPrezzo_medio()%></td>
		<td> <%=u.getId_tipologia()%></td>
		<td> <%=u.getIndirizzo()%></td>
		<td> <%=u.getId_citta()%></td>
	</tr>	
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>
</body>
</html>