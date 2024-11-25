<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>EmployeeWeb</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
  <div class="position-absolute top-50 start-50 translate-middle"></div>

	<% if(session.getAttribute("name")==null){
		System.out.println(session.getAttribute("name"));
		//response.sendRedirect("index.jsp");
	}%>
	
	<h1>Welcome </h1>

	<p class="font-monospace">Click any of the options below</p>
	
	<table class="table table-bordered">
	
	<tr>

		<td><a href="Register"> register</a></td>
		<td><a href="Update">update</a></td>
		<td><a href="Delete">delete</a></td>
		<td><a href="Show">GetAllEmployee</a></td>
		<td><a href="LogOutServlet">Log out</a></td>

	</tr>
	</table>

	<c:if test="${sessionScope.register eq 'register'}">
	<c:out value="${'Registered'}"/> 
	
	 
	<c:import url = "register.jsp"></c:import>
	</c:if>
	
	<c:if test="${sessionScope.allEmp eq 'allEmp'}">
	<c:import url="showAll.jsp"></c:import>
	</c:if>
	
	<c:if test="${sessionScope.delete eq 'delete' }">
	<c:import url="delete.jsp"></c:import>
	</c:if>
	
	<c:if test="${sessionScope.update eq 'update' }">
	<c:import url="update.jsp"></c:import>
	</c:if>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
		
</a>
</body>
</html>