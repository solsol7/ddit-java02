<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
<%
	//JSP문서에서의 세션은 'session'이라는 이름으로 저장되어 있다.
	session = request.getSession();
	String userId = "";
	if(session.getAttribute("USERID")!=null)
		userId = (String)session.getAttribute("USERID");
	
if(userId.equals("admin")){ %>

<br>
<table style="margin:0 auto;">
	<tr>
		<td><h3><%=userId%>님 반갑습니다.</h3></td>
	</tr>
	<tr>
		<td><a href="<%=request.getContextPath()%>/sessionLogout.do">로그아웃</a></td>
	</tr>
</table>

<%}else{ %>

<form action="<%=request.getContextPath()%>/sessionLogin.do" method="post">
<table border="1" style="margin:0 auto;">
	<tr>
		<td>ID : </td>
		<td><input type="text" name="userid" value=<%=userId%>></td>
	</tr>
	<tr>
		<td>PASS : </td>
		<td><input type="password" name="userpass"></td>
	</tr>
	<tr>
		<td colspan="2" style="text-align:center;">
		<input type="submit" value="Login" name="userpass">
		</td>
	</tr>
</table>
</form>

<%} %>

</body>
</html>