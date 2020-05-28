
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="it.contrader.dto.TipologiaDTO" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Tipologia Manager</title>
</head>
<body>
	<%@ include file="../css/header.jsp" %>
	<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a class="active" href="TipologiaServlet?mode=tipologialist">Tipologia</a>
  <a href="LogoutServlet" id="logout">Logout</a>
  </div>
  
  <div class="main">
  	<%
  		List<TipologiaDTO> list = (List<TipologiaDTO>) request.getAttribute("list");
  	%>
  	<br>
  	<table>
  		<tr>
			<th>tipologia</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (TipologiaDTO u : list) {
		%>
		<tr>
			<td><a href=TipologiaServlet?mode=read&id=<%=u.getId()%>>
					<%=u.getTipo()%>
			</a></td>
			<td><a href=TipologiaServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>
			</td>
			<td><a href=TipologiaServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>
  
  <form id="floatright" action="TipologiaServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="tipo">tipologia</label>
    </div>
    <div class="col-75">
      <input type="text" id="tipo" name="tipo" placeholder="inserisci la tipologia">
    </div>
  </div>
      <button type="submit">Insert</button>
</form>
  </div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>