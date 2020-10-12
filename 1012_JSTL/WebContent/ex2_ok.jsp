<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--스크립트릿으로 받아서 session에 저장 --%>
<%
	request.setCharacterEncoding("utf-8");

	String s_id = request.getParameter("s_id");
	session.setAttribute("s_id", s_id);
	
	//Map구조 생성
	Map<String, String> map = new Hashtable<String, String>();
	map.put("name", "홍길동");
	map.put("id", s_id);
	
	//Map구조를 session에 저장한다. (request에도 저장가능)
	session.setAttribute("map", map);
	
%>
	<h1>${param.s_id }</h1>
	<h1>${param.s_pw }</h1>
	<%-- 배열로 된 파라미터를 받을 때는 paramValues 사용 --%>
	<h1>${paramValues.s_phone[0] } - 
		${paramValues.s_phone[1] } - 
		${paramValues.s_phone[2] }</h1>
		
	<input type="button" value="다음 페이지"
		onclick="nextPage()"/><%--ex2_res.jsp로 이동! --%>
		<br/>
	<input type="button" value="다음 페이지"
		onclick="javascript:location.href='ex2_res.jsp?pw=${param.s_pw}'"/>
	<%-- 함수 사용 없이 바로 페이지 이동! 따옴표 중복 조심, 경로는 홑따옴표로 / 파라미터를 같이 보내고 싶다면 ?와 함께 EL을 사용할 수 있다. --%>
		
	<%--자바스크립트는 forward 개념이 없다. 전부 sendRedirect로 보낸다. 
	param에 저장된 것들은 다 삭제되지만 session에 저장된 내용은 호출할 수 있다.--%>	
	<script>
		function nextPage(){
			//ex2_res.jsp로 이동!
			location.href="ex2_res.jsp";
		}
	</script>
</body>
</html>