<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>

</script>
<div class="col-md-12">
	<form action="BoardConfigInsert.do" method="post">
		<div class="form-group">
			<label>테이블명</label> <input type="text" name="board_name"
				class="form-control" value="">
		</div>
		<div class="form-group">
			<label>테이블 코드</label><br>
			<c:forEach var="x" items="${list }" varStatus="s">
		${x.board_name }:  <span style="font-weight: bold">${x.board_code }</span>&nbsp;&nbsp;&nbsp;&nbsp;
		</c:forEach>
			<input type="text" name="board_code" class="form-control" value="">

		</div>
		<div class="form-group">
			<label>파일업로드</label> <input type="radio" name="is_file" value="Y"
				checked="checked"> Y <input type="radio" name="is_file"
				value="N"> N
		</div>
		<div class="form-group">
			<label>파일갯수</label> <select name="file_cnt">
				<c:forEach var="x" begin="1" end="10" varStatus="s">
					<option value="${s.index }">${s.index}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label>읽기전용</label> <input type="radio" name="is_readonly" value="Y"
				checked="checked"> Y <input type="radio" name="is_readonly"
				value="N"> N
		</div>
		<div class="form-group">
			<label>카운트보기</label> <input type="radio" name="is_viewcnt" value="Y"
				checked="checked"> Y <input type="radio" name="is_viewcnt"
				value="N"> N
		</div>
		<div class="form-group">
			<label>비밀글</label> <input type="radio" name="is_lock" value="Y"
				checked="checked"> Y <input type="radio" name="is_lock"
				value="N"> N
		</div>
		<!-- <div class="form-group">
			<label>공지사용</label> <input type="radio" name="is_notice" value="Y"
				checked="checked"> Y <input type="radio" name="is_notice"
				value="N"> N
		</div> -->

		<input type="submit" class="btn btn-success" value="등록">

	</form>
</div>