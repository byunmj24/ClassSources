<%@page import="webhard.dao.WebhardDAO"%>
<%@page import="webhard.vo.WebhardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//요청시 한글처리
	request.setCharacterEncoding("utf-8");

	//아이디와 비밀번호 파라미터 받기
	String u_id = request.getParameter("u_id");
	String u_pw = request.getParameter("u_pw");
	
	//WebhardDAO를 통해 로그인을 검증한다.
	WebhardVO vo = WebhardDAO.login(u_id, u_pw);
	
	//vo가 null이 아니라면 아이디와 비밀번호를 잘 입력한 경우!
	//그런데 null이면 아이디 또는 비밀번호가 다른 경우다.
	if(vo != null){
		session.setAttribute("uvo", vo);

	}
	
	response.sendRedirect("left.jsp");
%>
