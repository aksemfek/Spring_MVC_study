<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="data" method="post" action="test_proc">

		num1 : <form:input path="num1" type='test'/><br>
			<form:errors path="num1"/><br> 
			   
		num2 : <form:input path="num2" type='text'/><br>
			<form:errors path="num2"/><br> 
		 
		num3 : <form:input path="num3" type='text'/><br>
			<form:errors path="num3"/><br> 
		
		
	   
		    
	
	<form:button type="submit">체크</form:button>
	</form:form>
</body>
</html>