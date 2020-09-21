<%@page import="java.text.SimpleDateFormat"%>
<%@page import="mybatis.dao.MemoDAO"%>
<%@page import="mybatis.vo.MemoVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	//쌤 INSERT code
	request.setCharacterEncoding("utf-8");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	String ip = request.getParameter("ip");
	
	boolean cmd = MemoDAO.add(writer, content, ip);
	
	//화면 강제 이동 - 화면 이동은 하나의 응답
	response.sendRedirect("memoList.jsp");
%>
<% /* 내 INSERT code
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
	*/
%>
