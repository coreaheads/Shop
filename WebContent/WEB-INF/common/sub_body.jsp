<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-9 padding-right">

	<div class="category-tab">
		<div class="tab-content">
			<div class="tab-pane fade active in" id="top">
				<c:forEach items="${itemList}" var="item" varStatus="status">
					<div class="col-sm-3">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
									<img src="item_upload_img/${item.url}" alt="" />
									<h2>${item.itemPrice}원</h2>
									<p>${item.itemName}</p>
									<a href="#" class="btn btn-default add-to-cart"><i
										class="fa fa-search"></i>상품 상세보기</a>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="">
										<i class="fa fa-shopping-cart"></i>
										카트에 담기</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>
	</div>
	<!--/category-tab-->

	
</div>