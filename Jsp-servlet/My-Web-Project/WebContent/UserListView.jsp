<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<%
	List list = (List) request.getAttribute("list");
	%>
	<div align="Center">
		<form action="UserListCtl" method="Post">
			<h1>User List</h1>
			<table width="100%" border="1px">

				<tr>
					<th>Select</th>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Date of birth</th>
					<th>Login</th>
					<th>Password</th>
				</tr>
				<%
				Iterator it = list.iterator();

				while (it.hasNext()) {
					UserBean bean = (UserBean) it.next();
				%>
				<tr align="Center">
					<td><input type="Checkbox" name="ids"
						value="<%=bean.getId()%>">
					<td><%=bean.getId()%></td>
					<td><%=bean.getFirstName()%></td>
					<td><%=bean.getLastName()%></td>
					<td><%=bean.getDob()%></td>
					<td><%=bean.getLogin()%></td>
					<td><%=bean.getPassword()%></td>
				</tr>
				<%
				}
				%>

				<tr></tr>


			</table>

			<table>
				<td><input type="Submit" name="operation" value="Delete"></td>
			</table>
		</form>
	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>