<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="webhard.dao.WebhardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! //선언문
	private String makeString(String[] ar, String delim){
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ; i < ar.length ; i++){
			sb.append(ar[i]);
			if(i < ar.length-1){
				sb.append(delim);//010-1234-2021 '-''
			}
		}
		return sb.toString();//StringBuffer를 String으로 변환
	}
%>
<%	
	//요청시 한글처리
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	String[] phone_ar = request.getParameterValues("phone");
	/*
	String phone = "";
	
	for(String p : phone_ar){
		//자바의 문자열(String)은 불변적 특징! 변할 수 없다.
		phone += p;//"" + "010" ---> "010", "010" + "1234" ---> "0101234", ~~~ : 메모리 낭비! > StringBuffer사용
	}*/
	/*StringBuffer sb = new StringBuffer();
	for(String p : phone_ar){
		sb.append(p);
	}*/
	String phone = makeString(phone_ar, "-");
	String email = request.getParameter("email");
	
	boolean val = WebhardDAO.add(id, pw, name, addr, phone, email);
	
	response.sendRedirect("index.jsp");
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