<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="final" method="post">
	이름:<input type="text" name="name" value="${requestScope.data.name }"><br>
	아이디:<input type="text" name="id" value="${data.id }"><br>
	비번:<input type="text" name="pw" value="${data.pw }"><br>
	주소1:<input type="text" name="adr1" value="${data.adr1 }"><br>
	주소2:<input type="text" name="adr2" value="${data.adr2 }"><br>
	
	<button type="submit">체크</button>
</form>
</body>
</html>