<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.EsercizioDTO"
	import="it.contrader.dto.LocalitaDTO"
	import="it.contrader.dto.TipologiaDTO"%>
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
<a href="/user/getall">Users</a>
  <a href="/review/getall">Review</a>
  <a  href="/localita/getall">Località</a>
  <a class="active" href="/tipologia/getall">Tipologia</a>
  <a  href="/esercizio/getall">Esercizio</a>  
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%EsercizioDTO e= (EsercizioDTO) request.getAttribute("dto");
         
	    List<LocalitaDTO> listloc = (List<LocalitaDTO>) request.getSession().getAttribute("listLocalita");
	    List<TipologiaDTO> listtip = (List<TipologiaDTO>) request.getSession().getAttribute("listTipologia");
	    %>

<form id="floatleft" action="/esercizio/update" method="post">

<div class="row">
    <div class="col-25">
      <label for="cod">Codice</label>
    </div>
      <input  type="hidden"  name="codice" value=<%=e.getCodice()%>>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="name">Nome</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="nome" placeholder="inserisci nome del'esercizio"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="med-price">Prezzo Medio</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="med-price" name="prezzo_medio" placeholder="inserisci prezzo medio"> 
    	</div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="tipologia">Id Tipologia</label>
    </div>
   		 <div class="col-75">
 			<!-- input type="text" id="id_type" name="id_tipologia" placeholder="inserisci id della tipologia di esercizio" -->
 			<select id="tipologia" name="tipologia">
 			<option value="" disabled selected>Select Tipologia</option>
 		<%
 			for (TipologiaDTO t : listtip) {
 				
 				%> 
 				<option value="<%=t.getId()%>">   <%=t.getTipologia()%>        </option> <%
 				 }%>
 		</select>
    	</div>
  </div>
   <div class="row">
    <div class="col-25">
      <label for="address">Indirizzo</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="address" name="indirizzo" placeholder="inserisci l'indirizzo dell'esercizio"> 
    	</div>
  </div>
   <div class="row">
    <div class="col-25">
      <label for="localita">Id Citta</label>
    </div>
   		 <div class="col-75">
 		
 			<select id="localita" name="localita">
 			<option value="" disabled selected>Select Città</option>
 		<%
 			for (LocalitaDTO t : listloc) {
					%> <option value="<%=t.getId()%>">   <%=t.getCitta()%>        </option> <%
 				 }%>
 		</select>
 		
    	</div>
   
  </div>
          
      <button type="submit" >Edit</button>
</form>


	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>