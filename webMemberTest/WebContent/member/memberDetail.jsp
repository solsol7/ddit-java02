<%@page import="member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>
<!-- <script src="https://code.jquery.com/jquery-3.4.1.js"></script> -->
<%
	MemberVO vo = (MemberVO)request.getAttribute("getMember");
%>
<script>
$(function(){
	$('#update').on('click',function(){
		location.href="<%=request.getContextPath()%>/updateMember.do?id=<%=vo.getMem_id()%>";
	});
	
	$('#delete').on('click',function(){
		location.href="<%=request.getContextPath()%>/deleteMember.do?id=<%=vo.getMem_id()%>"
	});
	
	$('#list').on('click',function(){
		location.href="<%=request.getContextPath()%>/memberList.do";
	});
});
</script>
</head>
<body>

<table border="1">
	<tr>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td>회원ID</td>
		<td><%=vo.getMem_id()%></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><%=vo.getMem_pass()%></td>
	</tr>
	<tr>
		<td>회원이름</td>
		<td><%=vo.getMem_name()%></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><%=vo.getMem_tel()%></td>
	</tr>
	<tr>
		<td>회원주소</td>
		<td><%=vo.getMem_addr()%></td>
	</tr>
	<tr colspan="2">
		<td>
			<input type="button" id="update" value="수정">
			<input type="button" id="delete" value="삭제">
			<input type="button" id="list" value="회원목록">
		</td>
	</tr>
	
</table>

</body>
</html>