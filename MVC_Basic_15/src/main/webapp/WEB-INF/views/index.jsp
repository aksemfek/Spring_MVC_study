<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<!-- session : 브라우저가 서버에 요청을 하게 되면 브라우저 당 하나씩 메모리 공간을 서버에서 할당해줌
		요청이 새롭게 발생해도 같은 메모리 공간을 사용하게 됨 -->
	<!-- @SessionScope : 최초의 요청~브라우저 닫을때까지 -->
	<a href="t1">test1</a><br>
	<a href="s1">spting1</a> <br>

</body>
</html>