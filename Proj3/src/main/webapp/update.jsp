<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<form action="UpdateServlet" method=post>
<% if(session.getAttribute("name")==null){
		System.out.println(session.getAttribute("name"));
		response.sendRedirect("index.jsp");
	}%>
 <div class="position-absolute top-50 start-50 translate-middle">


id:<input type="text" name="id"><br><br>
name:<input type="text" name="name"><br><br>
salary:<input type="text" name="salary"><br><br>
<input type="submit" class="btn btn-primary" value="submit employee details">


<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</form>
</body>
</html>