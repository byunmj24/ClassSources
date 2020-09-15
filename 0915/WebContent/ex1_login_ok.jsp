<%@page import="am.vo.MemVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//요청시 한글처리
	request.setCharacterEncoding("utf-8");

	//각 파라미터들 받기(id, pw)
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");

	//DB검증...........(생략 - 오후에)
	
	//Session 처리
	//HttpSession session = request.getSession(); 이미 내장객체로 준비되어있다.
	//서버가 허용하는 한 session에 마음껏 저장이 가능!
	
	//하나씩 다 저장하기에는 너무 불편!!
	//session.setAttribute("mem_id", id);
	//session.setAttribute("mem_name", "마루치");
	
	//Session에 저장할 VO객체 생성
	MemVO vo = new MemVO();
	vo.setId(id);
	vo.setName("변민종");
	
	vo.setEmail("byunmj24@gmail.com");
	
	//한 사람의 정보를 MemVO에 모두 저장했다. 이 VO객체를 session에 저장!
	session.setAttribute("uvo", vo);
	
	//응답을 페이지 강제 이동!!
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