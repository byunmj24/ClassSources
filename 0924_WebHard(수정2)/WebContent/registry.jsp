<%@page import="java.io.File"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="webhard.dao.WebhardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! //선언문
	private String makeString(String[] ar, String delim){
		StringBuffer sb = new StringBuffer();
		for(int i = 0 ; i < ar.length ; i++){
			sb.append(ar[i]);
			if(i < ar.length-1){
				sb.append(delim);
			}//010-1234-2021'-'
		}
		return sb.toString();//StringBuffer를 String으로 변환
	}
%>
<%	
	//요청시 한글처리
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	String[] phone_ar = request.getParameterValues("phone");
	/*
	String phone = "";
	
	for(String p : phone_ar){
		//자바의 문자열(String)은 불변적 특징! 변할 수 없다.
		phone += p;//"" + "010" ---> "010", "010" + "1234" ---> "0101234", ~~~ : 메모리 낭비! > StringBuffer사용
	}*/
	/*
	StringBuffer sb = new StringBuffer();
	for(String p : phone_ar){
		sb.append(p);
	}//"01095469632"
	*/
	String phone = makeString(phone_ar, "-");//하나의 배열의 값들을 하나의 문자열로 변환
											//phone에 저장한다. 이떄 선언문에 정의한 makeString()메서드를 활용하였다.
	//System.out.println(phone);
	String email = request.getParameter("email");
	
	boolean chk = WebhardDAO.add(id, pw, name, addr, phone, email);
	
	//chk가 true일 때만 특정 위치(members 폴더)에 가입한 사용자 id와 같은 이름으로 폴더를 생성한다.
	//folder는 directory와 같은 것이며, 이것을 만들기 위해 먼저
	//java.io.File객체를 먼저 생성해야 한다. 그리고 그 안에 메서드들 중 mkdir() 또는 mkdirs()로
	//폴더를 생성할 수 있다.
	if(chk){
		//현재 서버(application)의 members라는 폴더의 정확한 절대경로(c:/...)를 얻자!
		//application - 현재 project를 객체화 해서 담고있는 내장객체
									   //memo1:'/'
		String path = application.getRealPath("/members/"+id);
		
		System.out.println(path);//절대경로가 어딘지 확인차 출력!
		
		//폴더를 생성할 수 있는 객체 즉, File객체를 생성한다.
		File f = new File(path);
		
		//존재하는지? 확인하자! (당연히 존재하지 않음)
		if(!f.exists())//!f.exists() : 존재하지 않는다면
			f.mkdirs();//memo2 : 실제 물리적으로 폴더가 생성된다!
		
	//페이지 이동
	//response.sendRedirect("index.jsp"); //화면이 나뉘어져 있기 때문에 이걸 쓸 수 없다. JavaScript 사용
%>
	<script>
		parent.location.href="index.jsp?msg=1";
		//작업한 결과를 확인하기 위해 parameter를 준다
		//창이 여러개 있을 경우 제일 위로 갈때는 top 을 사용
		//index.jsp로 parameter값을 보내지만 받아서 사용하는 곳은 left / right에서 받아서 처리한다.
	</script>
	
<%
	}else{//가입 실패한 경우!!!
	
%>
	<script>
		parent.location.href="index.jsp?msg=0";
	</script>
<%	
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>