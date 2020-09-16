<%@page import="am.vo.EmpVO"%>
<%@page import="am.dao.EmpDAO"%>
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
	<article>
		<table border="1" style="width:250px">
			<colgroup>
				<col width="100px"/>
				<col width="*"/>
				<col width="80px"/>
			</colgroup>
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
				String no = request.getParameter("u_no");
				if(no!=null){
					int n = Integer.parseInt(no);
					EmpVO vo = EmpDAO.getSearchEmpno(n);
					if(vo != null){
			%>
				<tr>
					<td><%= vo.getEmpno() %> %></td>
					<td><%= vo.getEname() %> %></td>
					<td><%= vo.getJob() %> %></td>
				</tr>
			<% }else{ %>
				<tr>
					<td>검색하신 사원이 없습니다.</td>
				</tr>
			<%		}
				}
			%>
			</tbody>
		</table>
	</article>
</body>
</html>