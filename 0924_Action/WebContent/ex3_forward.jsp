<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//요청시 한글처리
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String year = request.getParameter("year");
	String age = request.getParameter("age");
	
	//현재 페이지를 정상적으로 호출한다면 위의 3개 파라미터 값이 
	//모두 들어오거나 혹은 모두 안들어오거나 둘 중 하나이다.
	
	//만약! 1개라도 들어오지 않았다면 이름과 생년을 입력하도록 한다.
	if(name == null || year == null || age == null){
%>
	<form action="ex3_forward2.jsp" method="post">
		<label for="name">이름:</label>
		<input type="text" id="name" name="name"/><br/>
		
		<label for="year">생년:</label>
		<input type="text" id="year" name="year"/><br/>
		
		<input type="button" id="btn" value="보내기"/>
	</form>
<%
	}else{
		//모든 파라미터 값이 들어온 경우
%>
		<h2>
			<%=name %>님은 <%=year %>년 생이므로<br/>
			<%=age %>세 입니다.
		</h2>
<%
	}
%>

<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>

<script>

	//jquery시작부분
	$(function(){
		//Java의 메인 함수와 같은 곳!(물론 없어도 되지만, 문법을 지키기 위해서 정의하자!)
		
		$("#btn").click(function(){//익명함수
			//익명함수의 내용
			//한 문장안에서 jQuery문법과 Javascript문법을 동시에 쓸 수는 없다.
			//document.forms[0]name.val(); : X
			//document.forms[0].name.value;
			document.forms[0].submit();
		});
	
		function exe(){
			console.log("^^;");
		}
	});
	
</script>
</body>
</html>