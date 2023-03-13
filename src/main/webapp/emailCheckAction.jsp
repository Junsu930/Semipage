<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.io.PrintWriter"%>

<%@page import="com.vita.user.SHA256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인증처리</title>
</head>
<body>
<%


	String code = request.getParameter("code");

	boolean rightCode = (new SHA256().getSHA256("junsu930@naver.com").equals(code)) ? true : false;

	if(rightCode == true) {

		PrintWriter script = response.getWriter();

		script.println("<script>");

		script.println("alert('인증에 성공했습니다.');");

		script.println("location.href = 'login.jsp'");

		script.println("</script>");

		script.close();		

		return;

	} 
%>
</body>
</html>