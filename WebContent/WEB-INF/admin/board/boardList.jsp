<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/head.jsp" />

<h2 class="sub-header">게시판관리</h2>
<div class="col-md-12">
	<form class="navbar-form navbar-right" action="free_board_list.do"
		role="search">
		<select class="form-control" name="select_free_board" id="sel1">
			<option value="member_id">작성자</option>
			<option value="free_board_title">제목</option>
		</select>

		<div class="form-group">
			<input type="text" name="find_free_board" class="form-control"
				placeholder="Search">
		</div>
		<button type="submit" class="btn btn-default">Search</button>
	</form>
</div>
<div class="col-md-12">

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
		<c:forEach var="list" items="${List }" varStatus="s">

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
	<nav class='paging-number text-center'>
		<ul class='pagination'>
			
			<li class='<c:if test="${paramvo.page eq 1 or empty paramvo.page  }">disabled</c:if>'><a href='<c:if test="${paramvo.page eq 1 or  empty paramvo.page }">${paramvo.url }.do?page=1</c:if>' aria-label='Previous'><span
					aria-hidden='true'>&laquo;</span></a></li>
					<li class='<c:if test="${paramvo.page ne 1 }">disabled</c:if>'><a href="<c:if test="${paramvo.page ne 1}">${paramvo.url }.do?page=${paramvo.page-1 }</c:if>" aria-label='First'><span
					aria-hidden='true'>&lsaquo;</span></a></li>
			<c:forEach begin="${paramvo.startpage  }" end="${paramvo.endpage }" step="1"	var="x" varStatus="a">
				<li></li>
				<li class='<c:if test="${paramvo.page eq a.index }">active</c:if>'><a href="${paramvo.url }.do?page=${a.index }">${a.index}</a></li>
			</c:forEach>
			<li class='<c:if test="${paramvo.page eq paramvo.endpage }">disabled</c:if>'>
			<a href="<c:if test="${paramvo.page ne paramvo.endpage }">${paramvo.url }.do?page=${paramvo.page+1 }</c:if>" aria-label='Next'><span
					aria-hidden='true'>&rsaquo;</span></a></li>
			<li class='<c:if test="${paramvo.page eq paramvo.endpage }">disabled</c:if>'>
			<a href="<c:if test="${paramvo.page ne paramvo.endpage }">${paramvo.url }.do?page=${paramvo.endpage }</c:if>" aria-label='End'><span
					aria-hidden='true'>&raquo;</span></a></li>
		</ul>
	</nav>
</div>
</body>
</html>