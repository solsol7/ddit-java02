<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>이미지 보기</h3>
<img src="../images/코알라.jpg" width="150"><br><br>
<img src="<%=request.getContextPath()%>/images/코알라.jpg" width="150"><br><br>

<img src="<%=request.getContextPath()%>/images/imageView.do?fileno=1" width="150"><br><br>
<img src="<%=request.getContextPath()%>/images/imageView.do?fileno=2" width="150"><br><br>
</body>
</html>