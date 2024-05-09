<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<form:form action="loginResult" modelAttribute="data">
	id: <form:input path="id" /><br>
	pw: <form:password path="pw" /><br>
		<button type="submit">login</button>
	</form:form>

</body>
</html>