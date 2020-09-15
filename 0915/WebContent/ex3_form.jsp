<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>검색할 이름:</h1>
	<article>
		<form action="ex3_searchName.jsp" method="post">
			<label for="s_name">이름:</label>	
			<input type="text" id="s_name" name="s_name"/>
			<input type="button" value="검색" onclick="exe(this.form)"/>
		</form>
	</article>
	<script type="text/javascript">
		function exe(f){
			var name = f.s_name;//<input type="text" id="s_name" name="s_name"/>
			if(name.value.trim().length<1){
				alert("검색할 이름을 입력하세요");
				name.value="";
				name.focus();
				return;
			}
			f.submit();//서버로 보낸다.
		}
	</script>
</body>
</html>