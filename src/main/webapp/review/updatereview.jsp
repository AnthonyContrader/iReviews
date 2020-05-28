<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ReviewDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit User</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a  href="UserServlet?mode=userlist">Users</a>
  <a  class="active" class="active" href="ReviewServlet?mode=reviewlist">Review</a>
  <a  href="LocalitaServlet?mode=localitalist">Località</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%ReviewDTO u = (ReviewDTO) request.getAttribute("dto");%>

	<form id="floatleft" action="ReviewServlet?mode=update&id=<%=u.getId()%>" method="post">
  <div class="row">
    
    <div class="col-75">
      <input type="text" id="voto" name="voto" value=<%=u.getVoto()%>>
    </div>
    <div class="col-75">
      <input type="text" id="user_id" name="user_id" value=<%=u.getUser_id()%>>
    </div>
    <div class="col-75">
      <input type="text" id="id_esercizio" name="id_esercizio" value=<%=u.getId_esercizio()%>>
    </div>
    <div class="col-75">
      <input type="text" id="testo" name="testo" value=<%=u.getTesto()%>>
    </div>
    <div class="col-75">
      <input type="text" id="titolo" name="titolo" value=<%=u.getTitolo()%>>
    </div> 
   
  </div>
      <button type="submit" >Edit</button>
</form>
	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>