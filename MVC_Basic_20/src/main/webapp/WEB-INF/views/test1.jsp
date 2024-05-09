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
	<form:form modelAttribute="data">
		<form:select path="s1">
			<form:option value="d1">one</form:option>
			<form:option value="d2">two</form:option>
			<form:option value="d3">three</form:option><br>
		</form:select>
		
		<form:select path="s2">
			<form:options items="${requestScope.li1 }"/>	<br>
		</form:select>
		
		<form:select path="s3">
			<form:options items="${requestScope.li2 }"/>	<br>
		</form:select>
		
		<form:select path="s4">
			<form:options items="${requestScope.li3 }" itemLabel="s1" />	<br>
		</form:select>
		
		<form:checkbox path="s5" value="d1"/> one
		<form:checkbox path="s5" value="d2"/> two
		<form:checkbox path="s5" value="d3"/> three <br>
		
		<form:checkboxes items="${requestScope.li1 }" path="s6"/><br>
		<form:checkboxes items="${requestScope.li1 }" path="s7"/><br>
		<form:checkboxes items="${requestScope.li1 }" path="s8"/><br>
		
		<form:radiobutton path="s9" value="d1"/> one
		<form:radiobutton path="s9" value="d2"/> two   
		<form:radiobutton path="s9" value="d3"/> three <br>
		
		<form:radiobuttons path="s9" items="${requestScope.li1 }"/> <br>
		<form:radiobuttons path="s9" items="${requestScope.li1 }"/> <br>
		<form:radiobuttons path="s9" items="${requestScope.li1 }" /> <br>
	</form:form>
</body>
</html>