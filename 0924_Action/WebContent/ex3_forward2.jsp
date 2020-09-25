<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//요청시 한글처리
	request.setCharacterEncoding("utf-8");
	
	String name = request.getParameter("name");
	String year = request.getParameter("year");
	
	if(name == null || year == null){
		//강제 페이지 이동
		//response.sendRedirect("ex3_forward.jsp");
		//request와 response를 초기화(새로 만들어서)하고 이동한다.
%>
		<jsp:forward page="ex3_forward.jsp"/>
<%
	}else{
		//name과 year가 들어온 상태
		
		//나이 구하기(현재 년도를 구한다.)
		Calendar now = Calendar.getInstance();
		
		int cYear = now.get(Calendar.YEAR);//2020
		int bYear = Integer.parseInt(year);//생년
		int age = cYear - bYear;
		
		//바로 앞의 페이지에서 전달된 파라미터 name, year를 담은
		//request가 그대로 유지되면서 age가 추가되어 
		//ex3_forward.jsp로 다시 forward된다.
%>
		<%--forward로 화면전환이 이루어져 name과 age는 아직 parameter로 가지고있다. --%>
		<jsp:forward page="ex3_forward.jsp">
			<jsp:param value="<%=age %>" name="age"/>
		</jsp:forward>
<%
	}
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