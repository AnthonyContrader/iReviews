<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.EsercizioDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Esercizio</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
 <a href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a href="ReviewServlet?mode=reviewlist">Review</a>
  <a href="LocalitaServlet?mode=localitalist">Località</a>
  <a href="TipologiaServlet?mode=tipolist">Tipologia</a>
  <a class="active" href="EsercizioServlet?mode=userlist">Esercizio</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%EsercizioDTO u = (EsercizioDTO) request.getAttribute("dto");%>


<form id="floatleft"  action="EsercizioServlet?mode=update&codice=<%=u.getCodice()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="name">Nome</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="nome" value=<%=u.getNome()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="med-price">Prezzo Medio</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="med-price" name="prezzo_medio" value=<%=u.getPrezzo_medio()%>> 
    </div>
  </div>
 <div class="row">
    <div class="col-25">
     <label for="id_type">Id tipologia</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="id_type" name="id_tipologia" value=<%=u.getId_tipologia()%>> 
    </div>
  </div>
   <div class="row">
    <div class="col-25">
     <label for="address">Indirizzo</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="address" name="indirizzo" value=<%=u.getIndirizzo()%>> 
    </div>
  </div>
  
   <div class="row">
    <div class="col-25">
     <label for="city-id">Id città</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="city-id" name="id_citta" value=<%=u.getId_citta()%>> 
    </div>
  </div>
      <button type="submit" >Edit</button>
      <!--  -->
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>