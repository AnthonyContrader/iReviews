<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.EsercizioDTO"
	import="it.contrader.dto.LocalitaDTO"
	import="it.contrader.dto.TipologiaDTO"%>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="User Management">
<meta name="author" content="Vittorio Valent">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Esercizio Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a href="/user/getall">Users</a>
  <a class="active" href="/esercizio/getall">Esercizio</a>  
  <a href="/review/getall">Review</a>
  <a href="/localita/getall">Località</a>
  <a href="/tipologia/getall">Tipologia</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<EsercizioDTO> listes = (List<EsercizioDTO>) request.getSession().getAttribute("list");
	    List<LocalitaDTO> listloc = (List<LocalitaDTO>) request.getSession().getAttribute("listLocalita");
	    List<TipologiaDTO> listtip = (List<TipologiaDTO>) request.getSession().getAttribute("listTipologia");
	%>

<br>

	<table>
		<tr>
			<th>Nome</th>
			<th>Prezzo Medio</th>
			<th>id-tipologia</th>
			<th>Indirizzo</th>
			<th>Id_citta</th>
			<th></th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (EsercizioDTO e : listes) {
		%>
		<tr>
			<td><a href=/esercizio/read?codice=<%=e.getCodice()%>>
				<%=e.getNome()%>
			</a></td>
			<td><%=e.getPrezzo_medio()%></td>
			<td><%=e.getTipologia().getTipologia()%></td>
			<td><%=e.getIndirizzo()%></td>
			<td><%=e.getLocalita().getCitta()%></td>
			<td><a href=/esercizio/preupdate?codice=<%=e.getCodice()%>>Edit</a>
			</td>
			<td><a href=/esercizio/delete?codice=<%=e.getCodice()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="/esercizio/insert" method="post">
 
  <div class="row">
    <div class="col-25">
     <label for="name">Nome</label>
    </div>
    <div class="col-75">
      <input type="text" id="name" name="nome" 
      placeholder="inserisci nome del'esercizio"> 
    </div>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="med-price">Prezzo Medio</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="med-price" name="prezzo_medio" 
 			placeholder="inserisci prezzo medio"> 
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
 				<option value="<%=t.getId()%>"><%=t.getTipologia()%></option> <%
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
 			<!--input type="text" id="city_id" name="id_citta" placeholder="inserisci id della citta in cui è ubicato">   -->
 			<select id="localita" name="localita">
 			<option value="" disabled selected>Select Città</option>
 		<%
 			for (LocalitaDTO t : listloc) {
					%> <option value="<%=t.getId()%>"><%=t.getCitta()%></option> <%
 				 }%>
 		</select>
    	</div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>