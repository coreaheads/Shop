<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/head.jsp" />


<h2 class="sub-header">장바구니 관리</h2>
<br>
<br>


<div class="col-md-12">
	<form class="navbar-form navbar-right" action="adminCartSearch.do"
		role="search">
		<select class="form-control" name="search" >
			<option value="memberId">회원ID</option>
			<option value="itemId">물품ID</option>
		</select>

		<div class="form-group">
			<input type="text" name="word" class="form-control"
				placeholder="Search">
		</div>
		<input type="submit" class="btn btn-default" value="검색">
	</form>
</div>

<div class="col-md-12">
	<hr>
	<div class="panel panel-info">
		<!-- Table -->
		<table class="table">
			<tr class="warning">
				<th>idx</th>
				<th>memberId</th>
				<th>ip</th>
				<th>itemId</th>
				<th>itemCount</th>
				<th>itemPrice</th>
				<th>cartDate</th>
				<th>기능</th>
				<th></th>
			</tr>

			<c:forEach items="${cartList}" var="dto">
				<tr>
					<td>${dto.idx }</td>
					<td>${dto.memberId }</td>
					<td>${dto.ip }</td>
					<td>${dto.itemId }</td>
					<td>${dto.itemCount }</td>
					<td>${dto.itemPrice }</td>
					<td>${dto.cartDate }</td>
					<td><a href="adminCartDelete.do?idx=${dto.idx }">[삭제]</a>&nbsp;&nbsp;</td>

				</tr>

			</c:forEach>
		</table>

		<br>
		<br>
		

	</div>
	<nav class='paging-number text-center'>
		<ul class='pagination'>
			<li class='disabled'><a href='#' aria-label='First'><span
					aria-hidden='true'>&lsaquo;</span></a></li>
			<li class='disabled'><a href='#' aria-label='Previous'><span
					aria-hidden='true'>&laquo;</span></a></li>
			<c:forEach begin="1" end="10" varStatus="status">
				<li></li>
				<li><a href='#'>${status.count}</a></li>
			</c:forEach>
			<li class='disabled'><a href='#' aria-label='Next'><span
					aria-hidden='true'>&rsaquo;</span></a></li>
			<li class='disabled'><a href='#' aria-label='End'><span
					aria-hidden='true'>&raquo;</span></a></li>
		</ul>
	</nav>
</div>

