<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="sb" class="shop.bean.ShopBean" scope="session"/>
<jsp:useBean id="cart" class="shop.bean.Cart" scope="session"/>
<%
	String pnum = request.getParameter("p_num");
	cart.addProduct(sb, pnum);//카트에 제품을 추가!!!
	//response.sendRedirect("product_content.jsp?prod_num="+pnum);
	response.sendRedirect("cartList.jsp");
%>