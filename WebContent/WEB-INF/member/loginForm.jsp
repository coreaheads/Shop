<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/head.jsp"/>	
<script type="text/javascript">
	function checkLogin(){
		if($('#member_id').val().length < 4){
			alert("아이디를 4자이상 적어주세요");
			return false;
		}
		if($('#member_pw').val().length < 4){
			alert("비밀번호를 4자이상 적어주세요.");
			return false;
		}
		$("#loginForm").submit();
	}
</script>
<section id="form"><!--form-->
	<div class="container">

		<!-- Content Row -->
		<div class="row row-centered">

			<!-- Content Column -->
			<div class="col-md-12 col-centered">
				<form name="loginForm" id="loginForm" action="login.do" method="post" onsubmit="return checkLogin();">
					<fieldset>
						<legend>로그인</legend>
						<div class="form-group">
							<div class="col-md-12">
								<label for="member_id" >아이디(이메일)</label>
								<input type="text" name="member_id" id="member_id" class="form-control" placeholder="아이디(이메일) ex)test@gmail.com"/>
							</div>
							<div class="col-md-12">
								<label for="member_pw">비밀번호</label>
								<input type="password" name="member_pw" id="member_pw" class="form-control" placeholder="비밀번호"/>
							</div>
							
							<div class="col-md-12">
								<label for="login_submit"></label>
								<input type="submit" name="login_submit" id="login_submit" class="form-control btn btn-info" value="로그인">         
							</div>
							<div class="col-md-12">
								<label for="login_reset"></label>
								<input type="reset" name="login_reset" id="login_reset" class="form-control btn btn-danger" value="취소">         
							</div>      
						</div>
					</fieldset>				
				</form>
			</div>
		</div>
		<!-- /.row -->
	</div>
</section><!--/form-->
<jsp:include page="../common/footer.jsp"/>