<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.LocalitaDTO"	import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Localita</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a class="active" href="LocalitaServlet?mode=localitalist">Località</a>
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%LocalitaDTO l = (LocalitaDTO) request.getAttribute("dto");%>


<form id="floatleft" action="LocalitaServlet?mode=update&id=<%=l.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="localita">Città</label>
    </div>
    <div class="col-75">
      <input type="text" id="localita" name="citta" value=<%=l.getCitta()%>>
    </div>
  </div>
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>