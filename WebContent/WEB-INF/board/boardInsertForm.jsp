<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp"%>
</head>
<body style="padding:30px">
	<form class="" action="insert.do" method="post"
		enctype="multipart/form-data">
		<div class="form-group">
			<label>아이디</label> <input type="text" class="form-control" name="itemId">
		</div>
		<div class="form-group">
			<label>상품명</label> <input type="text" class="form-control" name="itemName">
		</div>
		<div class="form-group">
			<label>이미지</label> <input type="file" class="form-control" name="imgFile">
		</div>
		<div class="form-group">
			<label>가격</label> <input type="text" class="form-control" name="itemPrice">
		</div>
		<div class="form-group">
			<label>상품설명</label>
			<textarea rows="10" name="itemContent" class="form-control" cols="30"></textarea>
		</div>
		<input type="submit" class="btn btn-primary">

	</form>
</body>
</html>