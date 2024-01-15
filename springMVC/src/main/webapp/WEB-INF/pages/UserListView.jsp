<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
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

<h1 align="center">User List</h1>

   
<br>
<body style="padding-left: 5%">
<sf:form method="post" modelAttribute="form"> 
       <sf:hidden path="pageNo" />
       
       <center>
		<tr>
		<td> First Name: <sf:input path="firstName"/>
		<td> DOB : <sf:input path="dob"/>
		<td><sf:select path="userId">
		<sf:option value="0">------Select-------</sf:option>
		<sf:options items="${userList}" itemValue="id" itemLabel="firstName"/>
		</sf:select></td>
		
		
		<td><input type="submit" name="operation" value="search"></td> 
		</center>
		</tr>
		 <br> <br>
		<table border="1">
			<tr style="background-color: teal;">
			    <th><input type="checkbox"></th>
			    <th width="10%">ID</th>
				<th width="15%">FirstName</th>
				<th width="15%">LastName</th>
				<th width="15%">LoginId</th>
				<th width="15%">Password</th>
				<th width="15%">DOB</th>
				<th width="20%">Address</th>
				<th width="15%">Edit</th>
			</tr>
			
			<c:forEach items = "${list}" var="user">
			
			<tr>
			    <td><input type="checkbox" name="ids" value="${user.id}"></td>
				<td><c:out value="${user.id}"></c:out></td>
				<td><c:out value="${user.firstName}"></c:out></td>
				<td><c:out value="${user.lastName}"></c:out></td>
				<td><c:out value="${user.login}"></c:out></td>
				<td><c:out value="${user.password}"></c:out></td>
				<td><c:out value="${user.dob}"></c:out></td>
				<td><c:out value="${user.address}"></c:out></td>
				<td><a href=" <c:url value="/ctl/User?id=${user.id }"/> ">edit</a></td>
			</tr>
			</c:forEach>
		</table>
		<br>
		<td width="25%"><input type="submit" name="operation" value="Previous"></td>
				<td width="25%"><input type="submit" name="operation" value="Add"></td>
				<td width="25%"><input type="submit" name="operation" value="Delete"></td>
				<td align="right"><input type="submit" name="operation" value="Next"></td>
			
		</sf:form>
<%@include file="Footer.jsp" %>
</body>
</html>