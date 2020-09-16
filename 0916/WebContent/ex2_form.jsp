<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>동적쿼리 연습</h1>
	<article>
		<form action="ex2_search.jsp" method="post">
			<select id="searchType" name="searchType">
				<option value="0">사번</option>
				<option value="1">이름</option>
				<option value="2">직종</option>
			</select>
			<input type="text" id="searchValue" name="searchValue"/>
			<input type="button" value="SEARCH" onclick="exe(this.form)"/>
		</form>
	</article>
	<script>
		function exe(f){
			var v = f.searchValue;//<input type="text" id="searchValue" name="searchValue"/>
			if(!v.value || v.value.trim().length==0){
				//검색어를 입력하지 않은 경우
				alert("검색할 단어를 입력하세요");
				v.value="";
				v.focus();
				return;
			}
			f.submit();//서버로 데이터 보내기(searchType, searchValue)
		}
	</script>
</body>
</html>