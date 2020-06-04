<%@page import="java.util.List"%>
<%@page import="it.contrader.model.User"%>
<%@page import="it.contrader.dto.EsercizioDTO"%>
<%@page import="it.contrader.dto.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.UserDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Review</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
 	<a  href="/homeadmin.jsp">Home</a> 
	<a href="/user/getall">Users</a>
	<a href="/esercizio/getall">Esercizio</a>
	<a class="active" href="/review/getall">Review</a>
	<a href="/tipologia/getall">Tipologia</a>
	<a href="/localita/getall">Localit�</a>
	<a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">
<%
ReviewDTO u = (ReviewDTO) request.getSession().getAttribute("dto");
List<UserDTO> listUser = (List<UserDTO>) request.getSession().getAttribute("listUser");
List<EsercizioDTO> listEsercizio = (List<EsercizioDTO>) request.getSession().getAttribute("listEsercizio");
 %>
<form id="floatleft" action="/review/update" method="post">
<div class="row">
			<div class="col-25">
				<label for="username">Username</label>
			</div>
		<div class="col-75">
 				<select id="user" name="user" required>
 					<option value="" disabled selected>Seleziona il tuo username</option>
 					<% 			
						for (UserDTO c : listUser) {
							%> <option value="<%=c.getId()%>"><%=c.getUsername()%></option> <%
						}%> 
				</select>
    		</div>
    	</div>
			<div class="row">
				<div class="col-25">
					<label for="titolo">Titolo</label>
				</div>
				<div class="col-75">
					<input type="text" id="titolo" name="titolo"
						placeholder="inserisci il titolo">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="testo">Testo</label>
				</div>
				<div class="col-75">
					<input type="text" id="testo" name="testo"
						placeholder="inserisci il testo">
				</div>
			</div>
			
			<div class="row">
    		<div class="col-25">
      			<label for="type">Esercizio</label>
    		</div>
   		 	<div class="col-75">
 				<select id="esercizio" name="esercizio" required>
 					<option value="" disabled selected>Seleziona l'esercizio</option>
 					<% 			
						for (EsercizioDTO t : listEsercizio) {
							%> <option value="<%=t.getCodice()%>"><%=t.getNome()%></option> <%
						}%> 
				</select>
    		</div>
  			</div>
  			<div class="row">
				<div class="col-25">
					<label for="titolo">voto</label>
				</div>
				<div class="col-75">
					<input type="text" id="voto" name="voto"
						placeholder="inserisci il voto">
				</div>
			</div>		
				 <input type="hidden" name="id" value=<%=u.getId()%>>
			<button type="submit">Edit</button>
		</form>

	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>