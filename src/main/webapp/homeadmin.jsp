<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Admin</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
<%@include file="css/header.jsp"%>


<div class="navbar">
  <a class="active" href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a  href="ReviewServlet?mode=reviewlist">Review</a>
  <a href="LocalitaServlet?mode=localitalist">Località</a>
  <a  href="TipologiaServlet?mode=tipologialist">Tipologia</a>
  <a  href="EsercizioServlet?mode=eserciziolist">Esercizio</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<div class="main">
<h1>Benvenuto ${user.getUsername()}</h1>
<h2>
Benvenuto sul sito di recensioni iReview, qua puoi realizzare le tue recensioni<br>
sulla tua esperienza, mi raccomando sii onesto perchè se non lo sarai ti verremo a cercare!<br>
Ora puoi iniziare a scrivere le tue opinioni,sperando siano costruttive per il miglioramento<br>
dei vari esercenti che recensisci. Buona recensione!!!</h2>


</div>


<%@ include file="css/footer.jsp" %>

</body>
</html>