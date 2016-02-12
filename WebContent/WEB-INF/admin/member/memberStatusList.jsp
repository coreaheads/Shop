<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common/head.jsp"/>
<script type="text/javascript">
//$( document ).ready(function() {
	function registMemberstatus(){
		var url = "registMemberStatus.do";
		var data = "member_status_name="+$("#regist_member_status_name").val();
		var message = "등록";		
		if($('#regist_member_status_name').val().length>1){
			ajaxProcess(url,data,message);
		}else{
			alert("레벨명 적어줘");
			return false;
		}
	}
	
	function modifyMemberstatus(member_status_no){
		
		var url = "modifyMemberStatus.do";
		var data = "member_status_no="+member_status_no+"&member_status_name="+$("#member_status_name"+member_status_no).val();
		var message = "수정";		
		if($("#member_status_name"+member_status_no).val().length>1){
			ajaxProcess(url,data,message);
		}else{
			alert("레벨명 적어줘");
			return false;
		}		
	}
	
	function deleteMemberstatus(member_status_no){
		
		var url = "deleteMemberStatus.do";
		var data = "member_status_no="+member_status_no;
		var message = "삭제";		
		ajaxProcess(url,data,message);
	}
	
	function ajaxProcess(url,data,message){
		$.ajax({
		    url : url,
		    dataType : "json",
		    type : "post",
		    data : data,
		    success: function(data) {
		        if(data.result == "yes"){
		        	alert(message + " 성공");
		        	location.reload();
		        }else{
		        	alert(message + " 실패");	        	
		        }
		    },
		    error:function(request,status,error){
		    	alert(message + " 실패");		    	
		    	
		    }			 
		});		
	}
//});
</script>
  <h2 class="sub-header">회원 상태 관리</h2>

    <div class="col-lg-12">   
     <hr>                
     <div class="panel panel-info">
      <!-- Table -->
      <table class="table">
          <tr class="warning">
           <th>번호</th>
           <th>상태명</th>    
           <th>회원수</th>    
           <th>수정/삭제</th>             
       	</tr>
		<c:forEach items="${list}" var="list">
			<tr>
				<td>${list.member_status_no}</td>
				<td><input type="text" name="member_status_name${list.member_status_no }" id="member_status_name${list.member_status_no }" value="${list.member_status_name}"></td>
				<td>${list.member_status_count}</td>
				<td>
				<button type="submit" class="btn btn-info" onclick="modifyMemberstatus(${list.member_status_no})">수정</button>
				<c:if test="${list.member_status_count eq 0 }">
					<button type="submit" class="btn btn-danger" onclick="deleteMemberstatus(${list.member_status_no})">삭제</button> 			
				</c:if>
				<c:if test="${list.member_status_count > 0 }">
					<button type="submit" class="btn btn-danger disabled">삭제</button> 			
				</c:if>				
				</td>
			</tr>
		</c:forEach>
</table> 
</div>
<button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">등록</button>
</div>
 <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">회원 status등록</h4>
        </div>
        <div class="modal-body">
         <div class="form-group">
			<label for="regist_member_status_name"></label>
			<input type="text" name="regist_member_status_name" id="regist_member_status_name" class="form-control" placeholder="회원 status명"/>
         </div>         
        </div>
        <div class="modal-footer">	
		  <button type="button" class="btn btn-success" onclick="registMemberstatus();">등록</button>   
          <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        </div>
      </div>
      
    </div>
  </div>
<jsp:include page="../common/footer.jsp"/>