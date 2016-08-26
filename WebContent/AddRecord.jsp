<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/styles.css">
  <title>ADD A NEW RECORD</title>
</head>
<body>
<div>
<%@ include file="MakerMenu.jsp" %>
</div>

<form action = "Add">
<div style="margin-left:40px; ">
<table border="1">

<tr><td>
Customer Code</td><td><s:textfield  name="cust_code" /></td></tr>
<tr><td>Customer Name</td><td><s:textfield  name="cust_name" /></td></tr>
<tr><td>Address Line 1</td><td><s:textarea cssStyle="margin-left:18px"  name="cust_add1" /></td></tr>
<tr><td>Address Line 2</td><td><s:textarea cssStyle="margin-left:18px"  name="cust_add2" /></td></tr>
<tr><td>Pin Code</td><td><s:textfield  name="cust_pincode" /></td></tr>
<tr><td>Email ID</td><td><s:textfield  name="email" /></td></tr>
<tr><td>Contact Number</td><td><s:textfield  name="contact_num" /></td></tr>
<tr><td>Primary Contact Person</td><td><s:textfield  name="primary_contact_person"/></td></tr>
<%-- <s:select name="active_flag" key="af" list="#{'A':'Active','I':'InActive'}"/> --%>

</table>
<input type="submit" value="SUBMIT">
</div>
</form>
<div style="margin-top: 60px">
To return to the Main Menu <a href="MakerMenu.jsp">Click here</a>
</div>
</body>
</html>