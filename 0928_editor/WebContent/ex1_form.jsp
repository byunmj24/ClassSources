<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- css링크는 여기에 넣는게 좋은 자리!! -->
<link rel="stylesheet" href="css/summernote-lite.min.css"/>
<style>
	.btn{
		width: 70px;
		height: 20px;
		text-align: center;
		padding: 0; 
	}
	.btn>a{
		display: block;
		width: 100%;
		padding: 4px;
		height: 20px;
		line-height: 20px;
		background: #27a;
		border-radius: 3px;
		color: #fff;
		text-decoration: none;
		font-weight: bold;
		font-size: 15px;
	}
	.btn>a:hover{
		background: #fff;
		color: #27a;
		border: 1px solid #27a;
	}
</style>
</head>
<body>
	<h1>썸머노트 에디터연습</h1>
	<article>
		<form action="ex1_write.jsp" method="post" name="frm">
			<table>
				<tbody>
					<tr>
						<td><label for="title">제목</label></td>
						<td>
							<input type="text" id="title" name="title"/>
						</td>
					</tr>
					<tr>
						<td><label for="content">내용</label></td>
						<td>
							<textarea rows="12" cols="50"
							id="content" name="content"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" style="text-align:right">
							<p class="btn">
								<!-- a태그로 javascript 함수 부르기 -->
								<a href="javascript:exe()"/>보내기</a>
							</p>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</article>
	
	<%-- jQuery --%>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="js/summernote-lite.min.js"></script>
	<script src="js/lang/summernote-ko-KR.js"></script>
	<script>
		$(function(){
			$('#content').summernote({
				//placeholder: "anyHorse"
				height: 300,
				maxHeight: 400,
				minHeight: 200,
				tabSize: 10,
				width: 1000,
				focus: true,
				lang: "ko-KR",
				callbacks:{
					onImageUpload: function(files, editor){
						//이미지가 에디터에 추가될 때마다 수행하는 곳!
						//이미지를 첨부하면 배열로 인식된다.
						//이것을 서버로 비동기식 통신을 수행하는 함수를 호출한다.
						for(var i=0 ; i<files.length ; i++){
							sendFile(files[i], editor);
						}
					}
				}
			});
			
			$('#content').summernote("lineHeight", 0.7);//줄간격 조정! 은 따로 밖에 빼내고 쓴다.(왜 그런지는 글쎄 잘...)
		});
		
		0
		function sendFile(file, editor){
			//console.log(file+"^^");
			
			//saveImage.jsp로 보내고자 하는 파라미터 값 만든다.
			//보내고자 하는 것이 일반적인 이름 또는 제목 같은 문자열값이 아니고, 
			//파일이므로 HTML의 form태그에 encType을 지정한 form객체를 만들어야 한다.
			var frm = new FormData();//<form enctype="..."></form> 파일을 보내기위해 준비된 form객체
			
			//saveImage.jsp에서 받는 imp파라미터를 등록한다.
			frm.append("img", file);//img=파일 형태로 파라미터가 준비되었다.
			
			//비동기식 통신
			$.ajax({
				url: "saveImage.jsp",
				type: "post",
				data: frm,
				contentType: false,
				processData: false,//위의 내용을 지정해야 일반적인 데이터 전송이 아님을 증명한다.
				dataType: "json",//나중 서버로부터 결과를 json으로 받는다.
			}).done(function(res){
				//성공시
				//console.log(res.img_url);
				//var image = $("<img>").attr("src",res.img_url);//img태그를 생성
				//$("#content").summernote("insertNode", image[0]);//Node와 Tag는 사실 같은 개념! 여기서는 Node를 쓴다.
				
				$("#content").summernote("editor.insertImage", res.img_url);
				
			}).fail(function(err){
				//실패시
				console.log(err);
			});
		}
		function exe(){
			var title = $("#title").val();
			var content = $("#content").val();
			
			if(title.trim().length < 1){
				alert("제목을 입력하세요");
				$("#title").focus();
				return;
			}
			if(content.trim().length < 1){
				alert("내용을 입력하세요");
				$("#content").focus();
				return;
			}
			document.frm.submit();
		}
	</script>
</body>
</html>