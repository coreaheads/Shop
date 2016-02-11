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
		<c:forEach items="${boardList }" var="list">
			<tr>
				<td>${list.idx }</td>
				<td><a href="View.do?num=${list.idx }">${list.title }</a></td>
				<td>${list.writer }</td>
				<td>${list.create_time }</td>
			</tr>
		</c:forEach>
	</table>
	<input type="button" value="글쓰기" class="btn btn-primary"
		onclick="location.href='Write.do'">



</body>
</html>