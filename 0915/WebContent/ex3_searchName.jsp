<%@page import="pm.dao.EmpDAO"%>
<%@page import="pm.vo.EmpVO"%>
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
	<h1>사원 이름 검색 결과</h1>
	<article>
		<table border="1" style="width:250px">
			<colgroup>
				<col width="80px"/>
				<col width="*"/>
			</colgroup>
			<thead>
				<tr>
					<th>사번</th>
					<th>이름</th>
				</tr>
			</thead>
			<tbody>
			<%
				//요청시 한글처리
				request.setCharacterEncoding("utf-8");
			
				//파라미터 값 받기
				String name = request.getParameter("s_name");
				
				//EmpDAO를 통하여 표현할 정보들(List<EmpVO>)을 받아낸다.
				List<EmpVO> list = EmpDAO.getSearchName(name);
				if(list != null){
					for(EmpVO vo : list){%>
						<tr>
							<td><%=vo.getEmpno() %></td>
							<td><%=vo.getEname() %></td>
						</tr>		
			<%		}//for문의 끝
				}//if문의 끝
			%>
			</tbody>
		</table>
	</article>
</body>
</html>