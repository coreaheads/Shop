<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp"%>
</head>
<body style="padding: 30px">
	<form action="BoardUpdate.do" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="idx" value="${BoardDto.idx }"> 
		<input type="hidden" name="member_seq" value="${mem.idx }1"> <input
			type="hidden" name="board_code" value="${board_code }2"> <input
			type="hidden" name="categorys" value="${categorys }3">
		<div class="form-group">
			<label for="exampleInputEmail1">작성자</label> <input type="text"
				name="writer" class="form-control" value="${BoardDto.writer }"> <input
				type="checkbox" name="is_notice" value="Y" <c:if test="${BoardDto.is_notice eq 'Y' }"> checked </c:if>>
		</div>
		
		<div class="form-group">
			<label for="exampleInputEmail1">이메일</label> <input type="text"
				name="email" class="form-control" value="${BoardDto.email }">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">제목</label> <input type="text"
				name="title" class="form-control" value="${BoardDto.title }">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">파일</label> <input type="file"
				name="imgFile" class="form-control" multiple="multiple">
			${BoardDto.url }
		</div>
		<div class="form-group">
			<textarea name="content" class="form-control"
				style="width: 100%; height: 200px">v${BoardDto.content }</textarea>
		</div>
		<input type="submit" class="btn btn-success" value="등록">

	</form>
	<input type="button" onclick="location.href='BoardList.do'"
		class="btn btn-primary" value="목록으로">

</body>
</html>