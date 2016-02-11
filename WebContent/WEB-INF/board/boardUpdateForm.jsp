<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/include/header.jsp"%>
</head>
<body style="padding: 30px">
	<form class="" action="upload.do" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="url" class="form-control"
			value="${item.url}">
		<div class="form-group">
			<label>아이디</label> <input type="text" name="itemId"
				class="form-control" readonly="readonly" value="${item.itemId}">
		</div>
		<div class="form-group">
			<label>상품명</label> <input type="text" name="itemName"
				class="form-control" value="${item.itemName}">
		</div>
		<div class="form-group">
			<label>이미지</label> <input type="file" name="imgFile"
				class="form-control" value=""> ${item.url}
		</div>
		<div class="form-group">
			<label>가격</label> <input type="text" name="itemPrice"
				class="form-control" value="${item.itemPrice}">
		</div>
		<div class="form-group">
			<label>상품설명</label>
			<textarea rows="10" name="itemContent" class="form-control" cols="30">${item.itemContent}</textarea>
		</div>
		<input type="submit" class="btn btn-primary" value="수정">

	</form>
	<input type="button" onclick="location.href='itemList.do'"
		class="btn btn-primary" value="목록으로">

</body>
</html>