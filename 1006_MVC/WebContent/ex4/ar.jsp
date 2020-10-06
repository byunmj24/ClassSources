<%@page import="ex4.DataVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	//그냥 내버려두자. 비교용으로!
	Object obj = request.getAttribute("ar");

	if(obj != null){
		DataVO[] ar = (DataVO[])obj;
		for(DataVO vo : ar){
%>
			<h2><%=vo.getName() %>, <%=vo.getAge()%></h2>
<%
		}//for문의 끝
	}
%>
<hr/><%--구분선 --%>
	<%-- prefix는 중요! uri는 그냥 저런게 있었다~ 외우면 좋고 아니면 말고~ 인터넷에 많아 --%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<h1>JSTL for문 연습</h1>
	<c:forEach var="vo" items="${ar}"> <%-- for(DataVO vo : ar)와 같다. --%>
		<h2>${vo.name }, ${vo.age }</h2>
	</c:forEach>
</body>
</html>