<%@page import="mybatis.dao.EditorDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//요청시 한글처리
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="vo" class="mybatis.vo.EditorVO" scope="page"/>
<jsp:setProperty property="*" name="vo"/>
<%
	EditorDAO.add(vo);//테이블 저장!
%>
<%--
	request.setCharacterEncoding("utf-8");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	//boolean chk = EditorDAO.add(title, content);
	
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>내용이 잘 저장되었습니다.</h1>
</body>
</html>