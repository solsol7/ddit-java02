<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>
<script>
$(function(){
	$('#lprodBtn').on('click',function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/lprodList.do",
			type : "post",
			dataType : "json",
			success : function(res){
				htmlCode = "";
				htmlCode +="<table border='1'>";
				htmlCode +="<tr>";
				htmlCode +="<th>LPROD_ID</th>";
				htmlCode +="<th>LPROD_GU</th>";
				htmlCode +="<th>LPROD_NM</th>";
				htmlCode +="</tr>";
				$.each(res, function(i, v){
					htmlCode +="<tr>";
					htmlCode +="<td>"+v.lprod_id+"</td>";
					htmlCode +="<td>"+v.lprod_gu+"</td>";
					htmlCode +="<td>"+v.lprod_nm+"</td>";
					htmlCode +="</tr>";
				});
				htmlCode += "</table>"
				$('#result').html(htmlCode);
			},
			error : function(xhr){
				alert("상태 : " + xhr.status);
			}
		});//ajax끝
	});
	
	//---------------------------------------------
	$('#lprodBtn2').on('click',function(){
		location.href = "<%=request.getContextPath()%>/lprodList2.do";
	})
});
</script>
</head>
<body>
<!-- 
처리하는 서블릿 URL Mapping ==> "/lprodList.do"
 -->
<form>
	<input type="button" id="lprodBtn" value="Lprod자료 가져오기(Ajax 이용)">
	<input type="button" id="lprodBtn2" value="Lprod자료 가져오기(Ajax를 사용하지 않기)">
</form>
<h3>Lprod 자료 목록</h3>
<div id="result"></div>

</body>
</html>