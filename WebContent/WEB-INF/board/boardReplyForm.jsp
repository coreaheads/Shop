<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<form action="BoardReply.do" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="member_seq" value="${mem.idx }1"> <input
			type="hidden" name="board_code" value="${BoardDto.board_code }">
		<input type="hidden" name="seq" value="${BoardDto.seq }">
		<input type="hidden" name="levels" value="${BoardDto.levels }">
		<input type="hidden" name="step" value="${BoardDto.step }">
		 <input	type="hidden" name="categorys" value="${categorys }3">
		 
		

		<div class="form-group">
			<label for="exampleInputEmail1">작성자</label> <input type="text"
				name="writer" class="form-control" value="${mem.name }"> 
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">패스워드</label> <input type="password"
				name="passwd" class="form-control">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">이메일</label> <input type="text"
				name="email" class="form-control">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">제목</label> <input type="text"
				name="title" class="form-control">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">파일</label> <input type="file"
				name="imgFile" class="form-control" multiple="multiple">
		</div>
		
		<div class="form-group">
			<label for="exampleInputEmail1">원글</label> 
<div id="vContent" class="content" style="font-size: 18px;">
		 ${BoardDto.content }
			</div>
		</div>
		
		<div class="form-group">
		 
	
			<textarea name="content" class="form-control"
				style="width: 100%; height: 200px"></textarea>
		</div>
		<input type="submit" class="btn btn-success" value="등록">
	</form>
