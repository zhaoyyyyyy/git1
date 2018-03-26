<%@page import="net.onest.controller.GoodControl"%>
<%@page import="net.onest.dao.DatabaseConn"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="net.onest.dao.DatabaseConn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Books</title>
</head>
<body>
显示商品列表：<br>
<!-- 使用table来显示数据 -->
<table>
	<tr>
		<th>图书ID</th>
		<th>图书Name</th>
		<th>图书Price</th>
		<th>加入购物车</th>
	</tr>
<c:forEach var="book" items="<%=new GoodControl().getGoodsList() %>">
	<!-- 将book对象中的数据显示出来 -->
	<tr>
		<td>${book.bookId }</td>
		<td><a href="bookdetail.jsp?bookId=${book.bookId }&bookName=${book.bookName }&bookPrice=${book.bookPrice }">${book.bookName }</a></td>
		<td>${book.bookPrice }</td>
		<td><a href="ShoppingCart?bookId=${book.bookId }">是</a></td>
	</tr>
</c:forEach>
</table>

	<%
		ResultSet booksListRS = DatabaseConn.getBooksList();
		while(booksListRS.next()){
			int id = booksListRS.getInt("book_id");
			String name = booksListRS.getString("book_name");
			double price = booksListRS.getDouble("book_price");
			out.write("<p>");
			System.out.print(id+";"+ name +";"+price+"----");
	%>
	<a href="bookDetail?bookId=<%=id %>&bookName=<%=name %>&bookPrice=<%=price %>"><%=name %></a><&nbsp;>
	<a href="ShoppingCart?bookId=<%=id %>&bookPrice=<%=price %>">加入购物车</a>
	<%
			out.write("</p>");
		}
	%>
</body>
</html>