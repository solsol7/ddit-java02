<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%
	MemberVO vo = (MemberVO)request.getAttribute("getMember");
// 	request.setAttribute("id", vo.getMem_id());
%>
<script src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>
<script>
$('#list').on('click',function(){
	location.href="<%=request.getContextPath()%>/memberList.do";
});
</script>
</head>
<body>
<form action="<%=request.getContextPath()%>/updateMember.do" method="post">
<table border="1">
	<tr>
		<td>회원ID</td>
		<td>
			<input type="text" id="memId" name="memId"
				value="<%=vo.getMem_id()%>" readonly="readonly">
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>
			<input type="password" id="memPass1" name="memPass1">
		</td>
	</tr>

	<tr>
		<td>회원이름</td>
		<td>
			<input type="text" id="memName" name="memName">
		</td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td>
			<input type="text" id="memTel" name="memTel">
		</td>
	</tr>
	<tr>
		<td>회원주소</td>
		<td>
			<input type="text" id="memAddr" name="memAddr">
		</td>
	</tr>
		<tr>
		<td>프로필사진</td>
		<td></td>
	</tr>
		<tr colspan="2">
		<td>
			
				<input type="submit" id="save" value="저장">

			<input type="reset" value="취소">
			<input type="button" id="list" value="회원목록">
		</td>
	</tr>
</table>
</form>

</table>
</body>
</html>