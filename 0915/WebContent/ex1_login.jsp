<%@page import="am.vo.MemVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	.box{
		width:180px;
		border:1px solid black;
		padding:5px 3px;/*위/아래 좌/우*/
		text-align:right;
	}
	#s_id,#s_pw{
		margin-bottom:6px;
		padding:4px;
		width:90px;
		border:1px solid #cdcdcd;
	}
	
</style>
</head>
<body>
	<% 
		//session으로부터 "uvo"라는 이름으로 저장된 값을 얻어낸다.
		//session에는 자바에서 인정하는 모든 객체는 저장이 가능하므로
		//검출할 때는 어떤 객체가 저장되어 있는지를 자바가 모르기 때문에(개발자는 알고 있겠지만)
		//자바는 무조건 Object로 반환한다.
		
		//항상 MemVO가 들어가있을때만 사용해라!! 서버가 꺼졌다 켜져도.
		//MemVO vo = (MemVO)session.getAttribute("uvo");
	
		Object obj = session.getAttribute("uvo");//자바는 Casting을 극도로 싫어함..속도저하의 주범
		if(obj == null){//session에 uvo라는 이름으로 저장된 것이 없는 경우(로그인을 하지 않은 경우)
		
		//if(request.getAttribute("uvo") != null){ 
	%>
	
	<div class="box">
		<form action="ex1_login_ok.jsp" method="post">
			<label for="s_id">ID:</label>
			<input type="text" id="s_id" name="id"/><br/>
			<label for="s_pw">PW:</label>
			<input type="password" id="s_pw" name="pw"/><br/>
			<input type="button" value="LOGIN" onclick="login(this.form)"/>
			<!-- this.form의 의미는 this는 button객체를 의미하고
			곧 버튼객체가 포함된 form객체를 login함수를 호출할 때 인자로 전달한다. -->
		</form>
	</div>
	
	<% }else{ 
		//obj가 null이 아닌 경우(로그인을 한 경우) 이때만 obj를 MemVO로 형변환을 시킨다.
		MemVO mvo = (MemVO)obj;
	%>
	
	<div class="box">
		<pre><%= mvo.getName() %>님 환영</pre>
		<input type="button" value="LOGOUT" onclick="logout()"/>
	</div>
	
	<% }//if문의 끝 %>
	
	<script>
		//자바스크트는 변수명이 없다. frm에 form이 들어간다. frm = document.forms[0]
		function login(frm){
			//id와 pw를 입력했는지를 판단하는 유효성 검사!
			var id = document.getElementById("s_id");
			//var pw = document.getElementById("s_pw");
			var pw = frm.pw; //폼객체 안에 있는 요소들 중 이름(name)이 pw인 요소
			  //!id.value : id의 값이 없다면.
			
			  
			/*	input에 value=""가 기본적으로 존재하면... !id.value만 했을때 경고창이 안떴어야하는거 아닌지?
				if(!id.value || id.value.trim().length<1){
				alert("ID를 입력하세요");
				id.value = "";
				id.focus();
				return;
				}
			*/
			if(!id.value || id.value.trim().length<1){
				alert("ID를 입력하세요");
				id.value = "";//입력된 값들을 모두 삭제한다.
				id.focus();
				return;
			}
			if(!pw.value || pw.value.trim().length<1){
				alert("비밀번호를 입력하세요");
				id.value = "";//입력된 값들을 모두 삭제한다.
				id.focus();
				return;
			}
			
			//document.forms[0].submit();
			frm.submit();
		}
		
		function logout(){
			//ex1_logout.jsp로 이동(자바스크립트용)
			location.href="ex1_logout.jsp";
			
			//페이지 강제 이동 JSP방법과 Java스크립트 방법!
			//JSP방법 : response.sendRedirect("path");
			//Java스크립트 : location.href="path"
		}
	</script>
</body>
</html>