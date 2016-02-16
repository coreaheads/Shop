<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp"%>
</head>
<body>
	<table class="table">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
		</tr>
		
		<c:forEach items="${BoardList }" var="list">
			<tr>
				<td>${list.idx }</td>
				<td>
				${list.step}
				<c:if test="${list.step>0 }">
				ㄴ
					<c:forEach begin="1" end="${list.step}">
					&nbsp;&nbsp;&nbsp;&nbsp;
					</c:forEach>
				</c:if> 
				<a href="BoardView.do?idx=${list.idx }">${list.title }</a></td>
				<td>${list.writer }</td>
				<td>${list.create_time }</td>
			</tr>
		</c:forEach>
	</table>
	
	<nav class='paging-number text-center'>
		<ul class='pagination'>
			
			<li class='<c:if test="${param.page eq 1 }">disabled</c:if>'><a href="BoardList.do?page=1" aria-label='Previous'><span
					aria-hidden='true'>&laquo;</span></a></li>
					<li class='<c:if test="${param.page eq 1 }">disabled</c:if>'><a href="<c:if test="${param.page ne 1 }">BoardList.do?page=${paramvo.page-1 }</c:if>" aria-label='First'><span
					aria-hidden='true'>&lsaquo;</span></a></li>
			<c:forEach begin="${paramvo.startpage  }" end="${paramvo.endpage }" step="1"	var="x" varStatus="a">
				<li></li>
				<li class='<c:if test="${paramvo.page eq a.index }">active</c:if>'><a href="BoardList.do?page=${a.index }">${a.index}</a></li>
			</c:forEach>
			<li class='<c:if test="${paramvo.page eq paramvo.endpage }">disabled</c:if>'>
			<a href="<c:if test="${paramvo.page ne paramvo.endpage }">BoardList.do?page=${paramvo.page+1 }</c:if>" aria-label='Next'><span
					aria-hidden='true'>&rsaquo;</span></a></li>
			<li class='<c:if test="${paramvo.page eq paramvo.endpage }">disabled</c:if>'>
			<a href="<c:if test="${paramvo.page ne paramvo.endpage }">BoardList.do?page=${paramvo.endpage }</c:if>" aria-label='End'><span
					aria-hidden='true'>&raquo;</span></a></li>
		</ul>
	</nav>
	
	<input type="button" value="글쓰기" class="btn btn-primary"
		onclick="location.href='BoardWriteForm.do'">



</body>
</html>