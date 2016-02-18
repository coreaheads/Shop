<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<script type="text/javascript" src="js/jquery.js"></script>
   <SCRIPT language=JavaScript>
   function categoryChange(){
		$.ajax({
			url : 'itemInsertAjax.do',
			dataType : "json",
			data: "",
			success : function(data) {
 console.log(data); 
 var a = '';
 
 $.each(data, function(i, item) {
	 console.log(item);
	 
	});

 
 console.log(data.length); 
				$('#second').html(a); 
			}
		});
   }
   
   </SCRIPT>

 
   
   
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
      <select id="first" style="width:70px;" onchange="categoryChange();" ><option>선택</option>
       <c:forEach items="${firstList}" var="x">
      <option>${x.categoryName }</option>
      </c:forEach></select>
      

      <select id="second" style="width:70px;" >
 
      </select>


</body>
</html>