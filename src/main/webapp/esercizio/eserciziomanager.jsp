<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.EsercizioDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Esercizio Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
  <a  href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a href="ReviewServlet?mode=reviewlist">Review</a>
  <a href="LocalitaServlet?mode=localitalist">Località</a>
  <a  href="TipologiaServlet?mode=tipologialist">Tipologia</a>
  <a class="active" href="EsercizioServlet?mode=eserciziolist">Esercizio</a>  
  <a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<EsercizioDTO> list = (List<EsercizioDTO>) request.getAttribute("list");
	%>

<br>

	<table>
		<tr>
		    <th>Codice</th>
			<th>Nome</th>
			<th>Prezzo Medio</th>
			<th>id-tipologia</th>
			<th>Indirizzo</th>
			<th>Id_citta</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (EsercizioDTO u : list) {
		%>
		<tr>
			<td><a href=EsercizioServlet?mode=read&codice=<%=u.getCodice()%>>
				
			</a></td>
			<td><%=u.getNome()%></td>
			<td><%=u.getPrezzo_medio()%></td>
			<td><%=u.getId_tipologia()%></td>
			<td><%=u.getIndirizzo()%></td>
			<td><%=u.getId_citta()%></td>
			<td><a href=EsercizioServlet?mode=read&update=true&codice=<%=u.getCodice()%>>Edit</a>
			</td>
			<td><a href=EsercizioServlet?mode=delete&codice=<%=u.getCodice()%>>Delete</a>
			</td>

		</tr>
		<%
			}
		%>
	</table>



<form id="floatright" action="EsercizioServlet?mode=insert" method="post">
  <div class="row">
    <div class="col-25">
      <label for="cod">Codice</label>
    </div>
    <div class="col-75">
      <input type="text" id="cod" name="codice" placeholder="inserisci codice dell'esercizio">
    </div>
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
      <label for="id_type">Id Tipologia</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="id_type" name="id_tipologia" placeholder="inserisci id della tipologia di esercizio"> 
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
      <label for="city_id">Id Citta</label>
    </div>
   		 <div class="col-75">
 			<input type="text" id="city_id" name="id_citta" placeholder="inserisci id della citta in cui è ubicato"> 
    	</div>
  </div>
      <button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>