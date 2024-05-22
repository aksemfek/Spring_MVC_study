<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
<%
	request.setCharacterEncoding("utf-8");

	String strfolder="";
	String savefolder="/upload";
	String encType="UTF-8";
	int maxSize=10*1024*1024;
	
	ServletContext context=getServletContext();
	strfolder=context.getRealPath(savefolder);
	System.out.println(strfolder);
	
	try{
		MultipartRequest multi=new MultipartRequest(request,strfolder,maxSize,encType, 
				               new DefaultFileRenamePolicy());
%>
		
		
<% 
	
			out.println(strfolder);
		
	}catch(Exception e){}

%>





</body>
</html>