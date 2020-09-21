<%@page import="mybatis.dao.MemoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String writer = request.getParameter("writer");
	String w_date = request.getParameter("w_date");
	String content = request.getParameter("content");
	String idx = request.getParameter("idx");
	
	boolean ch = MemoDAO.edit(writer, w_date, content, idx);
	if(ch){
		out.println("수정 완료!");
	}else{
		out.println("수정 실패!");
	}
%>
</body>
</html>