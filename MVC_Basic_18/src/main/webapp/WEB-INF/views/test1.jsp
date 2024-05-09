<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 적은값이 Data클래스의 어노테이션 조건에 맞아야함 @size, @max -->
<form action="test1_proc" method="post">
	num1 : <input type="text" name="num1"><br>
	<spring:hasBindErrors name="data"> <!-- 에러정보-> errors에 담겨져있음 -->
		<c:if test="${errors.hasFieldErrors('num1') }">
			${errors.getFieldError('num1').defaultMessage }<br>
		</c:if>
	</spring:hasBindErrors>
	
	num2 : <input type="text" name="num2"><br>
	<spring:hasBindErrors name="data"> <!-- 에러정보-> errors에 담겨져있음 -->
		<c:if test="${errors.hasFieldErrors('num2') }">
			${errors.getFieldError('num2').defaultMessage }<br>
		</c:if>
	</spring:hasBindErrors>
	
	
	
	<button type="submit">확인</button>
</form>
</body>
</html>