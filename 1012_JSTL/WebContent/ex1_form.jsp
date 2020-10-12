<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL연습</h1>
	<form action="ex1_ok.jsp" method="post">
		<label for="s_id">ID:</label>
		<input type="text" id="s_id" name="s_id"/><br/>
		
		<label for="s_pw">PW:</label>
		<input type="password" id="s_pw" name="s_pw"/><br/>
		
		<input type="hidden" name="cPage" value="2"/>
		<input type="button" value="로그인" onclick="sendData(this.form)"/>
	</form>
	
	<script>
		function sendData(frm){
			//유효성 검사...
			
			//사용자가 입력한 id값 받아오기(두가지 방법 id, pw)
			var s_id = document.getElementById("s_id");
			
			//var s_pw = document.getElementById("s_pw");
			//form으로 접근하는 것은 name으로 접근한다.
			var s_pw = frm.s_pw;
			
			if(s_id.value.trim().length == 0){
				alert("아이디를 입력하세요");
				s_id.value = "";//초기화(청소)
				s_id.focus();
			}
			
			//비밀번호 유효성 검사
			if(s_pw.value.trim().length == 0){
				alert("비밀번호를 입력하세요");
				s_pw.value = "";
				s_pw.focus();
			}
			
			frm.submit();//서버로 파라미터값들(s_id, s_pw)보낸다.
		}
	</script>
</body>
</html>