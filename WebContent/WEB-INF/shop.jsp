<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<jsp:include page="./common/head.jsp"/>	   
	<section id="advertisement">
		<div class="container">
			<img src="images/shop/aa.jpg" alt="" />
		</div>
	</section>
	
	<section>
		<div class="container">
			<div class="row">
			<jsp:include page="side.jsp"/>				
				<div class="col-sm-9 padding-right">
					<div class="features1_items"><!--features_items-->
						<h2 class="title text-center">Features Items</h2>
						<c:forEach begin="1" end="12">
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="images/shop/product12.jpg" alt="" />
										<h2>39,900원</h2>
										<p>간지상의</p>
										<a href="shopDetail.do" class="btn btn-default add-to-cart"><i class="fa fa-search"></i>상품 상세보기</a>
									</div>

								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href=""><i class="fa fa-shopping-cart"></i>카트에 담기</a></li>
									</ul>
								</div>
							</div>
						</div>						
						</c:forEach>						
						<ul class="pagination">
							<li class="active"><a href="">1</a></li>
							<li><a href="">2</a></li>
							<li><a href="">3</a></li>
							<li><a href="">&raquo;</a></li>
						</ul>
					</div><!--features_items-->
				</div>
			</div>
		</div>
	</section>
<jsp:include page="./common/footer.jsp"/>	    