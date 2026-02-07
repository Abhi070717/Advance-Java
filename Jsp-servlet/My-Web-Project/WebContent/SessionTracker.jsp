<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session Tracker</title>
</head>
<body>
	<h3>
		<a href="WelcomeView.jsp">Simple link</a>
	</h3>
	<%
	String enUrl = response.encodeURL("WelcomeView.jsp");
	%>

	<h3>
		<a href="<%=enUrl%>">Encoded Link</a>
	</h3>
	<h3>
		<a href="WelcomeView.jsp?jsessionid=<%=session.getId()%>">Session
			id Link </a>		//http://localhost:8080/My-Web-Project/WelcomeView.jsp?jsessionid=C71631F7815FA12972E5603971F39CF2
	</h3>
	<form action="track" method="post">
		<input type="text" name="jsessionid" value="<%=session.getId()%>">
		<input type="Submit" value="<====">
	</form>
</body>
</html>