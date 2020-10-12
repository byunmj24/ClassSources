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
	//요청시 한글처리
	request.setCharacterEncoding("utf-8");

	//파라미터로 넘어오는 u_name이 '어드민'일때만 '관리자님 환영합니다.' 메세지를 출력하고
	//나머지는 '~님 환영합니다.' 출력
%>
	<c:if test="${param.u_name eq '어드민' }"><%--eq / == 변경 가능 --%>
		<h2>${param.u_name } 관리자님 환영합니다.</h2>
	</c:if>
	<c:if test="${param.u_name ne '어드민' }"><%--ne / != 변경 가능 --%>
		<h2>${param.u_name }님 환영합니다.</h2>
	</c:if>
</body>
</html>