<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	%{requestScope.data1.str1}
	%{requestScope.data1.str2} <br>
	
	%{requestScope.data2.str3}
	%{requestScope.data2.str4} <br>

	%{requestScope.data3.str5}
	%{requestScope.data3.str6} <br>

</body>
</html>