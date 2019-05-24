<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Company Page</title>
</head>
<body>
	
	<h1>Welcome to new company</h1>
	
	<hr>
	
	<p>
		
		User: <security:authentication property = "principal.username"/>
		<br>
		<br>
		Role(s): <security:authentication property = "principal.authorities"/>
	
	</p>
	
	<hr>
	
	<security:authorize access = "hasRole('MANGER')">
	<p>
		
		<a href="${pageContext.request.contextPath}/leaders">LeaderShip</a> Only for Managers
	
	</p>
	<hr>
	</security:authorize>
	
	
	<security:authorize access = "hasRole('ADMIN')">
	<p>
		
		<a href="${pageContext.request.contextPath}/systems">IT System</a> Only for Admin
	
	</p>
	<hr>
	</security:authorize>
	
	
	
	
	<!-- ADDING LOGOUT BUTTON -->
	<form:form action = "${pageContext.request.contextPath}/logout" method = "POST">
		
		<input type = "submit" value = "Logout">
		
	</form:form>
	
</body>
</html>