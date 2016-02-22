<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-md-12">
	<input type="button" class="btn  btn-primary" onclick="location.href='item.do?mode=insert'"
		value="상품등록">
	<form class="navbar-form navbar-right" action="free_board_list.do"
		role="search">
		<select class="form-control" name="select_free_board" id="sel1">
			<option value="member_id">작성자</option>
			<option value="free_board_title">제목</option>
		</select>

		<div class="form-group">
			<input type="text" name="find_free_board" class="form-control"
				placeholder="Search">
		</div>
		<button type="submit" class="btn btn-default">Search</button>
	</form>
</div>

<div class="col-md-12">
	<hr>
	<div class="panel panel-info">
		<!-- Table -->
		<table class="table">
			<tr class="warning">
				<th>idx</th>
				<th>상품명</th>
				<th>상품 등급</th>
				<th>상품 가격</th>
				<th>상품 수량</th>
				<th>상품 카테고리</th>
				<th>상품 이미지</th>
				<th>is_del</th>
			</tr>
			<c:forEach items="${itemList }" var="x">

				<tr>
					<td><a href="item.do?mode=detail&idx=${x.idx }">${x.idx}</a></td>
					<td>${x.itemName}</td>
					<td>${x.itemLevel}</td>
					<td>${x.itemPrice}</td>
					<td>${x.itemCount }</td>
					<td>${x.itemCategory}</td>
					<td>${x.url }</td>
					<td>${x.isDel }</td>
				</tr>

			</c:forEach>
		</table>
	</div>
	<nav class='paging-number text-center'>
		<ul class='pagination'>
			<li
				class='<c:if test="${paramvo.page eq 1 or empty paramvo.page  }">disabled</c:if>'><a
				href='<c:if test="${paramvo.page eq 1 or  empty paramvo.page }">item.do?page=1&mode=lsit</c:if>'
				aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>
			<li class='<c:if test="${paramvo.page ne 1 }">disabled</c:if>'><a
				href="<c:if test="${paramvo.page ne 1}">${paramvo.url }.do?page=${paramvo.page-1 }</c:if>"
				aria-label='First'><span aria-hidden='true'>&lsaquo;</span></a></li>
			<c:forEach begin="${paramvo.startpage  }" end="${paramvo.endpage }"
				step="1" var="x" varStatus="a">
				<li></li>
				<li class='<c:if test="${paramvo.page eq a.index }">active</c:if>'><a
					href="item.do?page=${a.index }&mode=lsit">${a.index}</a></li>
			</c:forEach>
			<li
				class='<c:if test="${paramvo.page eq paramvo.endpage }">disabled</c:if>'>
				<a
				href="<c:if test="${paramvo.page ne paramvo.endpage }">item.do?page=${paramvo.page+1 }&mode=lsit</c:if>"
				aria-label='Next'><span aria-hidden='true'>&rsaquo;</span></a>
			</li>
			<li
				class='<c:if test="${paramvo.page eq paramvo.endpage }">disabled</c:if>'>
				<a
				href="<c:if test="${paramvo.page ne paramvo.endpage }">item.do?page=${paramvo.endpage }&mode=lsit</c:if>"
				aria-label='End'><span aria-hidden='true'>&raquo;</span></a>
			</li>
		</ul>
	</nav>
</div>
