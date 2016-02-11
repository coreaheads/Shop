<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/head.jsp"/>	
<script type="text/javascript">
	function checkModifyPw(){
		if($('#oldPassword').val().length < 4){
			alert("현재 비밀번호를 4자이상 적어주세요.");
			return false;
		}
		if($('#newPassword').val().length < 4){
			alert("변경할 비밀번호를 4자이상 적어주세요.");
			return false;
		}
		if($('#newConfirmPassword').val().length < 4){
			alert("변경할 비밀번호 확인를 4자이상 적어주세요.");
			return false;
		}
		if($("#newPassword").val() != $("#newConfirmPassword").val()){
			alert("변경할 비밀번호와 변경할 비밀번호 확인의 값이 다릅니다.");
			$("#newPassword").focus();
			return false;
		}				
		$("#modifyPwForm").submit();
	}
</script>
<section id="form"><!--form-->
	<div class="container">

		<!-- Content Row -->
		<div class="row row-centered">

			<!-- Content Column -->
			<div class="col-md-12 col-centered">
				<form name="modifyPwForm" id="modifyPwForm" action="modifyPw.do" method="post" onsubmit="return checkModifyPw();">
				<input type="hidden" name="member_no" value="${myInfo.member_no}">
					<fieldset>
					<legend>비밀번호 변경</legend>
						<div class="form-group">
							<div class="col-md-12">
								<label for="oldPassword" >현재 비밀번호</label>
								<input type="text" name="oldPassword" id="oldPassword" class="form-control" placeholder="현재 비밀번호"/>
							</div>
							<div class="col-md-12">
								<label for="newPassword">변경할 비밀번호</label>
								<input type="password" name="newPassword" id="newPassword" class="form-control" placeholder="변경할 비밀번호"/>
							</div>
							<div class="col-md-12">
								<label for="newConfirmPassword">변경할 비밀번호 확인</label>
								<input type="password" name="newConfirmPassword" id="newConfirmPassword" class="form-control" placeholder="변경할 비밀번호 확인"/>
							</div>
							<div class="col-md-12">
								<label for="login_submit">변경</label>
								<input type="submit" name="password_submit" id="password_submit" class="form-control btn btn-info" value="비밀번호 변경">         
							</div>
							<div class="col-md-12">
								<label for="password_reset">취소</label>
								<input type="reset" name="password_reset" id="login_reset" class="form-control btn btn-danger" value="취소">         
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