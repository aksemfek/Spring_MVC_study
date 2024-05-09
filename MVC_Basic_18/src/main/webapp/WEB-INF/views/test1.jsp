<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	aaa.a1 : <spring:message code="aaa.a1"/> <br>
	bbb.b1 : <spring:message code="bbb.b1"/> <br>
	aaa.a2 : <spring:message code="aaa.a2" arguments="${args }"/> <br>

</body>
</html>