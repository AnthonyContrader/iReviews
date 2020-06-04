<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.LocalitaDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Localita Read">
<meta name="author" content="Daniele Leonardi">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Localit�</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
	 <a  href="/homeadmin.jsp">Home</a> 
			<a href="/user/getall">Users</a>
		<a  href="/esercizio/getall">Esercizio</a>
		<a href="/review/getall">Review</a>
		<a href="/tipologia/getall">Tipologia</a>
		<a class="active" href=/localita/getall>Localit�</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			LocalitaDTO u = (LocalitaDTO) request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>Citt�</th>
				<th>Provincia</th>
				<th>Stato</th>
			</tr>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getCitta()%></td>
				<td><%=u.getProvincia()%></td>
				<td><%=u.getStato()%></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>