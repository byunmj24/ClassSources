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
	//요청시 한글처리
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="vo" class="pm.vo.DataVO"/>
<%-- DataVO vo = new DataVO();와 같은 내용!!! --%>

<%-- 
	<jsp:setProperty property="m_id" name="vo" param="m_id"/>
 --%>
<%-- jsp:setProperty - 속성값을 저장하는 액션! --%>
<%-- property - DataVO의 변수명! / name - property를 갖는 객체 / param - 넘어오는 parameter의 name --%>

<%--
	<jsp:setProperty property="m_name" name="vo"/>
 --%>
<%-- property와 param의 이름이 같으면 생략할 수 있다! --%>

<%--*를 입력하면 한번에 다 들어간다!!! --%>
<jsp:setProperty property="*" name="vo"/><%-- 파일첨부를 하는 곳에서는 쓸수없다! multipartrequest로 받아야하기때문 -> Spring이 해결해줄것이다~ --%>
	<h1><%=vo.getM_id() %>, <%=vo.getM_name() %></h1>
	<h2><%=vo.getPhone()[0] %>-<%=vo.getPhone()[1] %>-<%=vo.getPhone()[2] %></h2>
	<h2><%=vo.getAge()+1 %>살입니다.(늙었네요)</h2>
</body>
</html>