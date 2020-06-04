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
  <a  href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a>
		<a class="active" href="/esercizio/getall">Esercizio</a>
		<a href="/review/getall">Review</a>
		<a href="/tipologia/getall">Tipologia</a>
		<a  href=/localita/getall>Località</a>
		<a href="/user/logout" id="logout">Logout</a>
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
		<td> <%=u.getTipologia()%></td>
		<td> <%=u.getIndirizzo()%></td>
		<td> <%=u.getLocalita()%></td>
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