<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	request.setCharacterEncoding("utf-8");
	String path = application.getRealPath("/members/MJ");
	
	MultipartRequest mr = new MultipartRequest(request, path, 1024*1024*5, new DefaultFileRenamePolicy());
															//5Mb 까지 저장 가능         같은 파일 같은 이름이 있으면 저장(?)
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="exe()">
	<!-- 위의 response.sendRedirect와 같은 내용 > 전송방식이 post로 바뀜 -->
	<form action="myDisk.jsp" method="post" name="f1">
		<input type="hidden" name="cPath" value="MJ"/>
	</form>
	<script>
		function exe(){
			document.f1.submit(); //현재 문서에서 f1이라는 이름을 가진 폼을 서버로 보낸다.
		}
	</script>
</body>
</html>