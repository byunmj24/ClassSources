<%@page import="mybatis.vo.MemoVO"%>
<%@page import="mybatis.dao.MemoDAO"%>
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
	<%	/*내 VIEW code
		String idx = request.getParameter("idx");
		MemoVO vo = MemoDAO.view(idx);
		*/
		
		//쌤 VIEW code
		//절대로 한글이 넘어오지 않는다면 한글처리 할 필요는 없다.
		//getParameter()의 반환형은 String
		//parameter가 넘어오지않으면 null값을 저장
		String idx = request.getParameter("idx");
		
		MemoVO vo = null;
		if(idx != null){//parameter를 받았다면 DAO를 통해 vo를 받는다.
			vo = MemoDAO.getMemo(idx);
	%>
	<h1>내용보기</h1>
	<form action="memoEdit_ok.jsp" method="post">
	<input type="hidden" name="idx" value="<%= vo.getIdx() %>"/>
		<table>
			<caption>내용보기 테이블</caption>
			<colgroup>
				<col width="100px"/>
				<col width="*"/>
			</colgroup>
			<tbody>
				
				<tr>
					<th><label for="writer">글쓴이</label></th>
					<td><input type="text" id="writer" name="writer" value="<%= vo.getWriter() %>"/></td>
					<th><label for="w_date">날짜</label></th>
					<td><input type="text" id="w_date" name="w_date" value="<%= vo.getReg_date() %>"/></td>
				</tr>
				<tr>
					<th><label for="content">내용</label></th>
					<td colspan="3"><textarea rows="5" cols="45" name="content" ><%= vo.getContent() %></textarea></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4">
					<input type="button" value="수정" id="btn" onclick="sendData(this.form)"/>
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
<% 
	} else {
		response.sendRedirect("memoList.jsp");//강제 이동!
	}
%>
</body>
</html>