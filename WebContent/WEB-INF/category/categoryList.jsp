<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<table border="1">
<tr>
<th>idx</th>
<th>categoryName</th>
<th>rootNum</th>
<th>step</th>
<th>division</th>
<th>seq</th>
<th>isDel</th>
<th>기능</th>
</tr>

<c:forEach items="${categoryList}" var="dto">
<tr>
<td>${dto.idx }</td>
<td>${dto.categoryName }</td>
<td>${dto.rootNum }</td>
<td>${dto.step }</td>
<td>${dto.division }</td>
<td>${dto.seq }</td>
<td>${dto.isDel }</td>
<td><a href="subCategoryInsertForm.do?idx=${dto.idx }">[하위 카테고리 삽입]</a>&nbsp;&nbsp;<a href="categoryDelete.do?idx=${dto.idx }">[삭제]</a></td>

</tr>

</c:forEach>

</table>
<br><br>

<form action="topCategoryInsert.do" method = "post">
[최상위 카테고리 추가]<br><br>
categoryName : <input type="text"  name = "categoryName"> 

<br>
division : <input type="text" name = "division" ><br><br>
<input type = "submit" value = "전송">&nbsp;&nbsp;<input type = "reset" value="초기화">

</form>










</body>
</html>