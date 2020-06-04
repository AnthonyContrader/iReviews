<%@page import="it.contrader.dto.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read User</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> <a class="active"
			href="/user/getall">Users</a> <a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			ReviewDTO u = (ReviewDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>user</th>
				<th>titolo</th>
				<th>testo</th>
				<th>esercizio</th>
				<th>esercizio</th>
			</tr>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getUser().getUsername()%></td>
				<td><%=u.getTitolo()%></td>
				<td><%=u.getTesto()%></td>
				<td><%=u.getEsercizio().getNome()%></td>
				<td><%=u.getVoto()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>