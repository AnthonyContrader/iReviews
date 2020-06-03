<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.TipologiaDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>

</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a>
		<a class="active" href="/tipologia/getall">Tipologia</a>
		<a href=/localita/getall>Località</a>
		<a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%TipologiaDTO u = (TipologiaDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/tipologia/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="tipologia">Tipologia</label>
    </div>    
    <div class="col-75">
      <input type="text" id="tipologia" name="tipologia" value=<%=u.getTipologia()%>>
    </div>
    <input type="hidden" name="id" value=<%=u.getId() %>>
      </div>  
      <button type="submit" >Edit</button>
</form>
</div>
<br>
<%@ include file="./css/footer.jsp" %>	
</body>
</html>