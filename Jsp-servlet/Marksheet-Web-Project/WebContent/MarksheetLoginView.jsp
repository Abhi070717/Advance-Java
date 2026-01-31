<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Login</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<div align="Center">

		<form action="MarksheetLoginCtl" method="post">
			<h1>Login Form</h1>
			<table>
				<tr>
					<th>Name</th>
					<td><input type="text" name="Name" value=""
						placeholder="Enter Name"></td>
				</tr>
				<tr>
					<th>Roll Number</th>
					<td><input type="text" name="RollNo" value=""
						placeholder="Enter Roll Number"></td>
				</tr>
				<tr>
					<th>CAPTCHA</th>
					<td><img src="captcha.jsp" id="captchaImage"
						alt="CAPTCHA Image"> <br>
					<br> <input type="text" name="captchaInput"
						placeholder="Enter CAPTCHA" required> <br>
					<br>
						<button type="button" onclick="refreshCaptcha()">Refresh
							CAPTCHA</button></td>
				</tr>
				<tr>
					<td><input type="Submit" name="operation" value="Upload"></td>
				</tr>
			</table>

		</form>
	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>