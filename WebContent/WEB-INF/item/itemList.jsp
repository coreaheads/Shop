<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list</title>
</head>
<body>
	<c:forEach items="${itemList}" var="x">
	<c:if test=""></c:if>
	<a href="itemDetail.do?idx=${x.idx }">${x.idx}</a> &nbsp; ${x.itemName} &nbsp; ${x.itemContent} &nbsp; ${x.itemPrice} <br>
	</c:forEach>
	
	
</body>
</html>