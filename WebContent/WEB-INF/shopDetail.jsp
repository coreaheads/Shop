<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<jsp:include page="head.jsp"/>	   
<section>
	<div class="container">
		<div class="row">
			<jsp:include page="side.jsp"/>			
			<div class="col-sm-9 padding-right">
				<div class="product-details"><!--product-details-->
					<div class="col-sm-5">
						<div class="view-product">
							<img src="images/product-details/1.jpg" alt="" />
						</div>


					</div>
					<div class="col-sm-7">
						<div class="product-information"><!--/product-information-->
							<img src="images/product-details/new.jpg" class="newarrival" alt="" />
							<h2>간지 상품</h2>
							<p>중앙이 적극 추천합니다.</p>
							<img src="images/product-details/rating.png" alt="" />
							<span>
								<span>59,000원</span>
								<label>수량 : </label>
								<input type="text" value="2" />
								<button type="button" class="btn btn-fefault cart">
									<i class="fa fa-shopping-cart"></i>
									장바구니 담기
								</button>
							</span>
							<p><b>재질 :</b> 면</p>
							<p><b>Brand:</b> 중앙정보처리학원</p>
							<a href=""><img src="images/product-details/share.png" class="share img-responsive"  alt="" /></a>
						</div><!--/product-information-->
					</div>
				</div><!--/product-details-->
				
				이쪽은 상품후기 나오게 하면 되지 않을까?

				
			</div>
		</div>
	</div>
</section>
<jsp:include page="footer.jsp"/>	    