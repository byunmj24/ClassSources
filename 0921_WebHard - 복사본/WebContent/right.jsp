<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>apple메뉴</title>
<style>
	body{
		margin:0;
		padding:0;
	}
	header{
		height:44px;
		margin:0;
		background-color:#2e2e2e;
	}
	ul#menu{
		list-style:none;
		margin:0;
		padding:0;
		text-align:center;
		font:15px Arial;
		line-height:44px;
	}
	ul#menu>li{
		display:inline-block;
		width:100px;
/* 		margin-right:50px; */
	}
	ul#menu>li>a{
		color:#cdcdcd;
		text-decoration:none;
/* 		line-height:44px; */
	}
	ul#menu a:hover{
		color:#fff;
/* 		line-height:44px; */
	}
	li#apple>a{
 		text-indent:-9999px;
		background-image:url(images/apple.svg);
		position:absolute;
		top:0; /* y좌표 0 */
		background-size: 16px 44px; /* 배경 너비, 높이 */
		background-repeat:no-repeat;
		background-position:center;
 		width:48px;
		
		margin-left:-24px;
	}
</style>
</head>
<body>
<%
	String msg = request.getParameter("msg");//msg는 자바의 변수다. 이것을 바로 자바스크립트에서 사용할 수 없다.(자바스크립트>자바도 마찬가지)
											//HTML에서 출력문을 사용하여 자바의 값을 value에 저장하고 자바스크립트에서 id를 활용하여 끌고갈 수 있다.
%>
	<header>
		<ul id="menu">
			<li id="apple"><a href="">apple</a></li>
			<li><a href="">Mac</a></li>
			<li><a href="">iPad</a></li>
			<li><a href="">iPhone</a></li>
			<li><a href="">Watch</a></li>
			<li><a href="">TV</a></li>
			<li><a href="">Music</a></li>
			<li><a href="">Support</a></li>
			<li><a href="">Search</a></li>
			<li><a href="">Bag</a></li>
		</ul>
	</header>
	
	<%-- 자바의 변수 msg의 값을 자바스크립트에서 사용할 수 있도록
		hidden처리 된 요소의 값으로 출력시켜둔다. --%>
	<input type="hidden" id="msg" value="<%= msg %>"/>
	
	<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
	
	<script>
		//jQuery가 무조건 시작하는 부분
		$(function(){
			//현재 문서가 준비완료 시에 무조건 수행하는 곳!!
			
			//현재 문서에서 id가 msg인 요소의 값(value)를 얻어낸다.
			//그 값을 변수 res에 저장하자.
			var res = $("#msg").val();
			//var res = document.getElementById("msg").value;
			
			if(res == "1"){
				alert("축하합니다. 가입완료!");
			} else if(res == "0"){
				alert("가입시 오류가 발생했습니다.");
			}
		});
		
	</script>
</body>
</html>