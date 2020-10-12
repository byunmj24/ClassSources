<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] ar = {"자바", "스프링", "파이썬", "Lombok"};

	request.setAttribute("arr", ar);//2.
%>
	<h1>JSTL for문 연습</h1>
	<ul>
		<%--<c:set var="arr" value="<%=ar %>"/> --%>
		<%-- 스크립트요소를 JSTL에서 이용하기 위해 1.변수를 선언해 저장하거나 2.request에 setAttribute를 해서 불러온다. --%>
		<c:forEach var="ss" items="${arr }" varStatus="st">
			<li>${ss }</li>
		</c:forEach>
	</ul>
</body>
</html>