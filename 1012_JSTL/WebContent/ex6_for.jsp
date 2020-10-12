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
	<h1>JSTL for문 연습</h1>
	
	<c:set var="cnt" value="20"/><%-- int cnt = 20; --%>
	
	<ul>
		<%-- begin부터 end까지 step간격으로 var에 담아 반복한다. --%>
		<c:forEach begin="1" end="10" step="1" var="v1">
			<li>번호:${v1 }</li>
		</c:forEach>
	</ul>
	<hr/>
	<ul>
		<%-- varStatus : st 안에 반복되는 회차의 index값이 저장된다. --%>
		<c:forEach begin="1" end="${cnt }" step="1" varStatus="st">
			<li>${st.index }</li>
		</c:forEach>
	</ul>
</body>
</html>