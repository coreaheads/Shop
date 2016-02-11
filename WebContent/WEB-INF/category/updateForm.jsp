<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "categoryUpdate.do" method = "post">
categoryName : <input type = "text" name = "categoryName" value = "${category.categoryName }"><br>
division : <input type = "text" name = "division" value = "${category.division }"><br><br>

<input type = "hidden" name = "idx" value = "${category.idx }">

<input type = "submit" value = "수정">&nbsp;&nbsp;<input type = "reset" value = "초기화">
<br>
<br>
<a href = "categoryList.do">취소</a>

</form>



</body>
</html>