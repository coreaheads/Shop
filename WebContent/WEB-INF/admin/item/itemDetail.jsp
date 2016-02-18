<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-md-12">
	${item.idx} &nbsp; ${item.itemName} &nbsp; ${item.itemContent} &nbsp;
	${item.itemPrice}
	<br> ${item.itemLevel }
	<br> ${item.sale}
	<br> ${item.itemCategory}
	<br> ${item.url}
	<br> ${item.isDel}
	<br>
	<a href="itemDelete.do?idx=${item.idx}">del</a>
	<a href="item.do?idx=${item.idx}&mode=update">update</a>
</div>