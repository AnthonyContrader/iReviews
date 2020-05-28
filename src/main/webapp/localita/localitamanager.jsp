<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.LocalitaDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Località Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a href="ReviewServlet?mode=reviewlist">Review</a>
  <a class="active" href="LocalitaServlet?mode=localitalist">Località</a>
  <a  href="TipologiaServlet?mode=tipologialist">Tipologia</a>
  <a  href="EsercizioServlet?mode=eserciziolist">Esercizio</a>  
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<LocalitaDTO> list = (List<LocalitaDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
			<th>Città</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (LocalitaDTO u : list) {
		%>
		<tr>
			<td><a href=LocalitaServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getCitta()%>
			</a></td>
			<td><a href=LocalitaServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>
			</td>
			<td><a href=LocalitaServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="LocalitaServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="citta">Città</label>
    </div>
    <div class="col-75">
      <input type="text" name="citta" placeholder="inserisci la città">
    </div>
  </div>
  	  <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>