<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/head.jsp" />


<h2 class="sub-header">카테고리 관리</h2>
<br>
<br>


<div class="col-md-12">
	<form class="navbar-form navbar-right" action="categorySearch.do"
		role="search">
		<select class="form-control" name="searchColumn" id="sel1">
			<option value="categoryName">제목</option>
		</select>

		<div class="form-group">
			<input type="text" name="searchWord" class="form-control"
				placeholder="Search">
		</div>
		<button type="submit" class="btn btn-default">Search</button>
	</form>
</div>

<div class="col-md-12">
	<hr>
	<div class="panel panel-info">
		<!-- Table -->
		<table class="table">
			<tr class="warning">
				<th>idx</th>
				<th>categoryName</th>
				<th>rootNum</th>
				<th>step</th>
				<th>division</th>
				<th>seq</th>
				<th>isDel</th>
				<th>기능</th>
				<th></th>
			</tr>

			<c:forEach items="${categoryList}" var="dto">
				<tr>
					<td>${dto.idx }</td>

					<td><c:forEach begin="1" end="${dto.step }">
					&nbsp;&nbsp;
					</c:forEach> <c:if test="${dto.step > 0}">
					└
					</c:if> ${dto.categoryName }</td>
					
					<td><a href = "categorySearch.do?searchColumn=rootNum&searchWord=${dto.rootNum }">
					${dto.rootNum }</a></td>
					<td>${dto.step }</td>
					<td>${dto.division }</td>
					<td>${dto.seq }</td>
					<td>${dto.isDel }</td>
					<td><a href="subCategoryInsertForm.do?idx=${dto.idx }">[하위 카테고리 삽입]</a>&nbsp;&nbsp; <a
						href="categoryUpdateForm.do?idx=${dto.idx }">[수정]</a>&nbsp;&nbsp;
						<a href="categoryDelete.do?idx=${dto.idx }">[삭제]</a>&nbsp;&nbsp;
						
						<c:choose>
						<c:when test="${dto.step == 0 }">
						<a href="topCategoryUp.do?rootNum=${dto.rootNum }">[▲위로]</a>&nbsp;
						<a href="topCategoryDown.do?rootNum=${dto.rootNum }">[▼아래로]</a>						
						</c:when>
						
						</c:choose>
						
						</td>

				</tr>

			</c:forEach>
		</table>

		<br> <br>
		<form action="topCategoryInsert.do" method="post">
			[최상위 카테고리 추가]<br> <br> categoryName : <input type="text"
				name="categoryName"> <br> division : <input type="text"
				name="division"><br> <br> <input type="submit"
				value="추가">&nbsp;&nbsp;<input type="reset" value="초기화">

		</form>



	</div>

</div>

<jsp:include page="../common/footer.jsp" />