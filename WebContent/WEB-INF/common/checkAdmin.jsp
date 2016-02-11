<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${myInfo.member_level_no > 1}">
	<script type="text/javascript">
		alert("관리자만 이용가능합니다.");
		location.href = "index.do";
	</script>
</c:if>