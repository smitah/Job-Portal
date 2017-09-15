<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> <u>Current Openings</u></h3>
<table>
<tr>
<th>Job Id</th>
<th>Title</th>
<th>Skills</th>
<th>Category</th>
<th>Type</th>
<th>Apply</th>
</tr>
<tr>
<td> ${job_id} </td>
<td> ${Title} </td>
<td> ${Skills} </td>
<td> ${Category} </td>
<td> ${Type} </td>
<form action = "apply" method = "get"><button type = "submit">Click To Apply</button></form>
 
</body>
</html>