<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ReviewDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Review</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a  href="ReviewServlet?mode=reviewlist">Users</a>
  <a class="active" href="ReviewServlet?mode=reviewlist">Review</a>
  <a href="LocalitaServlet?mode=localitalist">Località</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>

<div class="main">
<%ReviewDTO u = (ReviewDTO) request.getAttribute("dto"); %>


<table>
	<tr> 
		<th>Voto</th>
		<th>User_id</th>
		<th>Id_esercizio</th>
		<th>Testo</th>
		<th>Titolo</th>
	</tr>
	<tr>
		<td><%=u.getVoto()%></td>
		<td><%=u.getUser_id()%></td>
		<td> <%=u.getId_esercizio()%></td>
		<td> <%=u.getTesto()%></td>
		<td> <%=u.getTitolo()%></td>
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