<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp"%>
<body style="padding:30px;">
<form action="BoardInsert.do" method="post"  enctype="multipart/form-data">
<input type="hidden" name="member_seq" value="${mem.idx }1">
<input type="hidden" name="board_code" value="${board_code }2">
<input type="hidden" name="categorys" value="${categorys }3">


	<div class="form-group">
   	 	<label for="exampleInputEmail1">작성자</label>
		<input type="text" name="writer" class="form-control" value="${mem.name }">
		<input type="checkbox" name="is_notice" value="Y" >
		
  	</div>
  	<div class="form-group">
   	 	<label for="exampleInputEmail1">패스워드</label>
		<input type="password" name="passwd" class="form-control">
  	</div>
  	<div class="form-group">
   	 	<label for="exampleInputEmail1">이메일</label>
		<input type="text" name="email" class="form-control">
  	</div>
  	<div class="form-group">
   	 	<label for="exampleInputEmail1">제목</label>
		<input type="text" name="title" class="form-control">
  	</div>
  	<div class="form-group">
   	 	<label for="exampleInputEmail1">파일</label>
		<input type = "file" name = "imgFile" class="form-control" multiple="multiple">
  	</div>
  	<div class="form-group">
   	 	<textarea name="content" class="form-control" 
						style="width: 100%; height: 200px"></textarea>
  	</div>
  <input type="submit" class="btn btn-success" value="등록">
	

	</form>
</body>
</html>
