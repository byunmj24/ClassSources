<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{ font-size: 12px }
	table{
		border-collapse: collapse;
		width: 500px;
	}
	table th, table tbody td{
		border: 1px solid black;
		padding: 4px;
	}
	table tfoot td{ text-align: right; }
	table caption { text-indent: -9999px; height: 0; }
</style>
</head>
<body>
	<h1>작성</h1>
	<form action="memoAdd_ok.jsp" method="post">
		<table>
			<caption>내용추가 테이블</caption>
			<colgroup>
				<col width="100px"/>
				<col width="*"/>
			</colgroup>
			<tbody>
				<tr>
					<th><label for="writer">글쓴이</label></th>
					<td><input type="text" id="writer" name="writer"/></td>
				</tr>
				<tr>
					<th><label for="content">내용</label></th>
					<td><textarea rows="5" cols="45" name="content"></textarea></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
					<!-- 요청자(사용자)의 IP값 -->
					<!-- hidden : 내용에 있기는 하지만 화면에 보이지 않는다. -->
					<!-- getRemoteAddr() : 아이피 주소 얻는 메서드 -->
					<input type="hidden" name="ip" value="<%=request.getRemoteAddr()%>"/>
									
					<input type="button" value="저장" id="btn" onclick="sendData(this.form)"/>
				</tr>
			</tfoot>
		</table>
	</form>
	
	<script type="text/javascript">
		function sendData(frm) {
			var writer = frm.writer.value;
			var content = frm.content.value;	
			if(writer.trim().length <1){
				alert("글쓴이를 입력하세요");
				frm.writer.focus();
				return;
			}
			if(content.trim().length <1){
				alert("내용을 입력하세요");
				frm.content.focus();
				return;
			}
			frm.submit();
		}
	</script>
</body>
</html>