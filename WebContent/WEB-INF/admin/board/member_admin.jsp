<%-- <<<<<<< HEAD
<%@page import="hjh.member.db.MemberDTO"%>
<%@page import="hjh.member.db.MemberDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hjh.board.db.BoardConfigDTO"%>
<%@page import="hjh.board.db.BoardConfigDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="../js/bootstrap.js"></script>
<link type="text/css" rel="stylesheet" href="../css/bootstrap.css"
	charset="euc-kr">
<title>�Ĵ��Ĵ�</title>

 
<body style="padding:30px">
<%
	MemberDAO mDAO = new MemberDAO();
	MemberDTO mDTO = new MemberDTO();
	ArrayList<MemberDTO> list = mDAO.list();
	
	pageContext.setAttribute("list", list);
	
%>
<input type="button" onclick="location.href='./BoardConfigWrite.do'"
				class="btn btn-primary" value="�Խ��� �߰�">
				<br>	<br>
<table class="table">
<tr>
<th>ȸ����ȣ</th>
<th>�̸�</th>
<th>�̸���</th>
<th style="text-align:center">����</th>
<th>������</th>
</tr>
<c:forEach var="list" items="${list }" varStatus="s">

<tr>
<td>${list.idx }</td>
<td>${list.name }</td>
<td>${list.email }</td>
<td align="center">${list.gender }</td>
<td>${list.joindate }</td>

</tr>
</c:forEach>
</table>


		
		


</body>
</html>
=======
<%@page import="hjh.member.db.MemberDTO"%>
<%@page import="hjh.member.db.MemberDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hjh.board.db.BoardConfigDTO"%>
<%@page import="hjh.board.db.BoardConfigDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="../js/bootstrap.js"></script>
<link type="text/css" rel="stylesheet" href="../css/bootstrap.css"
	charset="euc-kr">
<title>�Ĵ��Ĵ�</title>

 
<body style="padding:30px">
<%
	MemberDAO mDAO = new MemberDAO();
	MemberDTO mDTO = new MemberDTO();
	ArrayList<MemberDTO> list = mDAO.list();
	
	pageContext.setAttribute("list", list);
	
%>
<input type="button" onclick="location.href='./BoardConfigWrite.do'"
				class="btn btn-primary" value="�Խ��� �߰�">
				<br>	<br>
<table class="table">
<tr>
<th>ȸ����ȣ</th>
<th>�̸�</th>
<th>�̸���</th>
<th style="text-align:center">����</th>
<th>������</th>
</tr>
<c:forEach var="list" items="${list }" varStatus="s">

<tr>
<td>${list.idx }</td>
<td>${list.name }</td>
<td>${list.email }</td>
<td align="center">${list.gender }</td>
<td>${list.joindate }</td>

</tr>
</c:forEach>
</table>


		
		


</body>
</html>
>>>>>>> branch 'master' of https://github.com/coreaheads/Shop.git
 --%>