<%@page import="in.co.rays.bean.UserBean"%>
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
	UserBean ub = (UserBean) session.getAttribute("user");
	%>
	<%
	if (ub != null) {
	%>
	<h2><%="Hii, " + ub.getFirstName()%></h2>
	<a href="LoginCtl?operation=logout">Logout</a> &nbsp
	<a href="#">User List</a> &nbsp
	<a href="#">Add User</a>
	<%
	} else {
	%>
	<h2>Hii, Guest</h2>
	<a href="LoginCtl">Login</a> &nbsp
	<a href="WelcomeCtl">Welcome</a> &nbsp
	<a href="UserRegistrationctl">User Registration</a>
	<%
 }
 %>
	<hr>
</body>
</html>