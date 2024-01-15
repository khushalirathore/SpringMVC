<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sf:form action="UserRegister" method="post" modelAttribute="form">
	<center>
	
	<h1>REGISTER NEW USER</h1>
	<br><br>
		<table>
			<tr>
				<th>First Name</th>
				<td><sf:input path="firstName" /></td>
			</tr>
			<tr>
				<th>Last Name</th>
				<td><sf:input path="lastName" /></td>
			</tr>
			<tr>
				<th>Login</th>
				<td><sf:input path="login" /></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><sf:input path="password" /></td>
			</tr>
			<tr>
				<th>Date of Birth</th>
				<td><sf:input path="dob" /></td>
			</tr>
			<tr>
				<th>Address</th>
				<td><sf:input path="address" /></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit"></td>
				<!-- <td><input type="submit" value="Cancel" name="operation"></td> -->
			</tr>
			
		</table>
		</center>
	</sf:form>
	<%@include file="Footer.jsp" %>
</body>
</html>