<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="it.contrader.dto.TipologiaDTO" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a href="ReviewServlet?mode=reviewlist">Users</a>
  <a href="ReviewServlet?mode=reviewlist">Review</a>  
  <a href="LocalitaServlet?mode=localitalist">Località</a>
  <a class="active" href="TipologiaServlet?mode=tipolist">Tipologia</a>
  <a href="EsercizioServlet?mode=eserciziolist">Esercizio</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%TipologiaDTO u = (TipologiaDTO) request.getAttribute("dto");%>


<table>
	<tr> 
		<th>tipologia</th>
		
	</tr>
	<tr>
		<td><%=u.getTipo()%></td>
		
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