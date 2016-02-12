<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<script type="text/javascript" src="js/jquery.js"></script>
   <SCRIPT language=JavaScript>
   
   /* var f_S = new Array('한식', '중식', '일식' , '외국식');

   var elbox = new Array();
   elbox[0] = new Array('김치찌게', '된장찌게', '불고기', '설렁탕', '뼈해장국');
   elbox[1] = new Array('탕수육', '팔보채', '깐풍기');
   elbox[2] = new Array('초밥', '덮밥', '문어구이');
   elbox[3] = new Array('스테이크', '캐비어', '푸아그라', '파스타');

   function init(f){
      var f_sel = f.first;
      var el = f.second;

      f_sel.options[0] = new Option("선택", "");
      el.options[0] = new Option("선택", "");

      for(var i =0; i<f_S.length; i++){
         f_sel.options[i+1] = new Option(f_S[i], f_S[i]);
      }
   }

   function itemChange(f){
      var f_sel = f.first;
      var el = f.second;

      var sel = f_sel.selectedIndex;
      for(var i=el.length; i>=0; i--){
         el.options[i] = null;
      }

      el.options[0] = new Option("선택", "");

      if(sel != 0){
         for(var i=0; i<elbox[sel-1].length; i++){
            el.options[i+1] = new Option(elbox[sel-1][i], elbox[sel-1][i]);
         }
      }
   } */

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
/*  for (var i = 0; i < data.length; i++) {
     a += '<option value="' + data[i].user_pw + '">' + data[i].user_id + '</option>';
   } */
 
 console.log(data.length); 
				$('#second').html(a); 
			}
		});
   }
   
   </SCRIPT>

 
   
   
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<!-- <body onload = "init(this.form);">   
   <form name="form">
      <select id="first" style="width:70px;" onchange="itemChange(this.form);" ></select>
      <select id="second" style="width:70px;" ></select>
   </form>
</body> -->
<body>
      <select id="first" style="width:70px;" onchange="categoryChange();" ><option>aa</option><option>bb</option></select>
      <select id="second" style="width:70px;" ></select>


</body>
</html>