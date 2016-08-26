<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags"  prefix="s"%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="DbActions.DbClass"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/styles.css">
<title>CHECKER</title>
</head>

<body>
<s:actionmessage/>
<s:form action="Checker">
<% 
	try 
	{	
        
        Connection con = DbClass.getConnection();
   
        String q = "SELECT * FROM temporary_records_13742 WHERE RECORD_STATUS IN('N','D','M')";
        PreparedStatement pst = con.prepareStatement(q);
        ResultSet rs = pst.executeQuery();
        out.print("<table border='1'class='bordered'");
        out.print("<tr><th>Customer ID</th><th>Customer Code</th><th>Customer Name</th><th>Customer Address 1</th><th>Customer Address 2</th>");
        out.print("<th>Pin Code</th><th>Email Address</th><th>Contact Number</th><th>Contact Person</th><th>Record Status</th>");
        out.print("<th>Flag</th><th>Create Date</th><th>Create By</th><th>Modified By</th><th>Modified Date</th>");
        out.print("<th>Authorize Date</th><th>Authorize By</th>");
        out.print("<th>Check</th></tr>");
        while(rs.next())
        {
        	out.print("<tr>");
        	out.print("<td>"+rs.getInt(1)+"</td>");
            out.print("<td>"+rs.getString(2)+"</td>");
            out.print("<td>"+rs.getString(3)+"</td>");
            out.print("<td>"+rs.getString(4)+"</td>");
            out.print("<td>"+rs.getString(5)+"</td>");
            out.print("<td>"+rs.getInt(6)+"</td>");
            out.print("<td>"+rs.getString(7)+"</td>");
            out.print("<td>"+rs.getLong(8)+"</td>");
            out.print("<td>"+rs.getString(9)+"</td>");
            out.print("<td>"+rs.getString(10)+"</td>");
            out.print("<td>"+rs.getString(11)+"</td>");
            out.print("<td>"+rs.getDate(12)+"</td>");
            out.print("<td>"+rs.getString(13)+"</td>");
            out.print("<td>"+rs.getString(14)+"</td>");
            out.print("<td>"+rs.getString(15)+"</td>");
            out.print("<td>"+rs.getString(16)+"</td>");
            out.print("<td>"+rs.getString(17)+"</td><td>");
    		out.print("<input type='checkbox' name=\"checks\" value=\""+rs.getString(2)+"\">");
   			out.print("</td><td>"); 
   			out.print("</tr>");   
        }
        out.print("</table>");
        con.close();
	}

	catch (NamingException e)
	{       
	   	System.out.println(e);
	} 
	catch (SQLException e) 
	{
   		System.out.println(e);
	}
%>
<table>
<tr>
<td><s:submit name="buttonA" value="Accept"></s:submit></td>
<td><s:submit name="buttonR" value="Reject"></s:submit></td>
</tr>
</table>
</s:form>
</body>
</html>