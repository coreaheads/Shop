<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header id="header">
	<!--header-->

	<div class="header-middle">
		<!--header-middle-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4">
					<div class="logo pull-left">
						<a href="index.do"><img src="images/home/logox.png" alt="" /></a>
					</div>
				</div>
				<div class="col-sm-8">
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav navbar-right">
							<c:if test="${not empty myInfo}">
								<li><a href="logOut.do">로그아웃</a></li>
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown">나의정보<b class="caret"></b></a>
									<ul class="dropdown-menu">
										<li><a href="modifyPwForm.do">비밀번호 변경</a></li>
										<li><a href="modifyForm.do?member_no=${myInfo.member_no}">정보수정</a>
										</li>
										<li><a href="delete.do?member_no=${myInfo.member_no }">회원탈퇴</a>
										</li>
									</ul></li>
							</c:if>
							<c:if test="${empty myInfo}">
								<li><a href="loginForm.do">로그인</a></li>
								<li><a href="registForm.do">회원가입</a></li>
							</c:if>
							<li><a href="cart.do">장바구니</a></li>

							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">게시판<b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="index.do">QA</a></li>
									<li><a href="index.do">자유게시판</a></li>
									<li><a href="index.do">묻고답하기</a></li>
								</ul></li>
							<c:if test="${myInfo.member_level_no eq 99}">
								<li><a href="admin.do">관리자페이지</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/header-middle-->