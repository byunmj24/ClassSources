<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사번 검색</h1>
	<article>
		<form action="ex1_res.jsp" method="post">
			<label for="s_empno">검색할 사번:</label>			
			<input type="text" id="s_empno" name="empno"/><br/>
			<input type="button" value="SEARCH" onclick="search(this.form)"/>
		</form>
	</article>
	<script>
		function search(frm){
			//form."name"값을 받아준다.
			var empno = frm.empno;
			if(empno.value.trim().length<1){
				alert("사번을 입력해 주세요");
				empno.value="";
				empno.focus();
				return;
			}
			frm.submit();
		}
	</script>
</body>
</html>