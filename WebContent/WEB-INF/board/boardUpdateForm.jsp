<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form action="BoardUpdate.do" method="post"
	enctype="multipart/form-data">
	<input type="hidden" name="idx" value="${BoardDto.idx }"> 
	<input
		type="hidden" name="board_code" value="${paramvo.board_code }">
	<input type="hidden" name="page" value="${paramvo.page }"> <input
		type="hidden" name="search_txt" value="${paramvo.search_txt }">
	<input type="hidden" name="search_sel" value="${paramvo.search_sel }">
	<input type="hidden" name="mode" value="${paramvo.mode }"> <input
		type="hidden" name="categorys" value="${categorys }3">
	<div class="form-group">
		<label for="exampleInputEmail1">작성자</label> <input type="text"
			name="writer" class="form-control" value="${BoardDto.writer }">
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
			style="width: 100%; height: 200px">${BoardDto.content }</textarea>
	</div>
	<input type="submit" class="btn btn-success" value="등록">

</form>
<input type="button"
	onclick="location.href='Board.do?mode=list&board_code=${paramvo.board_code}'"
	class="btn btn-primary" value="목록으로">
