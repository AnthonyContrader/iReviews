<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.EsercizioDTO"
	import="it.contrader.dto.LocalitaDTO"
	import="it.contrader.dto.TipologiaDTO"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Localita Edit page">
<meta name="author" content="Daniele Leonardi">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Esercizio</title>
</head>

<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
  <a href="homeadmin.jsp">Home</a>
  <a href="/user/getall">Users</a>
  <a href="/esercizio/getall">Esercizio</a> 
  <a class="active" href="/review/getall">Review</a>
  <a href="/localita/getall">Localit�</a>
  <a href="/tipologia/getall">Tipologia</a> 
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%
	EsercizioDTO e = (EsercizioDTO) request.getSession().getAttribute("dto");         
	List<LocalitaDTO> listloc = (List<LocalitaDTO>) request.getSession().getAttribute("listLocalita");
	List<TipologiaDTO> listtip = (List<TipologiaDTO>) request.getSession().getAttribute("listTipologia");
%>

<form id="floatleft" action="/esercizio/update" method="post">
  <div class="row">
    <div class="col-25">
     <label for="name">Nome</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="nome" value=<%=e.getNome()%>> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="med-price">Prezzo Medio</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="med-price" name="prezzo_medio" value=<%=e.getPrezzo_medio()%>> 
    	</div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="tipologia">Id Tipologia</label>
    </div>
   		 <div class="col-75">
 			<select id="tipologia" name="tipologia">
 			<option value="" disabled selected>Select Tipologia</option>
 		<%
 			for (TipologiaDTO t : listtip) {
 		 %> 
 				<option value="<%=t.getId()%>">   <%=t.getTipologia()%>        </option> 
 				<%
 				 }
 				 %>
 		</select>
    	</div>
  </div>
   <div class="row">
    <div class="col-25">
      <label for="address">Indirizzo</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="address" name="indirizzo" value=<%=e.getIndirizzo()%>> 
    	</div>
  </div>
   <div class="row">
    <div class="col-25">
      <label for="localita">Id Citta</label>
    </div>
   		 <div class="col-75">
 		
 			<select id="localita" name="localita">
 			<option value="" disabled selected>Select Citt�</option>
 		<%
 			for (LocalitaDTO t : listloc) {
		 %> 
			<option value="<%=t.getId()%>"><%=t.getCitta()%></option>
		<%
 		    }
 		 %>
 		</select> 		
    	</div>
   		<input  type="hidden"  name="codice" value=<%=e.getCodice()%>>
  </div>          
      <button type="submit" >Edit</button>
</form>


	
</div>
<br>
<%@ include file="../css/footer.jsp" %>	
</body>
</html>