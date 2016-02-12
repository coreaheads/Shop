<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="itemUpdate.do" method="post">
itemName<input type="text" name="itemName">
itemContent
<input type="text" name="itemContent">
itemPrice
<input type="text" name="itemPrice">
itemLevel
<input type="text" name="itemLevel">
sale
<input type="text" name="sale">
itemCategory
<input type="text" name="itemCategory">
		
imgFile: <input type = "file" name = "imgFile"><br>

<input type = "submit" value="수정">

<br><br>
<a href="itemList.do">돌아가기</a>
</form>
${item.idx} &nbsp; ${item.itemName} &nbsp; ${item.itemContent} &nbsp; ${item.itemPrice} <br>
${item.itemLevel } <br>
${item.sale} <br>
${item.itemCategory} <br>
${item.url} <br>
${item.isDel} <br>
</body>
</html>