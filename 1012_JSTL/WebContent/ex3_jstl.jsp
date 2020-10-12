<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--JSTL(JSP Standard Tag Library)
	- 자바기반의 웹환경에서 지원하는 확장된 Tag를 사용할 수 있도록 제공되는 라이브러리
		(Tag로 제어문 지원)
		
	먼저 JSTL lib를 apache.org 의 Tomcat프로젝트에서 다운 받아
	WEB-INF/lib에 stadard.jar와 jstl.jar를 넣어둬야 한다.
	그 후 taglib 명시하고 사용
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- JSTL변수 선언 --%>
	<c:set var="idx" value="100"/><%-- 변수 선언 : idx라는 변수에 100을 넣는다. int idx = 100; --%>
	<%--
		스크립트요소에서 정의한 변수를 JSTL에서는 바로 사용하지 못한다.
	 --%>
	 <%
	 	int value = 20;
	 %>
	 <c:set var="value" value="<%= value %>"/> <%--스크립트요소 변수를 JSTL변수에 저장한다. --%>
	 <c:if test="${value >= 10}">
	 	<h2>value의 값이 10 이상입니다. value:${value }</h2>
	 </c:if>
	 <c:if test="${value < 10}">
	 	<h2>value의 값이 10보다 작습니다. value:${value }</h2>
	 </c:if>
</body>
</html>