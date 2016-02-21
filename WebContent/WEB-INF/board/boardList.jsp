<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table">
	<tr>
		<th width="8%">번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일</th>
	</tr>
	<c:forEach items="${BoardList }" var="list">
		<tr>
			<td>${list.idx }</td>
			<td> <c:if test="${list.step>0 }">
				ㄴ
					<c:forEach begin="1" end="${list.step}">
					&nbsp;&nbsp;&nbsp;&nbsp;
					</c:forEach>
				</c:if> <a href="Board.do?mode=detail&idx=${list.idx }">${list.title }</a></td>
			<td>${list.writer }</td>
			<td>${list.create_time }</td>
		</tr>
	</c:forEach>
</table>
<div class="col-md-12 text-center">
	<ul class="pagination">

		<li class=''><a href="Board.do?page=1" >&laquo;</a></li>
		<li ><a href="<c:if test="${param.page ne 1 }">BoardList.do?page=${paramvo.page-1 }</c:if>"
			>&lsaquo;</a></li>
		<c:forEach begin="${paramvo.startpage  }" end="${paramvo.endpage }"
			step="1" var="x" varStatus="a">
			<li></li>
			<li class='<c:if test="${paramvo.page eq a.index }">active</c:if>'><a
				href="BoardList.do?page=${a.index }">${a.index}</a></li>
		</c:forEach>
		<li><a
			href="<c:if test="${paramvo.page ne paramvo.endpage }">Board.do?page=${paramvo.page+1 }</c:if>"
		>&rsaquo;</a>
		</li>
		<li>
			<a
			href="<c:if test="${paramvo.page ne paramvo.endpage }">Board.do?page=${paramvo.endpage }</c:if>"
			>&raquo;</a>
		</li>
	</ul>
</div>



<input type="button" value="글쓰기" class="btn btn-primary"
	onclick="location.href='Board.do?mode=write&board_code=${paramvo.board_code}'">
