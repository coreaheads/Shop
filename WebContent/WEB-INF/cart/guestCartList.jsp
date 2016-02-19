<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-12">
<h2 class="sub-header">비회원 장바구니</h2>
	<hr>
	<div class="panel panel-info">
		<!-- Table -->
		<table class="table">
			<tr class="warning">
				<th>idx</th>
				<th>memberId</th>
				<th>ip</th>
				<th>itemId</th>
				<th>itemName</th>
				<th>itemPrice</th>
				<th>itemCount</th>
				<th>남은 수량</th>
				<th>총 가격</th>
				<th>cartDate</th>
				<th>상품 이미지</th>
				<th>삭제</th>
				<th></th>
			</tr>

			<c:forEach items="${cartList}" var="dto">
				<tr>
					<td>${dto.idx }</td>
					<td>${dto.memberId }</td>
					<td>${dto.ip }</td>
					<td>${dto.itemId }</td>
					<td>${dto.itemName }</td>
					<td>${dto.itemPrice }원</td>

					<td><a href="guestCartItemCountUp.do?itemId=${dto.itemId}">△</a><br>
						${dto.itemCount } 개<br> <a
						href="guestCartItemCountDown.do?itemId=${dto.itemId}">▽</a></td>

					<td><c:choose>
							<c:when test="${dto.item_itemCount == 0 }">
								<font color="red"><b>품절</b></font>
							</c:when>
							<c:otherwise>${dto.item_itemCount }</c:otherwise>
						</c:choose></td>
					<td>${dto.itemCount*dto.itemPrice }원</td>
					<td>${dto.cartDate }</td>
					<td>${dto.url }
					<td><a href="guestCartDelete.do?idx=${dto.idx }">[삭제]</a>&nbsp;&nbsp;</td>

				</tr>

			</c:forEach>
		</table>
		<br>
		<br> 총 금액 : ${totalPrice } 원 <br> <br>

		<form action="payForm.do" method="post">
			<input type="hidden" name="isMember" value="N"> <input
				type="hidden" name="cartList" value="${cartList }"> <input
				type="hidden" name="totalPrice" value="${totalPrice }"> <input
				type="submit" value="결제하기">
		</form>

		<br> <br>
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

