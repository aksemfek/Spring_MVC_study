<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="test1_proc" modelAttribute="data" method="post">
		num1: <form:input path="num1" type="text" /> <br>
			<form:errors path="num1"/> <br>
			
		num2: <form:input path="num2" type="text" /> <br>
			<form:errors path="num2"/> <br>
		<button type="submit">확인</button>
	</form:form>
</body>
</html>