<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//session에서 이름이 "uvo"인 값을 삭제!
	session.removeAttribute("uvo"); //uvo가 있으면 삭제, 없으면 pass~
	response.sendRedirect("ex1_login.jsp");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>