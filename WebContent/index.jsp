<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>LOGIN PAGE</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/styles.css">

</head>
<body>

	<div id="container">
        <s:actionmessage/>
		<form action="Log_Auth" method="post">
			<s:textfield name="username" id="username" key="U"></s:textfield>
			<s:password name="password" id="password" key="P"></s:password>
           
			<div id="lower">

			<input type="submit" value="Login">
			

			</div>
			<!--/ lower-->

		</form>

	</div>

	</div>
</body>
</html>

