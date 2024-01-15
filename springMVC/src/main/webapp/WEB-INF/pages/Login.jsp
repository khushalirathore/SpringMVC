<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
    <sf:form action="Login" method="post" modelAttribute="form">
        <br><br><br><br>    
    <center>
    <h1> USER LOGIN</h1>  

    
        <table>
    <h2>
      <div>
					<font color="green"><h3>
							<c:if test="${not empty success}">${success}</c:if>
						</h3></font>
				</div>
				<div>
					<font color="red"><h3>
							<c:if test="${not empty error}">${error}</c:if>
						</h3></font>
				</div>
           <tr>
				<h2><th>Login</th></h2>
		
				<td><sf:input path="login" /></td>
				<td><sf:errors path="login" /></td>
			</tr>
			<tr>
				<th>Password  </th>
				<td><sf:input type="password" path="password" /></td>
				<td><sf:errors path="password" /></td>
			</tr>
			<tr>
					<th></th>
					<td><input type="submit" name="Operation" value="signIn">
						<input type="submit" name="Operation" value="signUp"></td>
				</tr>	
				</h2>
        </table>
        </center>
    </sf:form>
    <%@include file="Footer.jsp" %>
</body>
</html>