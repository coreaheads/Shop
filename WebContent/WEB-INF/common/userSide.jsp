<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-sm-3">
	<div class="left-sidebar">
		<h2>Category</h2>
		<div class="panel-group category-products" id="accordian"><!--category-productsr-->
		
							<c:forEach items="${categoryFirst}" var="x" begin="0">
							
							
	<c:if test="${x.step == 0}">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#s_${x.idx }">
							<span class="badge pull-right"><i class="fa fa-plus"></i></span>
							${x.categoryName }<br>
						</a>
					</h4>
				</div>
				
				<div id="s_${x.idx }" class="panel-collapse collapse">
				
				<c:forEach items="${categoryFirst }" var="y">
				<c:if test="${y.step > 0}">
					<c:if test="${x.rootNum == y.rootNum}">
					<div class="panel-body">
						<ul>
							<li><a href="userItemList.do?itemCategory=${y.idx }">${y.categoryName}</a></li>
						</ul>
					</div>
					</c:if>
				</c:if>
					
					
				</c:forEach>
				
				</div>
			</div>
			</c:if>
							</c:forEach>
		
		</div><!--/category-products-->
		
		<div class="brands_products"><!--brands_products-->
			<h2>Brands</h2>
			<div class="brands-name">
				<ul class="nav nav-pills nav-stacked">
					<li><a href="#"> <span class="pull-right">(50)</span>나이키</a></li>
					<li><a href="#"> <span class="pull-right">(56)</span>나이키</a></li>
					<li><a href="#"> <span class="pull-right">(27)</span>나이키</a></li>
					<li><a href="#"> <span class="pull-right">(32)</span>나이키</a></li>
					<li><a href="#"> <span class="pull-right">(5)</span>나이키</a></li>
				</ul>
			</div>
		</div><!--/brands_products-->
		
		<div class="shipping text-center"><!--shipping-->
			<img src="images/home/shipping.jpg" alt="" />
		</div><!--/shipping-->
		
	</div>
</div>