<%@page import="com.rays.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body style="background-color: silver;">
<%-- <jsp:useBean id="dto" class="com.rays.dto.UserDTO" scope="request"></jsp:useBean> --%>


<h2 style="color: red">${msg}</h2>
<%-- <%
        dto = (UserDTO) session.getAttribute("user");
if (dto != null) {
%>

<%="Hello  "+dto.getFirstName()%>
<%} %>
<h1> hello world</h1> --%>

<%@include file="Footer.jsp" %>
</body>
</html>