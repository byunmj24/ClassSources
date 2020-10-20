<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>스프링 비동기식 통신 연습</h1>
	<form action="ex4" method="post">
		<label for="s_id">ID : </label>
		<input type="text" id="s_id" name="m_id"/><br/>
		<label for="s_pw">PW : </label>
		<input type="password" id="s_pw" name="m_pw"/><br/>
		
		<input type="button" value="LOGIN" id="btn" onclick="login()"/>
	</form>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(function(){
			//jQuery시작부분
			
			//아이디가 btn인 요소에서 클릭했을 때를 인식하는 이벤트!
			$("#btn").on("click", function(){
				
				var id = $("#s_id").val();
				var pw = $("#s_pw").val();
				$.ajax({
					url:"ex4",
					type:"post",
					data:"m_id="+encodeURIComponent(id)+"&m_pw="+encodeURIComponent(pw),
					dataType:"json"
				}).done(function(data){
					//서버에서 보내오는 자원이 data라는 인자다.
					
				});
			});
		});
	</script>
</body>
</html>