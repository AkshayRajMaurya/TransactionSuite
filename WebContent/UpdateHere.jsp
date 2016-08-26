
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="java.util.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/styles.css">
<title>Modify Your records</title>
</head>
<body>
	<form action="DoUpdate" method="post">
	
	<div style="margin-left:40px; ">
<table border="1">

<tr><td>Customer ID </td><td><s:textfield name="Customer_ID" theme="simple" value="%{#application.id}" readonly="true" /></td></tr>
<tr><td>Customer Code</td><td><s:textfield name="Customer_Code" theme="simple"
						value="%{#application.code}" readonly="true" /></td></tr>
<tr><td>Customer Name</td><td><s:textfield name="Customer_Name" theme="simple"
						value="%{#application.name}" /></td></tr>
<tr><td>Address Line 1</td><td><s:textfield cssStyle="margin-left:18px" theme="simple" name="Customer_Address_1"
						value="%{#application.add1}" /></td></tr>
<tr><td>Address Line 2</td><td><s:textfield cssStyle="margin-left:18px" theme="simple"  name="Customer_Address_2"
						value="%{#application.add2}" /></td></tr>
<tr><td>Pin Code</td><td><s:textfield name="Customer_Pin_Code" theme="simple"
						value="%{#application.pin}" /></td></tr>
<tr><td>Email ID</td><td><s:textfield name="Email_address" theme="simple"
						value="%{#application.email}" /></td></tr>
<tr><td>Contact Number</td><td><s:textfield name="Contact_Number" theme="simple"
						value="%{#application.number}" /></td></tr>
<tr><td>Primary Contact Person</td><td><s:textfield name="Primary_Contact_Person" theme="simple"
						value="%{#application.person}" /></td></tr>
<%-- <s:select name="active_flag" key="af" list="#{'A':'Active','I':'InActive'}"/> --%>

</table>
<input type="submit" value="Update">
</div>
		
	</form>


</body>
</html>
