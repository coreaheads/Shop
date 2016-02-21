<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.js"></script>
<link type="text/css" rel="stylesheet" href="css/bootstrap.css"
	charset="utf-8">
<script>
	function fontResizeBSKR(layer, type) {
		var l =$("#vContent");
		var nSize = getCookie('myFontSize');
		nSize = nSize ? nSize : '12px';
		var iSize = parseInt(nSize.replace('px', ''));

		if (type == '+') {
			if (iSize < 20)
				l.style.fontSize = (iSize + 1) + 'px';
		} else {
			if (iSize > 8)
				l.style.fontSize = (iSize - 1) + 'px';
		}
		setCookie('myFontSize', l.style.fontSize, 1);
	}
</script>
<title>게시판</title>
</head>
<body style="padding: 30px">
	<div class="viewbox">
		<div class="header">

			<div class="subject">
				<h1 class="bskr-font-lg">${BoardDto.title }</h1>
			</div>
			<div class="info">
				<div class="xleft">
					<span class="han"> ${BoardDto.writer }</span> <span class="split">|</span>
					${BoardDto.create_time } <span class="split">|</span> <span
						class="han">조회</span> <span class="num">2779</span>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div id="vContent" class="content" style="font-size: 18px;">
			${BoardDto.content }</div>
	</div>
	<c:forEach items="${Filelist }" var="f">
		<a href="FileDown.do?filename=${f.filename }">${f.filename }</a>
		<br>
		<img src="file1/${f.filename }" width="150">
	</c:forEach>
	<br>
	<br>
	<input type="button"
		onclick="location.href='Board.do?mode=reply&idx=${BoardDto.idx}'"
		class="btn btn-primary" value="답변">
	<input type="button"
		onclick="location.href='Board.do?mode=update&idx=${BoardDto.idx}'"
		class="btn btn-primary" value="수정">
	<input type="button"
		onclick="location.href='BoardDelete.do?idx=${BoardDto.idx}&board_code=${paramvo.board_code}'"
		class="btn btn-primary" value="삭제">
	<input type="button" onclick="location.href='Board.do?mode=list&board_code=${paramvo.board_code}'"
		class="btn btn-primary" value="리스트">
	<c:if test="${BoardConfig.is_comment eq 'Y'}">
	<%@include file="comment.jsp"%>
</c:if>
</body>
</html>