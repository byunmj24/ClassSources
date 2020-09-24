<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//요청시 한글처리
	request.setCharacterEncoding("utf-8");

	//현재 위치, 폴더명 파라미터값 받기
	String cPath = request.getParameter("cPath");//cPath는 현재 위치값을 cPath로 저장되어 넘어온 변수 dir는 현재 위치
												//사용자가 있었던 현재 위치
	String fname = request.getParameter("f_name");//생성하고자 하는 폴더명
	
	//전체경로(절대경로) 받기 - 만들 폴더를 어디에 무슨이름으로? 이 폴더를 만들겠느냐 
	String path = application.getRealPath("/members/"+cPath+"/"+fname);
	
	//절대경로를 가지고 File객체 생성
	File file = new File(path);
	
	if(!file.exists()){
		//mkdirs() 사용
		file.mkdirs();
	}
	//java에서 화면 전환 방식
	//response.sendRedirect("myDisk.jsp?cPath="+cPath);//GET방식이므로 한글은 깨진다.
	
	//path, dir?? 너무 헷갈린다...개념 잡기 cPath와 dir은 members 이하를 저장한 String
	//D:\myStudy\JSP_Study\work\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\0921_WebHard\members\MJ

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
		<input type="hidden" name="cPath" value="<%=cPath%>"/>
	</form>
	<script>
		function exe(){
			document.f1.submit(); //현재 문서에서 f1이라는 이름을 가진 폼을 서버로 보낸다.
		}
	</script>
</body>
</html>