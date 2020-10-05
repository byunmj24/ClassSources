<%@page import="mybatis.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.empty{
		text-align: center;
		height: 50px;
		line-height: 50px;
		font-size: 15px;
	}
	#title{
		font-size:30px;
		color: maroon;
	}
	.txt_c{text-align: center}
    a:link{text-decoration:none; color:navy}
    a:visited{text-decoration:none; color:navy}
	a:hover{text-decoration:none; color:red}
</style>
</head>
<body>

<%
	//요청시 한글처리
	request.setCharacterEncoding("utf-8");
%>
	<jsp:useBean id="sb" class="shop.bean.ShopBean" scope="session"></jsp:useBean>
		<!--객체의 사용범위(scope)를 사용자가 접속하는 동안(session)로 하겠다. 
		    즉, 사용자가 접속을 끊으면 이 객체는 사라진다.
		    (범위가 가장 좁은 것이 page)-->
	<jsp:setProperty property="*" name="sb"/> 
		<!--현제 페이지로 넘어올 때 전달되는 파라미터는 category 하나임.
		    이것이 sb 즉, ShopBean의 category라는 멤버변수에 자동으로 저장된다.-->
		<!-- Property는 멤버변수라고 생각하면 된다. param이 생략됨, param은 porperty이름과 동일하면 생략 가능 -->

<%
	//Mybatis환경을 이용하여 제품진열대를 채운다.
	sb.searchProduct(); //비워져있던 p_list가 채워진다.
		//ShopBean의 p_list라는 배열이 사용자가 선택한 category별로 제품들이 채워졌다.
	
	//채워진 진열대를 현재 페이지에서 표현하기 위해 가져온다. 
	ProductVO[] list=sb.getP_list();
%>
	<jsp:include page="navi.jsp"></jsp:include>
	
	<table align="center" width="600" border="1" 
	       style="border-collapse:collapse; font-size:8pt" 
	       bordercolor="navy" cellpadding="4" cellspacing="0">
	    <thead>
		    <tr bgcolor="#dedede">
		        <th width="10%">제품번호</th>
		        <th width="10%">이미지</th>
		        <th width="35%">제품명</th>
		        <th width="20%">제품가격</th>
		        <th width="25%">비고</th>
		    </tr>
	    </thead>
		<tbody>
<%			if(list != null && list.length >0 ){
				for(ProductVO pvo : list){
%>
				<tr align="center">
			        <td><%=pvo.getP_num()%></td>
			        <td>
			        	<img src="images/<%=pvo.getP_image_s()%>" width="100" height="95">
			        </td>
	
			        <td>
			            <a href="product_content.jsp?prod_num=<%=pvo.getP_num()%>"><%=pvo.getP_name()%></a>
			        </td>
			        <td>
			            할인가 : <%=pvo.getPercent()%> 원<br>
			            <font color="red">(<%=pvo.getPercent()%>%)</font>
			        </td>
			        <td>
			            시중 가격 : <%=pvo.getP_price()%> 원
			        </td>
		    	</tr>
<%
				}//for문 끝
			}else{
%>	
				<tr>
					<td colspan="5" class="empty">등록된 제품이 없습니다.</td>
				</tr>
<%
			}
%>				
		</tbody>	
	   
	</table>

</body>
</html>