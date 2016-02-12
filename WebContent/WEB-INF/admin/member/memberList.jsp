<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/head.jsp"/>

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

    <div class="col-lg-12">   
     <hr>                
     <div class="panel panel-info">
      <!-- Table -->
      <table class="table">
          <tr class="warning">
           <th>번호</th>
           <th>작성자</th>
           <th>제목</th>
           <th>조회수</th>
           <th>작성일</th> 
           <th>수정/삭제</th>                        
       	</tr>
		<c:forEach begin="1" end="15" varStatus="status">
		       	<tr>
       		<td>${status.count}</td>
       		<td>작성자요</td>
       		<td>제목</td>
       		<td>1</td>
       		<td>2015-01-05</td>
       		<td>
       		<button type="button" class="btn btn-info">수정</button>
       		<button type="button" class="btn btn-danger">삭제</button>
       		</td>
       	</tr>
		</c:forEach>
</table> 
</div>
<button type="button" class="btn btn-success btn-lg">등록</button>
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