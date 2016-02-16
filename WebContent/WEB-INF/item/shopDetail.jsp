<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<jsp:include page="../admin/common/head.jsp"/>	
<script>
function myFunction(item){
	var co = $('#itemCount option:selected').val();
	co=co*item;
	var sale  ="총가격 : ";
	$("#totalMoney").html(sale+co+"원");
}
</script>  
<section>
	<div class="container">
		<div class="row">
			<jsp:include page="../common/side.jsp"/>		
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
							<h2>${item.itemName }</h2>
							<p>중앙이 적극 추천합니다.</p>
					        <span>
								<span style="color:gray; font-size: 20px;"><del><i>가격 : ${item.itemPrice }원</i></del></span>
							</span>
								 <form action="memberCartInsert.do" method="post">
							<span>
								<span style="color:#ce1710;">할인된 가격 : <i>${item.sale }원</i></span>
<%-- 								<label>수량 : ${item.itemCount }</label> --%>
							<select name ="itemCount"  id="itemCount" onchange="myFunction(${item.sale })">
								<option value="">남은수량 : ${item.itemCount }</option>
						<c:forEach begin="1" end="${item.itemCount }" varStatus="i">
								<option  value="${i.count}">${i.index }개&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${i.index * item.sale } 원</option>
								</c:forEach> 
								 </select>
								<input type="hidden" name="memberId" value="${myInfo.member_id }">
								<input type="hidden" name="itemId" value="${item.idx }">
							   											
							</span>
								 </form>
							<p><b>재질 :</b> 면</p>
							<p><b id="totalMoney"></b></p>
							<p><b>Brand:</b> 중앙정보처리학원</p>
								<a href=""><img src="images/product-details/share.png" class="share img-responsive"  alt="" /></a>
							<hr>						
							<div class="col-md-12 ">
								<button type="submit" class="btn btn-danger form-control ">
						        <i class="fa fa-shopping-cart "></i> 장바구니
						        </button>								
							</div>	
						</div><!--/product-information-->					
					</div>
				</div><!--/product-details-->
				
				이쪽은 상품후기 나오게 하면 되지 않을까?

				
			</div>
		</div>
	</div>
</section>
<jsp:include page="../admin/common/footer.jsp"/>	    