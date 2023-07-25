<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
window.onload = function(){
	document.getElementById('getBtn').addEventListener("click", function(){
		location.href = "http://localhost/webTest/servletTest03.do";
	});
}
</script>

</head>
<body>

<h2>Servlet 요청 연습</h2><br><hr><br>

<!-- 
웹의 요청 방식은 보통 GET방식과 POST방식이 있는데

GET방식의 경우에는 <a>태그를 이용한 '링크 방식'과
<form>태그의 method속성을 생략하거나 method속성값을 'get'으로
설정하는 방식 그리고 자바스크립트의 location.href속성을
이용하는 방식 등 다양하다.

POST방식은 <form>태그의 method속성값을 'post'로 설정하는 방식이 있다.
 -->

<h3>GET 방식 요청1 - 링크 방식</h3>
<a href="http://localhost/webTest/servletTest03.do">GET 방식 요청1</a>
<hr>

<h3>GET 방식 요청2 - form태그 방식</h3>
<form action="http://localhost/webTest/servletTest03.do" method="get">
	<input type="submit" value="Get 방식 요청2">
</form>
<hr>

<h3>GET 방식 요청3 - 스크립트의 location.href 방식</h3>
<form>
	<input type="button" value="Get 방식 요청2" id="getBtn">
</form>
<hr>

<h3>POST방식 요청 - form태그 방식</h3>
<form action="http://localhost/webTest/servletTest03.do" method="post">
	<input type="submit" value="POST 방식 요청">
</form>


</body>
</html>