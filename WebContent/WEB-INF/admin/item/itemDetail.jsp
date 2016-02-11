<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${item.idx} &nbsp; ${item.itemName} &nbsp; ${item.itemContent} &nbsp; ${item.itemPrice} <br>
${item.itemLevel } <br>
${item.sale} <br>
${item.itemCategory} <br>
${item.url} <br>
${item.isDel} <br>
<a href="itemDelete.do?idx=${item.idx}">del</a><a href="itemUpdate.do?idx=${item.idx}">update</a>
</body>
</html>