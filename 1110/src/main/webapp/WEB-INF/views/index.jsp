<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	div#box{
		width: 300px;
		height: 150px;
		border: 1px solid black;
	}
</style>

</head>
<body>
	<h1>Flask 호출 연습</h1>
	<input type="button" value="플라스크 호출" id="req_bt"/>
	<input type="button" value="전기차 충전소 현황" id="req_bt2"/>
	
	<div id="box">
		<%--플라스크에서 전달해오는 값을 출력하는 곳 --%>
	</div>
	<ol id="ol"></ol>
	
	<%--jQuery 사용하기 위해 가져오자.--%>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
	<script>
		$(function(){
			//버튼에 이벤트 걸기
			$("#req_bt").bind("click", function(){
				//req_bt라는 id를 가진 버튼을 클릭했을 때마다 수행하는 곳!
				
				$.ajax({
					url: 'http://localhost:5000',
					type: 'get'
				}).done(function(data){
					//요청 성공시(플라스크에서 던진 값을 받는 곳)
					$('#box').html(data.code);
				});
			});
			
			$("#req_bt2").bind("click", function(){
				$.ajax({
					url:"http://localhost:5000/evCar",
					type:'post',
					dataType: 'json'
				}).done(function(data){
					// ol태그에 들어갈 li태그를 만들어야 한다.
					// 한개가 아니라 여러개가 있을 수 있으니까 변수 지정하고 반복문 돌리기
					var str = "";
					for(var i=0 ; i<data.length ; i++)
						str += "<li>"+data[i].addr+"</li>";
						
					$("#ol").html(str);
				});
			});
		});
		
	</script>
	
</body>
</html>