<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-sm-9 padding-right">
	<jsp:include page="../common/slider.jsp" />
	<div class="recommended_items">
		<!--Best 상품-->
		<h2 class="title text-center">Best 상품</h2>

		<div id="recommended-item-carousel" class="carousel slide"
			data-ride="carousel">
			<div class="carousel-inner">
				<div class="item active">
					<c:forEach items="${itemBestList}" var="bestitem"
						varStatus="status">
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="item_upload_img/${bestitem.url}" alt="" />
										<h2>${bestitem.itemPrice}원</h2>
										<p>${bestitem.itemName}</p>
										<a href="ItemMain.do?mode=detail&idx=${bestitem.idx }" class="btn btn-default add-to-cart"><i
											class="fa fa-search"></i>상품 상세보기</a>
									</div>
									<div class="choose">
										<ul class="nav nav-pills nav-justified">
											<li><a href=""> <i class="fa fa-shopping-cart"></i>
													카트에 담기
											</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>

				
				<div class="item">
					<c:forEach items="${itemBestList2}" var="bestitem2"
						varStatus="status">
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="item_upload_img/${bestitem2.url}" alt="" />
										<h2>${bestitem2.itemPrice}원</h2>
										<p>${bestitem2.itemName}</p>
										<a href="ItemMain.do?mode=detail&idx=${bestitem2.idx }" class="btn btn-default add-to-cart"><i
											class="fa fa-search"></i>상품 상세보기</a>
									</div>
									<div class="choose">
										<ul class="nav nav-pills nav-justified">
											<li><a href=""> <i class="fa fa-shopping-cart"></i>
													카트에 담기
											</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<a class="left recommended-item-control"
				href="#recommended-item-carousel" data-slide="prev"> <i
				class="fa fa-angle-left"></i>
			</a> <a class="right recommended-item-control"
				href="#recommended-item-carousel" data-slide="next"> <i
				class="fa fa-angle-right"></i>
			</a>
		</div>
	</div>
	<!--/Best 상품-->
	<hr>
	<div class="new_items">
		<!--최신상품-->
		<h2 class="title text-center">최신 상품</h2>

		<div id="new-item-carousel" class="carousel slide"
			data-ride="carousel">
			<div class="carousel-inner">
				<div class="item active">
					<c:forEach items="${itemNewList}" var="neweitem" varStatus="status">
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="item_upload_img/${neweitem.url}" alt="" />
										<h2>${neweitem.itemPrice}원</h2>
										<p>${neweitem.itemName}</p>
										<a href="ItemMain.do?mode=detail&idx=${neweitem.idx }" class="btn btn-default add-to-cart"><i
											class="fa fa-search"></i>상품 상세보기</a>
									</div>
									<div class="choose">
										<ul class="nav nav-pills nav-justified">
											<li><a href=""> <i class="fa fa-shopping-cart"></i>
													카트에 담기
											</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="item">
					<c:forEach items="${itemNewList2}" var="neweitem2"
						varStatus="status">
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="item_upload_img/${neweitem2.url}" alt="" />
										<h2>${neweitem2.itemPrice}원</h2>
										<p>${neweitem2.itemName}</p>
										<a href="ItemMain.do?mode=detail&idx=${neweitem2.idx }" class="btn btn-default add-to-cart"><i
											class="fa fa-search"></i>상품 상세보기</a>
									</div>
									<div class="choose">
										<ul class="nav nav-pills nav-justified">
											<li><a href=""> <i class="fa fa-shopping-cart"></i>
													카트에 담기
											</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<a class="left recommended-item-control" href="#new-item-carousel"
				data-slide="prev"> <i class="fa fa-angle-left"></i>
			</a> <a class="right recommended-item-control" href="#new-item-carousel"
				data-slide="next"> <i class="fa fa-angle-right"></i>
			</a>
		</div>
	</div>
	<!--/최신상품-->
</div>