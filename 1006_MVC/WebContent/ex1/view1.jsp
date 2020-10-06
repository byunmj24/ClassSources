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
	//MVC환경은 뷰 페이지로 이동시 forward되므로 request에 저장한 값(객체)들을 이용할 수 있다.
	Object obj = request.getAttribute("msg");
	
	//String msg = null;
	//obj가 null이 아닐 때 String으로 형변환을 시킨다.
	//if(obj != null){
		//msg = (String)obj;
	//}
%>
	<h1><%=obj %></h1>
</body>
</html>