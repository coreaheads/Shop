<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../common/head.jsp"/>
<script type="text/javascript">
	function registForm(){
		location.href="memberRegistForm.do";
	}
	
	function modifyMember(member_no){
		location.href="memberModifyForm.do?member_no="+member_no;
	}
	
	function deleteMember(member_no){
		location.href="memberDelete.do?member_no="+member_no;
	}
</script>
  <h2 class="sub-header">회원관리</h2>

       <div class="col-md-12">
          <form class="navbar-form navbar-right" action="memberList.do" role="search" method="post">
              <select class="form-control" name="search_sel" id="sel1">
                <option value="member_id">아이디</option>
                <option value="member_name">이름</option>
            </select>

            <div class="form-group">
                <input type="text" name="search_txt" class="form-control" placeholder="Search">
            </div>
           <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
        </form>   
    </div>   

    <div class="col-md-12">   
     <hr>                
     <div class="panel panel-info">
      <!-- Table -->
      <table class="table">
          <tr class="warning">
           <th>번호</th>
           <th>아이디</th>
           <th>이름</th>
           <th>우편번호</th>
           <th>주소</th>
           <th>연락처</th>
           <th>레벨명</th>
           <th>회원상태</th>
           <th>가입일</th>
           <th>수정/삭제</th>                        
       	</tr>
		<c:forEach items="${memberList}" var="memberList">
		<fmt:formatDate value="${memberList.member_regist_date}" pattern="yyyy-MM-dd" var="member_regist_date"/>
		    <tr>
       		<td>${memberList.member_no}</td>
       		<td>${memberList.member_id}</td>
       		<td>${memberList.member_name}</td>
       		<td>${memberList.member_post}</td>
       		<td>${memberList.member_addr}</td>
       		<td>${memberList.member_number}</td>       		
       		<td>${memberList.memberLevel.member_level_name}</td>
       		<td>${memberList.memberStatus.member_status_name}</td>
       		<td>${member_regist_date}</td>
       		<td>
       		<button type="button" class="btn btn-info" onclick="modifyMember(${memberList.member_no})">수정</button>
       		<c:if test="${memberList.memberStatus.member_status_name != '탈퇴회원'}">
       		<button type="button" class="btn btn-danger" onclick="deleteMember(${memberList.member_no})">삭제</button>       		
       		</c:if>
       		</td>
       	</tr>
		</c:forEach>
</table> 
</div>
<button type="button" class="btn btn-success btn-lg" onclick="registForm();">등록</button>
	<nav class='paging-number text-center'>
		<ul class='pagination'>
			
			<li class='<c:if test="${paramvo.page eq 1 }">disabled</c:if>'><a href="memberList.do?page=1" aria-label='Previous'><span
					aria-hidden='true'>&laquo;</span></a></li>
					<li class='<c:if test="${paramvo.page eq 1 }">disabled</c:if>'><a href="<c:if test="${paramvo.page ne 1 }">memberList.do?page=${paramvo.page-1 }</c:if>" aria-label='First'><span
					aria-hidden='true'>&lsaquo;</span></a></li>
			<c:forEach begin="${paramvo.startpage  }" end="${paramvo.endpage }" step="1"	var="x" varStatus="a">
				<li></li>
				<li class='<c:if test="${paramvo.page eq a.index }">active</c:if>'><a href="BoardList.do?page=${a.index }">${a.index}</a></li>
			</c:forEach>
			<li class='<c:if test="${paramvo.page eq paramvo.endpage }">disabled</c:if>'>
			<a href="<c:if test="${paramvo.page ne paramvo.endpage }">BoardList.do?page=${paramvo.page+1 }</c:if>" aria-label='Next'><span
					aria-hidden='true'>&rsaquo;</span></a></li>
			<li class='<c:if test="${paramvo.page eq paramvo.endpage }">disabled</c:if>'>
			<a href="<c:if test="${paramvo.page ne paramvo.endpage }">BoardList.do?page=${paramvo.endpage }</c:if>" aria-label='End'><span
					aria-hidden='true'>&raquo;</span></a></li>
		</ul>
	</nav>
</div>

<jsp:include page="../common/footer.jsp"/>