<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Cookie 연습</h3><hr>

<a href="<%=request.getContextPath()%>/cookieAdd.do">Cookie 정보 저장하기</a><br><br>
<a href="<%=request.getContextPath()%>/cookieRead.do">Cookie 정보 확인하기</a><br><br>
<a href="<%=request.getContextPath()%>/cookieDelete.do">Cookie 정보 삭제하기</a><br><br>
</body>
</html>