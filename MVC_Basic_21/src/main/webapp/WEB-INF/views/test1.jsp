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

	num1 : <form:radiobutton path="num1" value='true'/>true
	       <form:radiobutton path="num1" value='false'/>false<br>
	       <form:errors path="num1"/><br> 

	       
	num2 : <form:radiobutton path="num2" value='true'/>true
	       <form:radiobutton path="num2" value='false'/>false<br>
	       <form:errors path="num2"/><br> 

	num3 : <form:input path="num3" type='text'/><br>
		   <form:errors path="num3"/><br> 
		   
	num4 : <form:checkbox path="num4" value="check1"/>check1<br>
		   <form:errors path="num4"/><br> 
	
	num5 : <form:checkbox path="num5" value="check2"/>check2<br>
		   <form:errors path="num5"/><br> 

	num6 : <form:input path="num6" type='text'/><br>
		   <form:errors path="num6"/><br> 
		   
	num7 : <form:input path="num7" type='text'/><br>
		   <form:errors path="num7"/><br> 
		   
	num8 : <form:input path="num8" type='text'/><br>
		   <form:errors path="num8"/><br> 
	
	<form:button type="submit">체크</form:button>
	</form:form>
</body>
</html>