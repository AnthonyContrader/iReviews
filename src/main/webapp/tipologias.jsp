<%@ page import="it.contrader.dto.TipologiaDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>User Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a>
		<a class="active" href="/tipologia/getall">Tipologia</a>
		<a href=/localita/getall>Località</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<TipologiaDTO> list = (List<TipologiaDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Tipologia</th>				
				<th></th>
				<th></th>
			</tr>
			<%
				for (TipologiaDTO u : list) {
			%>
			<tr>
				<td><a href="/tipologia/read?id=<%=u.getId()%>">
				<%=u.getTipologia()%>
				</a></td>				
				<td><a href="/tipologia/preupdate?id=<%=u.getId()%>">Edit</a></td>


				<td><a href="/tipologia/delete?id=<%=u.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/tipologia/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="tipologia">Tipologia</label>
				</div>
				<div class="col-75">
					<input type="text" id="tipologia" name="tipologia"
						placeholder="inserisci tipologia">
				</div>
			
			</div>
			
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>