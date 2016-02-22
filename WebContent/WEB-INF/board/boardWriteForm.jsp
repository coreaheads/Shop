<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/include/header.jsp"%>
<body style="padding:30px;">
<form action="BoardInsert.do" method="post"  enctype="multipart/form-data">
<input type="hidden" name="member_seq" value="${mem.idx }1">
<input type="hidden" name="board_code" value="${paramvo.board_code }">
<input type="hidden" name="page" value="${paramvo.page }">
<input type="hidden" name="search_txt" value="${paramvo.search_txt }">
<input type="hidden" name="search_sel" value="${paramvo.search_sel }">
<input type="hidden" name="mode" value="${paramvo.mode }">
<input type="hidden" name="categorys" value="${categorys }3">

	
	<div class="form-group">
   	 	<label for="exampleInputEmail1">작성자</label>
		<input type="text" name="writer" class="form-control" value="${myInfo.member_name }" ${not empty myInfo.member_name ? 'readonly' : ''  }>
		
		
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
