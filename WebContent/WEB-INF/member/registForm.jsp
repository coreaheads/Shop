<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/head.jsp"/>	
<section id="form"><!--form-->
	<div class="container">

		<!-- Content Row -->
		<div class="row row-centered">

			<!-- Content Column -->
			<div class="col-md-12 col-centered">
				<form:form commandName="member" id="registMember" role="form" action="registOk.do" method="post" >		  	
				<c:set var="MemberIdErros"><form:errors path="member_id"/></c:set>
				<c:set var="MemberPWErros"><form:errors path="member_pw"/></c:set>
				<c:set var="MemberNameErros"><form:errors path="member_name"/></c:set>
				<c:set var="MemberAddrErros"><form:errors path="member_addr"/></c:set>
				<c:set var="MemberNumberErros"><form:errors path="member_number"/></c:set>
				
				<fieldset>
					<legend>회원가입</legend>
					<div class="form-group">
						<div class="col-md-12">
							<label for="member_id" >아이디(이메일)</label>
							<form:input path="member_id" id="member_id" class="form-control" placeholder="아이디(이메일) ex)test@gmail.com"/>
						</div>
						<div class="col-md-12">
							<label for="member_pw">비밀번호</label>
							<form:password path="member_pw" id="member_pw" class="form-control" placeholder="비밀번호" />
						</div>
						<div class="col-md-12">
							<label for="member_name">이름</label>
							<form:input path="member_name" id="member_name" class="form-control" placeholder="이름" />
						</div>		     
						<div class="col-md-12">
							<label for="member_post">우편번호</label>
							<input type="text" name="member_post" id="member_post" class="form-control"  placeholder="우편번호 ex)133-133" >
						</div>         
						<div class="col-md-12">
							<label for="member_addr">주소</label>
							<form:input path="member_addr" id="member_addr" class="form-control" placeholder="주소" />
						</div> 
						<div class="col-md-12">
							<label for="member_number">연락처</label>
							<form:input path="member_number" id="member_number" class="form-control" placeholder="연락처 ex)0112223333(하이픈(-) 제외)" />
						</div> 		      
						<c:if test="${not empty MemberIdErros}">
						<div class="col-md-12">     
							<label for="sr-only"></label> 
							<div class="alert alert-danger" role="alert">
								<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
								<form:errors path="member_id"/>
							</div>		
						</div> 		      	
					</c:if>
					<c:if test="${not empty MemberPWErros}">
					<div class="col-md-12">     
						<label for="sr-only"></label> 
						<div class="alert alert-danger" role="alert">
							<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
							<form:errors path="member_pw"/>
						</div>		
					</div> 		      	
				</c:if>				
				<c:if test="${not empty MemberNameErros}">
				<div class="col-md-12">     
					<label for="sr-only"></label> 
					<div class="alert alert-danger" role="alert">
						<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
						<form:errors path="member_name"/>
					</div>		
				</div> 		      	
			</c:if>
			<c:if test="${not empty MemberAddrErros}">
			<div class="col-md-12">     
				<label for="sr-only"></label> 
				<div class="alert alert-danger" role="alert">
					<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
					<form:errors path="member_addr"/>
				</div>		
			</div> 		      	
		</c:if>                
		<c:if test="${not empty MemberNumberErros}">
		<div class="col-md-12">     
			<label for="sr-only"></label> 
			<div class="alert alert-danger" role="alert">
				<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
				<form:errors path="member_number"/>
			</div>		
		</div> 		      	
	</c:if>
	<div class="col-md-12">
		<label for="regist_submit"></label>
		<input type="submit" name="regist_submit" id="regist_submit" class="form-control btn btn-info" value="회원가입">         
	</div>
	<div class="col-md-12">
		<label for="regist_reset"></label>
		<input type="reset" name="regist_reset" id="regist_reset" class="form-control btn btn-danger" value="취소">         
	</div>      
</div>
</fieldset>				
</form:form>
</div>
</div>
<!-- /.row -->
</div>
</section><!--/form-->
<jsp:include page="../common/footer.jsp"/>	