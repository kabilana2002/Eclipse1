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
<body class="container">
	<h2 style="color: #441AF0;">Login page</h2>

	<form action="LoginServlet" method="post">

		name:<input type="text" class="form-control" name="name">
		<div id="passwordHelpBlock" class="form-text">Your name must be
			unique</div><br>

		password:<input type="password" class="form-control" name="password">
		<div id="passwordHelpBlock" class="form-text">Your password must
			be strong</div><br>

		<input type="submit" class="btn btn-primary" value="login">

	</form>

	<a href="registerUser.jsp">Register User</a>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

</body>
</html>