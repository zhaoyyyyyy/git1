<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>商品详细信息页面</h1>
<br>
图书编号：<%=request.getParameter("bookId") %><br>
图书名称：${param.bookName }<br>
图书价格：${param.bookPrice }<br>
</body>
</html>