<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/styles.css">
  
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Maker Menu</title>
</head>
<body>
<div class="container">
  <div class="jumbotron">
    <h2>WELCOME <%=session.getAttribute("USERNAME")%> [MAKER] </h2>      
  </div>
  <div style="width:100%; float:right">
  <s:actionmessage/>
  <form action="logout" method ="post">
  <input type="submit" value="Logout">
  </form>
  </div>
  </div>
 

<nav class="navbar navbar-default">
  <div class="container-fluid">
<ul class="navbar-nav">
 <li  ><a href="MakerSearch.jsp">Search</a></li>
 <li>----</li>
  <li class="active"><a href="#" onclick="document.getElementById('menuform2').submit()">View All</a></li>
  <li>----</li>
  <li class="active"><a href="#" onclick="document.getElementById('menuform').submit()">Delete</a></li>
  <li>----</li>
  <li class="active"><a href="#" onclick="document.getElementById('menuform1').submit()">Modify</a></li>
  <li>----</li>
   <li class="active"><a href="AddRecord.jsp">Add Record</a></li>
</ul>
</div>
</nav>
<form action="MakerMenu" method = "post" class="navbar-form navbar-left" id="menuform">
</form>
<form action="MakerUpdate" method = "post" class="navbar-form navbar-left" id="menuform1">
</form>
<form action="MakerSearch" method = "post" class="navbar-form navbar-left" id="menuform2">
</form>
</body>
</html>