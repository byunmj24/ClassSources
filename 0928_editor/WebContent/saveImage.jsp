<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//에디터에서 보내지는 이미지는 무조건 upload라는 폴더에 저장한다.
	String path = application.getRealPath("/upload");
	
	MultipartRequest mr = new MultipartRequest(request, path, 
												1024*1024*5, "utf-8", 
												new DefaultFileRenamePolicy());//이때 전달해 오는 파일이 upload라는 폴더로 저장된다.
	//이제 요청한 곳으로 저장된 파일의 경로를 보내줘야 하기 때문에
	//정확한 저장된 파일명이 필요하다.
	String f_name = "";
	File f = mr.getFile("img");//파일이 전달되어 올 때 사용된 파라미터 이름이 "img"였으므로...
	if(f != null){
		f_name = f.getName();//저장시 파일명!!!
	}
	//이쯤에서 서버에 저장된 파일의 경로를 Json표기법으로 보낸다.
	//http://www.~~~.~~~/upload/back.png
	//http://localhost:8080/0928_editor/ ==> request.getContextPath()의 값
%>
{"img_url":"<%=request.getContextPath() %>/upload/<%=f_name %>"}
