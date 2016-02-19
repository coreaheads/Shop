<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>중앙정보쇼핑몰</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/prettyPhoto.css" rel="stylesheet">
	<link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->  
    
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>   
    
    
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    
</head><!--/head-->

<body>
	<header id="header"><!--header-->
		
		<div class="header-middle"><!--header-middle-->
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
								<li class="dropdown">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown">나의정보<b class="caret"></b></a>
									<ul class="dropdown-menu">
										<li>
											<a href="modifyPwForm.do">비밀번호 변경</a>
										</li>
										<li>
											<a href="modifyForm.do?member_no=${myInfo.member_no}">정보수정</a>
										</li>
										<li>
											<a href="delete.do?member_no=${myInfo.member_no }">회원탈퇴</a>
										</li>
									</ul>
								</li>	
							</c:if>
							<c:if test="${empty myInfo}">
								<li><a href="loginForm.do">로그인</a></li>
								<li><a href="registForm.do">회원가입</a></li>
								</c:if>
								<li><a href="memberCartList.do?memberId=${myInfo.member_id }">장바구니</a></li>
								
								
								<c:if test="${myInfo.member_level_no eq 99}">
									<li><a href="admin.do">관리자페이지</a></li>
								</c:if>		
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
		
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="index.do" class="active">Home</a></li>
								<li class="dropdown"><a href="#">Shop<i class="fa fa-angle-down"></i></a>
									<ul role="menu" class="sub-menu">
										<li><a href="shop.do">최신상품보기</a></li>
										<li><a href="index.do">인기상품보기</a></li> 
									</ul>
								</li> 
								<li><a href="index.do">Contact</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/header-bottom-->
	</header><!--/header-->