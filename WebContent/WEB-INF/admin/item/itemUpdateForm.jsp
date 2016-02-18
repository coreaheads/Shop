<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <script type="text/javascript" src="js/jquery.js"></script>
   <SCRIPT >
      function categoryChange() {
    	 
         $.ajax({
            url : 'itemInsertAjax.do',
            dataType : "json",
            data : "idx="+$( "#first" ).val(),
            success : function(data) {
               console.log(data);
               var a = '';

               $.each(data, function(i, item) {
                  console.log(item);
                  a+='<option>'+item.categoryName+'</option>';
               });
               console.log(data.length);
               $('#second').html(a);
            }
         });
      }
   </SCRIPT>
<div class="col-md-12">

   <form action="itemUpdate.do" enctype="multipart/form-data"
      method="post">
      <input type="hidden" name="itemId" value="${item.idx }"> <input
         type="hidden" name="url" value="${item.url}">

      <div class="form-group">
         <label for="exampleInputEmail1">itemName</label> <input type="text"
            name="itemName" class="form-control" value="${item.itemName}">
      </div>

      <div class="form-group">
         <label for="exampleInputEmail1">가격</label> <input type="text"
            name="itemPrice" class="form-control" value="${item.itemPrice}">
         <input type="checkbox" name="itemLevel" value="best"> <input
            type="checkbox" name="itemLevel" value="hot"> <input
            type="checkbox" name="itemLevel" value="sale">
      </div>
      <div class="form-group">
         <label for="exampleInputEmail1">상품 카테고리</label> <select id="first"
            style="width: 70px;" onchange="categoryChange();"><option>선택</option>
            <c:forEach items="${firstList}" var="x">
               <option value="${x.idx }">${x.categoryName }</option>
            </c:forEach></select> <select id="second" style="width: 70px;">

         </select>
      </div>
      <div class="form-group">
         <label for="exampleInputEmail1">파일</label> <input type="file"
            name="imgFile" class="form-control" multiple="multiple">
         ${item.url}
      </div>
      <div class="form-group">
         <textarea name="itemContent" class="form-control"
            style="width: 100%; height: 200px">${item.itemContent}</textarea>
      </div>
      <input type="submit" class="btn btn-success" value="등록"> <a
         href="itemList.do">돌아가기</a>
   </form>
</div>