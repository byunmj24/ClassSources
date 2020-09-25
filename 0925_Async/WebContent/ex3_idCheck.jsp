<%@page import="mybatis.dao.WebhardDAO"%>
<%@page import="mybatis.vo.WebhardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("m_id");
	
	WebhardVO vo = WebhardDAO.searchId(id);
	
	//vo가 null이면 사용자가 보낸 id는 사용가능한 id
	if(vo == null){
%>
		{"res" : "사용가능"}
<%		
	}else{
		//사용할 수 없는 id
%>
		{"res" : "사용불가능"}
<%
	}
%>