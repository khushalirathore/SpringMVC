<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sf:form method="post" modelAttribute="form">

<center>
<h1>User Details</h1>


<table>
			<tr style="width: 25%">
				<th >First Name</th>
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
				<td><input type="submit" name="operation" value="Update"></td>
				<td><input type="submit" name="operation" value="Add"></td>
				
			</tr>
		</table>
		</center>
</sf:form>

</body>
<%@include file="Footer.jsp" %>
</html>