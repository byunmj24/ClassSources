<%@page import="am.dao.EmpDAO"%>
<%@page import="am.vo.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>검색 결과</h1>
	<article>
		<table border="1" style="width:250px">
			<colgroup>
				<col width="80px"/>
				<col width="*"/>
				<col width="100px"/>
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
				//요청시 한글처리
				request.setCharacterEncoding("utf-8");
				//전달해 오는 파라미터들 받기(searchValue, searchType)
				String value = request.getParameter("searchValue");
				String type = request.getParameter("searchType");
				
				//out.println(value+", "+type);
				
				List<EmpVO> list = EmpDAO.search(type, value);//정상적으로 처리가 되면 검색된 결과가 없어도 List는 절대로 null을 가지지 않는다.
			
				if(list != null && list.size() > 0){
					for(EmpVO vo : list){
			%>
						<tr>
							<td><%= vo.getEmpno() %></td>
							<td><%= vo.getEname() %></td>
							<td><%= vo.getJob() %></td>
						</tr>
			<%		
					}
				}else{
						//검색된 경우가 없는 경우!!
			%>
						<tr>
							<td colspan="3">검색 결과가 없습니다.</td>
						</tr>
			<%
				}
			%>
			</tbody>
		</table>
	</article>
</body>
</html>