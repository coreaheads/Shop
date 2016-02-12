<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:forEach items="${rdto }" var="r">
----------------------------------------------------------<br>
${r.author } <br>
${r.content }<br>

</c:forEach>

<br>
<br>
<form action="commentinsert.do" method="post">
	<input type="hidden" name="num" value="${dto.num }"> 작성자<input
		type="text" name="cAuthor" value=""> <br> 내용<br>
	<textarea rows="3" cols="30" name="cContent">  </textarea>
	<input type="submit" value="쓰기">
</form>

