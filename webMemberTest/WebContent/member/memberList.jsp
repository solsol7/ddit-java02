<%@page import="java.util.List"%>
<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
$(function(){
	$('#insert').on('click',function(){
		location.href = "<%=request.getContextPath()%>/insertMember.do";
	});
});
</script>
<%
 	List<MemberVO> memList = (List<MemberVO>)request.getAttribute("getAllMember");
%>
</head>
<body>
<h3>회원 목록 보기</h3><br>

<table border="1">
	<tr colspan="5">
		<td><input type="button" id="insert" value="회원추가"></td>
	</tr>
	<tr>
		<td>ID</td><td>비밀번호</td><td>이름</td><td>전화</td><td>주소</td>
	</tr>
	<%
	if(memList!=null){
		for(MemberVO mvo : memList){
	%>
	
	<tr>
		<td><a href="<%=request.getContextPath()%>/memberDetail.do?id=<%=mvo.getMem_id()%>"><%=mvo.getMem_id()%></a></td>
		<td><%=mvo.getMem_pass()%></td>
		<td><%=mvo.getMem_name()%></td>
		<td><%=mvo.getMem_tel()%></td>
		<td><%=mvo.getMem_addr()%></td>
	</tr>
	
	<%
		}
	}
	%>

</table>

</body>
</html>