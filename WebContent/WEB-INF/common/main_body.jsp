<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-sm-9 padding-right">

	<div class="category-tab">
		<!--category-tab-->
		<div class="col-sm-12">
			<ul class="nav nav-tabs">
				<li class="active"><a href="#top" data-toggle="tab">상의</a></li>
				<li><a href="#pants" data-toggle="tab">하의</a></li>
				<li><a href="#outer" data-toggle="tab">아우터</a></li>
				<li><a href="#knit" data-toggle="tab">니트</a></li>
				<li><a href="#theme" data-toggle="tab">테마의류</a></li>
			</ul>
		</div>
		<div class="tab-content">
			<div class="tab-pane fade active in" id="top">
				<c:forEach begin="1" end="4" varStatus="status">
					<div class="col-sm-3">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
									<img src="images/home/gallery${status.count}.jpg" alt="" />
									<h2>27,000원</h2>
									<p>여성 상의</p>
									<a href="#" class="btn btn-default add-to-cart"><i
										class="fa fa-search"></i>상품 상세보기</a>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href=""><i class="fa fa-shopping-cart"></i>카트에
												담기</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<div class="tab-pane fade" id="pants">
				<c:forEach begin="1" end="4" varStatus="status">
					<div class="col-sm-3">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
									<img src="images/home/gallery${status.count}.jpg" alt="" />
									<h2>27,000원</h2>
									<p>여성 상의</p>
									<a href="#" class="btn btn-default add-to-cart"><i
										class="fa fa-search"></i>상품 상세보기</a>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href=""><i class="fa fa-shopping-cart"></i>카트에
												담기</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<div class="tab-pane fade" id="outer">
				<c:forEach begin="1" end="4" varStatus="status">
					<div class="col-sm-3">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
									<img src="images/home/gallery${status.count}.jpg" alt="" />
									<h2>271,000원</h2>
									<p>여성 상의</p>
									<a href="#" class="btn btn-default add-to-cart"><i
										class="fa fa-search"></i>상품 상세보기</a>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href=""><i class="fa fa-shopping-cart"></i>카트에
												담기</a></li>
									</ul>
								</div>

							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="tab-pane fade" id="knit">
				<c:forEach begin="1" end="4" varStatus="status">
					<div class="col-sm-3">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
									<img src="images/home/gallery${status.count}.jpg" alt="" />
									<h2>271,000원</h2>
									<p>여성 상의</p>
									<a href="#" class="btn btn-default add-to-cart"><i
										class="fa fa-search"></i>상품 상세보기</a>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href=""><i class="fa fa-shopping-cart"></i>카트에
												담기</a></li>
									</ul>
								</div>

							</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<div class="tab-pane fade" id="theme">
				<c:forEach begin="1" end="4" varStatus="status">
					<div class="col-sm-3">
						<div class="product-image-wrapper">
							<div class="single-products">
								<div class="productinfo text-center">
									<img src="images/home/gallery${status.count}.jpg" alt="" />
									<h2>271,000원</h2>
									<p>여성 상의</p>
									<a href="#" class="btn btn-default add-to-cart"><i
										class="fa fa-search"></i>상품 상세보기</a>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href=""><i class="fa fa-shopping-cart"></i>카트에
												담기</a></li>
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

	<div class="recommended_items">
		<!--Best 상품-->
		<h2 class="title text-center">Best 상품</h2>

		<div id="recommended-item-carousel" class="carousel slide"
			data-ride="carousel">
			<div class="carousel-inner">
				<div class="item active">
					<c:forEach begin="1" end="3" varStatus="status">
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="images/home/recommend${status.count}.jpg" alt="" />
										<h2>27,000원</h2>
										<p>여성 상의</p>
										<a href="#" class="btn btn-default add-to-cart"><i
											class="fa fa-search"></i>상품 상세보기</a>
									</div>
									<div class="choose">
										<ul class="nav nav-pills nav-justified">
											<li><a href=""><i class="fa fa-shopping-cart"></i>카트에
													담기</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="item">
					<c:forEach begin="1" end="3" varStatus="status">
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="images/home/recommend1.jpg" alt="" />
										<h2>271,000원</h2>
										<p>여성 상의</p>
										<a href="#" class="btn btn-default add-to-cart"><i
											class="fa fa-search"></i>상품 상세보기</a>
									</div>
									<div class="choose">
										<ul class="nav nav-pills nav-justified">
											<li><a href=""><i class="fa fa-shopping-cart"></i>카트에
													담기</a></li>
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
	<div class="new_items">
		<!--최신상품-->
		<h2 class="title text-center">최신 상품</h2>

		<div id="new-item-carousel" class="carousel slide"
			data-ride="carousel">
			<div class="carousel-inner">
				<div class="item active">
					<c:forEach begin="1" end="3" varStatus="status">
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="images/home/recommend1.jpg" alt="" />
										<h2>27,000원</h2>
										<p>여성 상의</p>
										<a href="#" class="btn btn-default add-to-cart"><i
											class="fa fa-search"></i>상품 상세보기</a>
									</div>
									<div class="choose">
										<ul class="nav nav-pills nav-justified">
											<li><a href=""><i class="fa fa-shopping-cart"></i>카트에
													담기</a></li>
										</ul>
									</div>

								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="item">
					<c:forEach begin="1" end="3" varStatus="status">
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="images/home/recommend1.jpg" alt="" />
										<h2>27,000원</h2>
										<p>여성 상의</p>
										<a href="#" class="btn btn-default add-to-cart"><i
											class="fa fa-search"></i>상품 상세보기</a>
									</div>
									<div class="choose">
										<ul class="nav nav-pills nav-justified">
											<li><a href=""><i class="fa fa-shopping-cart"></i>카트에
													담기</a></li>
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