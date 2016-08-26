<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/styles.css">
<title>Delete_Entries</title>

</head>
<body>
<div>
<%@ include file="MakerMenu.jsp" %>
</div>

<s:form action="MakerDelete" method = "post" id ="menuform">
  <!-- <div style="width:100%;padding:60px;border:1px solid black">  
    <input type="text" name="Cust_code" placeholder="Delete By Customer Code">
    <input type="submit" value="DELETE">
  </div> -->
 
 
<table border="1" class="bordered">
<tr><th>Select</th><th>Customer ID</th><th>Customer Code</th><th>Customer Name</th><th>Customer Address 1</th><th>Customer Address 2</th>
<th>Pin Code</th><th>Email</th><th>Contact Number</th><th>Contact person</th><th>Record Status</th><th>Flag</th><th>Creation Date</th><th>Created By</th><th>Modification Date</th><th>Modified By</th><th>Authorized Date</th><th>Authorized By</th>
</tr>
<s:iterator  value="list">  
<tr>
<td><input type="checkbox" value="<s:property value="Customer_Code"/>~~~<s:property value="Record_Status"/>" name="rdel"></td>
<td><s:property value="Customer_ID"/></td>  
<td><s:property value="Customer_Code"/></td>  
<td><s:property value="Customer_Name"/></td>
<td><s:property value="Customer_Address_1"/></td> 
<td><s:property value="Customer_Address_2"/></td> 
<td><s:property value="Customer_Pin_Code"/></td>
<td><s:property value="Email_address"/></td> 
<td><s:property value="Contact_Number"/></td>
<td><s:property value="Primary_Contact_Person"/></td>
<td><s:property value="Record_Status"/></td>
<td><s:property value="Active_Inactive_Flag"/></td> 
<td><s:property value="Create_Date"/></td> 
<td><s:property value="Created_By"/></td>
<td><s:property value="Modified_Date"/></td>
<td><s:property value="Modified_By"/></td> 
<td><s:property value="Authorized_Date"/></td> 
<td><s:property value="Authorized_By"/></td>
</tr>  
</s:iterator>

</table>

<input type="submit" value="delete" onclick="document.getElementById('menuform').submit()"> 
 
</s:form>



</body>
</html>