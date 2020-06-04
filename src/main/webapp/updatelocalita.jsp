<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.LocalitaDTO"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Localita Edit page">
<meta name="author" content="Daniele Leonardi">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Località</title>
</head>

<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
 	<a  href="/homeadmin.jsp">Home</a> 
	<a href="/user/getall">Users</a>
	<a href="/esercizio/getall">Esercizio</a>
	<a href="/review/getall">Review</a>
	<a href="/tipologia/getall">Tipologia</a>
	<a class="active" href=/localita/getall>Località</a>
	<a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%LocalitaDTO l = (LocalitaDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/localita/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="citta">Città</label>
    </div>
    <div class="col-75">
      <input type="text" id="citta" name="citta" value=<%=l.getCitta()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Provincia</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="provincia" name="provincia" value=<%=l.getProvincia()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="text">Stato</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="stato" name="stato" value=<%=l.getStato()%>> 
    	</div>
    	<input type="hidden" name="id" value =<%=l.getId() %>>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>