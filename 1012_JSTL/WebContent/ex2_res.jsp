<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--바로 session을 확인하도록 위치를 지정해준다.(생략해도 가능은 하다.) --%>
	<h1>${sessionScope.s_id }</h1>
	<%--파라미터로 넘어오는 내용을 받으려면 반드시! 꼭! param을 붙여줘라 --%>
	<h1>param.pw : ${param.pw }</h1>
	<h1>param["pw"] : ${param["pw"] }</h1><%--param 안에 이름이 pw인 것 찾기! 윗줄과 결과는 같다. --%>
	<br/>
	<%--Map에 저장된 정보 가져오기! --%>
	<h1>${sessionScope.map.name }</h1><%--홍길동 --%>
	<h1>${sessionScope.map.id }</h1><%--사용자의 id --%>
</body>
</html>