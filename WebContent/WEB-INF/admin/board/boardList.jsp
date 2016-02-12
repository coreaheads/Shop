<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/head.jsp" />
<h2 class="sub-header">게시판관리2</h2>
<body style="padding: 30px">

	<input type="button" onclick="location.href='./BoardConfigWrite.do'"
		class="btn btn-primary" value="게시판 추가">
	<br>
	<br>
	<table class="table">
		<tr>
			<th>코드</th>
			<th>테이블명</th>
			<th style="text-align: center">리플</th>
			<th style="text-align: center">코멘트</th>
			<th style="text-align: center">파일</th>
			<th style="text-align: center">파일갯수</th>
		</tr>
		<c:forEach var="list" items="${list }" varStatus="s">

			<tr>
				<td>${list.board_code }</td>
				<td>${list.board_name }</td>
				<td align="center">${list.is_reply }</td>
				<td align="center">${list.is_comment }</td>
				<td align="center">${list.is_file }</td>
				<td align="center">${list.file_cnt }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>