<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "subCategoryInsert.do" method = "post">

하위 카테고리 삽입<br><br>

categoryName : <input type = "text" name = "categoryName"><br>
division : <input type = "text" name = "division"><br><br>
<input type ="hidden" name = "rootIdx" value = "${idx }">
<input type = "submit" value = "전송">&nbsp;&nbsp;
<input type = "reset" value = "초기화">


</form>


</body>
</html>