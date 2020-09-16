<%@page import="am.dao.EmpDAO"%>
<%@page import="am.vo.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사번 검색 결과</h1>
	<div>
		<table>
			<thead>
				<tr>
					<th>사번</th>
					<th>이름</th>
					<th>직종</th>
				</tr>
			</thead>
			<tbody>
				<% 
					request.setCharacterEncoding("utf-8");
					String empno = request.getParameter("empno");
					EmpVO vo = EmpDAO.getSearchEmpno(empno);
					if(vo != null){
				%>
				<tr>
					<td><%=vo.getEmpno() %></td>
					<td><%=vo.getEname() %></td>
					<td><%=vo.getJob() %></td>
				</tr>
				<% }else{ %>
					<tr>
						<td colspan="3">검색된 사원이 없습니다.</td>
					</tr>
				<% } %>
				
			</tbody>
		</table>
	</div>
</body>
</html>