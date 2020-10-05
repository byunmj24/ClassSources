<%@page import="mybatis.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!--아래의 useBean은 새롭게 생성된것이 아니라 
	product_list.jsp에서 이미 생성된 것을 재사용하는 것이다.
	이때 id속성, class속성, scope속성들의 값을 똑같이 유지해야 한다.--> 
<jsp:useBean id="sb" class="shop.bean.ShopBean" scope="session"></jsp:useBean>
<jsp:setProperty property="p_num" name="sb" param="prod_num" />
	<!--파라미터 이름과 (ShopBean.java에서의)멤버 변수의 이름이 다르기 때문에 이렇게 써야 한다.-->
 
<%
	//해당 제품을 받는다.-->현재 이 기능이 없기 때문에 ShopBean에서 만들어준다.
	ProductVO pvo = sb.getProduct();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#title{
		font-size:30px;
		color: maroon;
	}
	.txt_c{text-align: center}
    a:link{text-decoration:none; color:navy}
    a:visited{text-decoration:none; color:navy}
	a:hover{text-decoration:none; color:red}
	table{
		width: 600px;
		font-size: 12px;
		border-collapse: collapse;
		border: 1px solid black;
		padding: 4px;
		margin: 0 auto;
	}
	table tbody tr{
		border: 1px solid black;
	}
	table td{
		padding: 4px;
	}
</style>
</head>
<body>
	<jsp:include page="navi.jsp"/>
	<table>
		   	<colgroup>
		   		<col width="40%">
		   		<col width="60%">
		   	</colgroup>
			<tbody>
			    <tr>
			        <td>제품Category</td>
			        <td><%=pvo.getCategory() %></td>
			    </tr>
			    <tr>
			        <td>제품번호</td>
			        <td><%=pvo.getP_num() %></td>
			    </tr>
			    <tr>
			        <td>제품이름</td>
			        <td><%=pvo.getP_name() %></td>
			    </tr>
			    <tr>
			        <td>제품 판매사</td>
			        <td><%=pvo.getP_company() %></td>
			    </tr>
			    <tr>
			        <td>제품가격</td>
			        <td><%=pvo.getP_price() %>만원(할인가 : <%=pvo.getP_saleprice() %>만원 )</td>
			    </tr>
			    <tr>
			        <td colspan="2">제품설명</td>
			    </tr>
			    <tr>
			        <td colspan="2" align="center"><img src ="images/<%=pvo.getP_image_l() %>"></td>
			    </tr>
			    <tr>
			        <td colspan="2"><%=pvo.getP_content() %></td>
			    </tr>
			    <tr>
			        <td colspan="2" align="center">
			            <input type="button" value="장바구니에 담기" 
			            onclick="javascript:location.href='addProduct.jsp?p_num=<%=pvo.getP_num()%>'"/>
			            <input type="button" value="장바구니 보기" 
			            onclick="javascript:location.href='cartList.jsp'"/>
			        </td>
			    </tr> 
		    </tbody>   
		</table>
</body>
</html>