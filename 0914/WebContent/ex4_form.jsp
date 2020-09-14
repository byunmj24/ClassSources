<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파라미터 연습</h1>
	<article>
		<form action="ex4_param.jsp" method="post">
			<label for="s_name">친구이름1:</label>
			<input type="text" id="s_name" name="s_name"/><br/>
			<label for="s_name">친구이름2:</label>
			<input type="text" id="s_name1" name="s_name"/><br/>
			<label for="s_name">친구이름3:</label>
			<input type="text" id="s_name2" name="s_name"/><br/>
			
			<input type="button" value="보내기" onclick="exe()"/>
		</form>
	</article>
	<script>
		function exe(){
			//유효성 검사...(생략)
			document.forms[0].submit();//서버로 전달!!!
		}
	</script>
</body>
</html>