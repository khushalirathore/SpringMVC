<%@page import="com.rays.dto.UserDTO"%>
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
<style>

</style>
<body style="background-color: silver;">
<jsp:useBean id="dto" class="com.rays.dto.UserDTO" scope="request"></jsp:useBean>
<%
		dto = (UserDTO) session.getAttribute("user");

		boolean userLoggedin = dto != null;

		String welcomeMsg = "Hi,  ";

		if (userLoggedin) {
			welcomeMsg += dto.getFirstName();
		} else {
			welcomeMsg += "Guest";
		}
	%>


	<%=welcomeMsg%>


	<%
		if (userLoggedin) {
	%>


	<h3>
		<div align="right">
			<a href='<c:url value="/Login?logout=logout"/>'>Logout</a>
		</div>
		<a href="<c:url value="/ctl/User/search"/>">UserList</a>| <a
			href='<c:url value="/ctl/User"/>'>Add</a>
	</h3>

	<%
		} else {
	%>
	<h3>
		<div align="right">
			<a href='<c:url value="/Login"/>'>Login</a>| <a
				href='<c:url value="/UserRegister"/>'>UserRegistration</a>
		</div>
	</h3>
	<%
		}
	%>
	<hr>
</body>
</html>