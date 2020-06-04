
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Homepage for Admin ">
<meta name="author" content="Vittorio Valent">

<title>Home</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/vittoriostyle.css" rel="stylesheet">
</head>

<body>
	<%@include file="css/header.jsp"%>


	<div class="navbar">
		<a class="active" href="/homeadmin.jsp">Home</a> 
		<a href="/user/getall">Users</a>
		<a href="/esercizio/getall">Esercizio</a>
		<a href="/review/getall">Review</a>
		<a href="/tipologia/getall">Tipologia</a>
		<a href=/localita/getall>Località</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>

	<div class="main">
		<h1>Benvenuto ${user.getUsername()}</h1>
<h2>
Benvenuto sul sito di recensioni iReviews, qui puoi inserire le tue recensioni<br>
sulla tua esperienza, mi raccomando sii onesto perchè se non lo sarai ti verremo a cercare!<br>
Ora puoi iniziare a scrivere le tue opinioni, sperando siano costruttive per il miglioramento<br>
dei vari esercenti che recensisci. Buona recensione!!!</h2>



	</div>


	<%@ include file="css/footer.jsp"%>

</body>
</html>