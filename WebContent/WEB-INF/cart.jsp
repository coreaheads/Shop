<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<jsp:include page="./common/head.jsp"/>	    
<section id="cart_items">
	<div class="container">
		<div class="breadcrumbs">
			<ol class="breadcrumb">
				<li><a href="#">Home</a></li>
				<li class="active">장바구니</li>
			</ol>
		</div>
		<div class="table-responsive cart_info">
			<table class="table table-condensed">
				<thead>
					<tr class="cart_menu">
						<td class="image">상품</td>
						<td class="description"></td>
						<td class="price">가격</td>
						<td class="quantity">수량</td>
						<td class="total">금액</td>
						<td></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach begin="1" end="3">
					<tr>
						<td class="cart_product">
							<a href=""><img src="images/cart/one.png" alt=""></a>
						</td>
						<td class="cart_description">
							<h4><a href="">그냥 상의</a></h4>
							<p>천안 성환상의</p>
						</td>
						<td class="cart_price">
							<p>$59</p>
						</td>
						<td class="cart_quantity">
							<div class="cart_quantity_button">
								<a class="cart_quantity_up" href=""> + </a>
								<input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">
								<a class="cart_quantity_down" href=""> - </a>
							</div>
						</td>
						<td class="cart_total">
							<p class="cart_total_price">20,000원</p>
						</td>
						<td class="cart_delete">
							<a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
						</td>
					</tr>					
				</c:forEach>

			</tbody>
		</table>
	</div>
</div>
</section> <!--/#cart_items-->

<section id="do_action">
	<div class="container">
		<div class="heading">
			<h3>결제를 진행하시겠습니까?</h3>
			<p>금액 확인후 결제진행</p>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="total_area">
					<ul>
						<li>삼품가격(총 3개) <span>59,000원</span></li>
						<li>할인금액 <span>0원</span></li>
						<li>배송비 <span>2500원</span></li>
						<li>총금액 <span>61500원</span></li>							
					</ul>
					<a class="btn btn-default update" href="">결제하기</a>
				</div>
				
			</div>			
		</div>
	</div>
</section><!--/#do_action-->
<jsp:include page="./common/footer.jsp"/>	