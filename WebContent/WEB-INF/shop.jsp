<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<jsp:include page="./common/head.jsp"/>	   
	<section>
		<div class="container">
			<div class="row">
			<jsp:include page="./common/side.jsp"/>				
				<div class="col-sm-9 padding-right">
					<div class="features1_items"><!--features_items-->
						<h2 class="title text-center">해당 카테고리명</h2>
						<c:forEach begin="1" end="12">
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="images/shop/product12.jpg" alt="" />
										<h2><span style="color:#DF01A5;">39,900원</span></h2>
										<p>간지상의</p>
										<a href="shopDetail.do" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>카트에 담기</a>
									</div>

								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href=""><i class="fa fa-search"></i>상품 상세보기</a></li>
									</ul>
								</div>
							</div>
						</div>						
						</c:forEach>	
						<div class="col-md-12 text-center">
						<ul class="pagination">							
							<li><a href="#">&laquo;</a></li>
							<li><a href="#">&lsaquo;</a></li>	
							<c:forEach begin="1" end="5" varStatus="status">
								<li><a href="">${status.count }</a></li>
							</c:forEach>										
							<li><a href="">&rsaquo;</a></li>
							<li><a href="">&raquo;</a></li>
						</ul>
						</div>	
					</div><!--features_items-->
				</div>
			</div>
		</div>
	</section>
<jsp:include page="./common/footer.jsp"/>	    