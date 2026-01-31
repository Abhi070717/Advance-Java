<%@page import="in.co.rays.bean.MarksheetBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
</head>
<body>
	<%
	MarksheetBean mb = (MarksheetBean) session.getAttribute("student");
	%>
	<%
	if (mb != null) {
	%>
	<h2><%="Hii, " + mb.getName()%></h2>
	<a href="MarksheetLoginCtl?operation=logout">Logout</a> &nbsp
	<a href="#">Student List</a> &nbsp
	<a href="#">Add Student Detail</a>
	<%
	} else {
	%>
	<h2>Hello, Student</h2>
	<a href="MaeksheetLoginCtl">Login</a> |
	<a href="WelcomeCtl">Welcome</a> |
	<a href="MaeksheetDetailCtl">User Registration</a> |
	<%
 }
 %>

</body>
</html>