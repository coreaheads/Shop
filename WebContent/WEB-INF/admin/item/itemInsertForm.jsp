<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="col-md-12">
	<form action="itemInsert.do" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="itemId" value="${item.idx }">

		<div class="form-group">
			<label for="exampleInputEmail1">itemName</label> <input type="text"
				name="itemName" class="form-control" value="">
		</div>

		<div class="form-group">
			<label for="exampleInputEmail1">가격</label> <input type="text"
				name="itemPrice" class="form-control"> <input
				type="checkbox" name="itemLevel" value="best"> <input
				type="checkbox" name="itemLevel" value="hot"> <input
				type="checkbox" name="itemLevel" value="sale">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">상품 카테고리</label> <input type="text"
				name="itemCategory" class="form-control">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">파일</label> <input type="file"
				name="imgFile" class="form-control" multiple="multiple">
		</div>
		<div class="form-group">
			<textarea name="itemContent" class="form-control"
				style="width: 100%; height: 200px"></textarea>
		</div>
		<input type="submit" class="btn btn-success" value="등록"> <a
			href="itemList.do">돌아가기</a>
	</form>
</div>