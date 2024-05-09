<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<form:form action="final" modelAttribute="data">
	이름: <form:input path="name"/><br><!-- path 이름과 설정한 필드명이 같아야함 -->
	아이디: <form:input path="id"/><br>
	비번: <form:input path="pw"/><br>
	주소1: <form:input path="adr1"/><br>
	주소2: <form:input path="adr2"/><br>
	<button type="submit">login</button>
	</form:form>
</body>
</html