<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<jsp:include page="./common/head.jsp"/>	    
<section id="form"><!--form-->
	<div class="container">
		<div class="row">
			<div class="col-sm-4 col-sm-offset-1">
				<div class="login-form"><!--login form-->
					<h2>로그인</h2>
					<form action="#">
						<input type="text" placeholder="이름" />
						<input type="email" placeholder="이메일" />

						<button type="submit" class="btn btn-default">로그인</button>
					</form>
				</div><!--/login form-->
			</div>
			<div class="col-sm-1">
				<h2 class="or">OR</h2>
			</div>
			<div class="col-sm-4">
				<div class="signup-form"><!--sign up form-->
					<h2>회원가입!</h2>
					<form action="#">
						<input type="text" placeholder="이름"/>
						<input type="email" placeholder="이메일"/>
						<input type="password" placeholder="비밀번호"/>
						<button type="submit" class="btn btn-default">회원가입</button>
					</form>
				</div><!--/sign up form-->
			</div>
		</div>
	</div>
</section><!--/form-->
<jsp:include page="./common/footer.jsp"/>	