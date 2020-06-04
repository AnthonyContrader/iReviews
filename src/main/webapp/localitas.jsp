<%@ page import="it.contrader.dto.LocalitaDTO" import="java.util.*"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Località Management">
<meta name="author" content="Daniele Leonardi">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Località Manager</title>

</head>
<body>
	<%@ include file="./css/header.jsp"%>

	<div class="navbar">
		<a  href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a>
		<a  href="/esercizio/getall">Esercizio</a>
		<a href="/review/getall">Review</a>
		<a href="/tipologia/getall">Tipologia</a>
		<a class="active" href=/localita/getall>Località</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<div class="main">
		<%
			List<LocalitaDTO> list = (List<LocalitaDTO>) request.getSession().getAttribute("list");
		%>

		<br>

		<table>
			<tr>
				<th>Città</th>
				<th>Provincia</th>
				<th>Stato</th>
				<th></th>
				<th></th>
			</tr>
			<%
				for (LocalitaDTO u : list) {
			%>
			<tr>
				<td><a href="/localita/read?id=<%=u.getId()%>"> <%=u.getCitta()%>
				</a></td>
				<td><%=u.getProvincia()%></td>			
				<td><%=u.getStato()%></td>
				<td><a href="/localita/preupdate?id=<%=u.getId()%>">Edit</a></td>


				<td><a href="/localita/delete?id=<%=u.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>



		<form id="floatright" action="/localita/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="citta">Città</label>
				</div>
				<div class="col-75">
					<input type="text" id="citta" name="citta"
						placeholder="inserisci la città">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="provincia">Provincia</label>
				</div>
				<div class="col-75">
					<input type="text" id="provincia" name="provincia"
						placeholder="inserisci la provincia">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="text">Stato</label>
				</div>
				<div class="col-75">
					<input type="text" id="stato" name="stato"
						placeholder="inserisci lo stato">
				</div>
			</div>
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>