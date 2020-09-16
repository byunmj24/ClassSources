<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사번검색</h1>
	<article>
		<form action="ex1_res1.jsp" method="post">
			<label for="s_no">검색할 사번:</label>
			<input type="text" id="s_no" name="u_no"/>
			<input type="button" value="검색" onclick="exe(this.form)"/>
		</form>
	</article>
	<script type="text/javascript">
		function exe(f){
			var no = f.u_no;
			if(!no.value || no.value.trim().length == 0){
				alert("검색할 사번을 입력하세요");
				no.value="";
				no.focus();
				return;//수행력을 포기하고 제어권 반환!
			}
			f.submit();//서버의 ex1_res.jsp로 폼의 요소들을 모두 전달!
		}
	</script>
</body>
</html>