<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 객체로 저장된 필드 값 가져올때 클래스명 맨 앞글자는 소문 -->
${requestScope.test.str1 } <br>
${test.str2 } <br>
</body>
</html