<%@page import="java.text.SimpleDateFormat"%>
<%@page import="mybatis.dao.MemoDAO"%>
<%@page import="mybatis.vo.MemoVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
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
	String content = request.getParameter("content");
	String ip = request.getParameter("ip");
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	Calendar date = Calendar.getInstance();
	String reg_date = format.format(date.getTime());
	
	MemoVO vo = new MemoVO();
	if(writer.trim().length()>0)
		vo.setWriter(writer);
	if(content.trim().length()>0)
		vo.setContent(content);
	if(ip.trim().length()>0)
		vo.setIp(ip);
	if(reg_date.trim().length()>0)
		vo.setReg_date(reg_date);
	//System.out.println(reg_date);
	
	MemoDAO.add(vo);
	
	response.sendRedirect("memoList.jsp");
%>
</body>
</html>