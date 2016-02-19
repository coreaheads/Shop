<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../common/head.jsp" />
<section>
	<div class="container">
		<div class="row">
			<!-- 왼쪽메뉴 -->
			<jsp:include page="../common/userSide.jsp" />
			<!-- 왼쪽메뉴 -->
			<!--  메인바디 -->
			<div class="col-sm-9 padding-right">
				<jsp:include page="${paramvo.url }" />
			</div>
			<!--  메인바디 -->
		</div>
	</div>
</section>
<jsp:include page="../common/footer.jsp" />





