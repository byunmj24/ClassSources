<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	//session은 Object를 반환하지만 cPath에는 무조건 String만 있으므로 과감히 형변환
	String dir = (String)session.getAttribute("cPath");
	request.setCharacterEncoding("utf-8");

	//String path = application.getRealPath("/members/MJ");
	String path = application.getRealPath("/members/"+dir);
	
	MultipartRequest mr = new MultipartRequest(request, path, 
												1024*1024*5, //5Mb 까지 저장 가능을 나타냄 
												"utf-8",	//업로드 파일명 한글처리
												new DefaultFileRenamePolicy()); //같은 위치에 같은 이름이 있으면 자동으로 바뀌어서 저장하는 메서드
												
	//form에서 enctype이 지정되면 아래 방식으로는 받을 수 없다.
	//String dir = request.getParameter("dir");
	//MultipartRequest 객체로 받아준다.
	//String dir = mr.getParameter("dir");											
	
															
																		
	//만약! 첨부된 파일의 정보(이름)를 DB에 저장해야 한다면, 여기서 저장된 파일명을 알아내야 한다.
					//파일 보내는 곳의 parameter name
	File f = mr.getFile("upload");//첨부된 파일의 정보
	String new_name = f.getName();//현재 파일명
	
	//첨부파일이 저장될 때 이름이 변경될 수 있으며, 변경되기 전 원래 이름을 알아낸다.
	String ori_name = mr.getOriginalFileName("upload");
	
	if(f != null){//첨부여부 확인
		System.out.println("현재 파일명:"+new_name);
		System.out.println("변경전 파일명:"+ori_name);
	}
	System.out.println("dir:"+dir);
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
		<input type="hidden" name="cPath" value="<%=dir%>"/>
	</form>
	<script>
		function exe(){
			document.f1.submit(); //현재 문서에서 f1이라는 이름을 가진 폼을 서버로 보낸다.
		}
	</script>
</body>
</html>