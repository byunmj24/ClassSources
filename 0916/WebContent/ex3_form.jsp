<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사원 수정</h1>
	<article>
		<form action="ex3_edit.jsp" method="post">
			<label for="s_no">검색할 사번:</label>
			<input type="text" id="s_no" name="s_no"/><br/>
			<label for="s_name">수정할 이름:</label>
			<input type="text" id="s_name" name="s_name"/><br/>
			<label for="s_job">수정할 직종:</label>
			<input type="text" id="s_job" name="s_job"/><br/>
			<label for="s_sal">수정할 급여:</label>
			<input type="text" id="s_sal" name="s_sal"/><br/>
			
			<input type="button" value="수정" onclick="exe(this.form)"/>
		</form>
	</article>
	<script>
		function exe(f){
			var no = f.s_no;
			if(!no.value || no.value.trim().length==0){
				alert("검색할 사번을 입력하세요.");
				no.value="";
				no.focus();
				return;
			}
			f.submit();//서버로 보낸다.
		}
	</script>
</body>
</html>