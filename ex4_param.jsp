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
		//파라미터를 받기 전 요청시 한글처리 - JSP에서 request는 내장객체(이미 준비되어 있는 객체), response도 이미 만들어져있다.
		///내장객체 : request, response, out(PrintWriter), session(HttpSession)...
		request.setCharacterEncoding("utf-8");
		
		//파라미터 받기
		String[] names = request.getParameterValues("s_name");
		//for(int i=0;i<names.length;i++){}
		for(String n : names){
			//out.println("<h2>"+n+"</h2>");
	%>
			<h2><%=n %></h2>
	<%
			//내장 객체라서 out.close()는 없어도 된다.
		}//for의 끝!
	%>
</body>
</html>