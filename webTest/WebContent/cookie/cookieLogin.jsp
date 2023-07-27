<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie[] cookieArr = request.getCookies();
	String cookieId="";
	if(cookieArr !=null){
		for(Cookie cookie : cookieArr){
			if("id".equals(cookie.getName())){
				cookieId=cookie.getValue();
			}
		}
	}else{
		cookieId="1234";
	}
%>
<form action="<%=request.getContextPath()%>/cookieLoginServlet.do" method="get">
<label>ID</label>
<input type="text" name="id" value=<%=cookieId %>><br>

<label>PASS</label>
<input type="password" name="pass"><br>

<input type="checkbox" name="check" value="check">id 기억하기<br>
<input type="submit" value="login">
</form>

</body>
</html>