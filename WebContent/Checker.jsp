<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
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
    <h2>WELCOME <%=session.getAttribute("USERNAME")%> [CHECKER]</h2>      
  </div>
  </div>
 

<nav class="navbar navbar-default">
  <div class="container-fluid">
<ul class="navbar-nav">
 <li  ><a href="MakerSearch.jsp">Search</a></li>
 <li>----</li>
  <li class="active"><a href="#" onclick="document.getElementById('menuform2').submit()">View All</a></li>
  <li>----</li>
  <li class="active"><a href="#" onclick="document.getElementById('menuform').submit()">Access Records</a></li>
</ul>
</div>
</nav>
<form action="Accept.jsp" method = "post" id="menuform">
</form>
<form action="MakerSearch" method = "post"  id="menuform2">
</form>

<form action="Accept.jsp">
<div style="width:100%;padding:60px;border:1px solid black">  
<input type="submit" value="View Requests"/>
</div>
</form>

<form action="MakerSearch" method = "post" >
<div style="width:100%;padding:60px;border:1px solid black">  

<input type="text" name="CustomerInfo" placeholder="Search"><br>
<input type="submit" value="Search"/>
 </div>
    
</form>
</body>
</html>