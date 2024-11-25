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
	<%
	if (session.getAttribute("name") == null) {
		System.out.println(session.getAttribute("name"));
		response.sendRedirect("index.jsp");
	}
	%>
	<div class="position-absolute top-50 start-50 translate-middle">
		<%
		if (session.getAttribute("error") != null) {
		%>

		<h4 style="color: red">
			<%=session.getAttribute("error")%>
		</h4>

		<%
		session.removeAttribute("error");
		}
		%>



		<form action="RegisterUserServlet" method="post">
			username:<input type="text" class="form-control-lg" name="username"><br>
			password:<input type="password" class="form-control-lg"
				name="password"><br> confirm password:<input
				type="password" class="form-control-lg" name="confirm password"><br>
			<input type="submit" class="btn btn-primary" value="login">
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
				crossorigin="anonymous"></script>
	</div>
	</form>
</body>
</html>