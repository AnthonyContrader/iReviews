<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.ReviewDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>User Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="ReviewServlet?mode=reviewlist">Review</a>
  <a href="LocalitaServlet?mode=localitalist">Località</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<ReviewDTO> list = (List<ReviewDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Voto</th>
			<th>User_id</th>
			<th>Id_esercizio</th>
			<th>Testo</th>
			<th>Titolo</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (ReviewDTO u : list) {
		%>
		<tr>
			<td><a href=ReviewServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getVoto()%>
			</a></td>
			<td><%=u.getUser_id()%></td>
			<td><%=u.getId_esercizio()%></td>
			<td><%=u.getTesto()%></td>
			<td><%=u.getTitolo()%></td>
			<td><a href=ReviewServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>
			</td>
			<td><a href=ReviewServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>
	
	<form id="floatright" action="ReviewServlet?mode=insert" method="post">
  <div class="row">   
    <div class="col-75">
      <input type="text" id="voto" name="voto" placeholder="inserisci voto">
    </div>
     <div class="col-75">
      <input type="text" id="user_id" name="user_id" placeholder="inserisci user_id">
    </div>
     <div class="col-75">
      <input type="text" id="id_esercizio" name="id_esercizio" placeholder="inserisci id_esercizio">
    </div>
     <div class="col-75">
      <input type="text" id="testo" name="testo" placeholder="testo">
    </div>
     <div class="col-75">
      <input type="text" id="titolo" name="titolo" placeholder="inserisci titolo">
    </div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>