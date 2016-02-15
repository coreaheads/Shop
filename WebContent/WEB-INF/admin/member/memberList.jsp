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
          <form class="navbar-form navbar-right" action="#" role="search">
              <select class="form-control" name="" id="sel1">
                <option value="member_id">작성자</option>
                <option value="free_board_title">제목</option>
            </select>

            <div class="form-group">
                <input type="text" name="" class="form-control" placeholder="Search">
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
<li class='disabled'><a href='#' aria-label='First'><span aria-hidden='true'>&lsaquo;</span></a></li>
<li class='disabled'><a href='#' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>
<c:forEach begin="1" end="10" varStatus="status">
<li></li>
<li><a href='#'>${status.count}</a></li>
</c:forEach>
<li class='disabled'><a href='#' aria-label='Next'><span aria-hidden='true'>&rsaquo;</span></a></li>
<li class='disabled'><a href='#' aria-label='End'><span aria-hidden='true'>&raquo;</span></a></li>
</ul>
</nav>
</div>

<jsp:include page="../common/footer.jsp"/>