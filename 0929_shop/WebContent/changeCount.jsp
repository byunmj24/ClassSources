<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cart" class="shop.bean.Cart" scope="session"/>
<%
	String pnum = request.getParameter("p_num");
	String count = request.getParameter("count");//사용자가 변경하기 위한 숫자값
	if(pnum != null && count != null){
		int q = Integer.parseInt(count);
		cart.changeCount(pnum, q);
	}
	response.sendRedirect("cartList.jsp");
%>