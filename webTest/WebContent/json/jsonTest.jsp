<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>
<script>
$(function(){		// 현재 페이지를 웹브라우저가 읽어서 DOM객체로 구성한 후 실행되는 영역
	
	//문자열 처리
	$("#strBtn").on('click',function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/jsonController.do",
			type : "post",
			data : "choice=str",	//서버로 보낼 데이타		,	choice: 파라미터, str:값
			
			//----------------------------서버로 요청할 때 필요한 정보
			
			success : function(data){	//응답이 정상적으로 왔을 때, data변수==>응답으로 온 데이터 자동으로 저장된다.
				$("#result").html(data);
			},
			error : function(xhr){
				alert("오류...")
			},
			dataType : "json"	//응답으로 온 데이터 타입(success했을 때 data라는 변수에 저장된 데이터를 json으로 받겠다.)
			
			//--------------------------------응답으로 올 때 필요한 정보
		});
	});
	
	//배열 처리
	$("#arrayBtn").on('click',function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/jsonController.do",
			type : "post",
			data : "choice=array",
	
			success : function(data){
				let htmlCode = "";
				$.each(data, function(i, v){	//i=>index , v=>index번째의 데이터
					htmlCode += i + "번째 값 : " + v + "<br>";
				});
				
				$("#result").html(htmlCode);
				
			},
			error : function(xhr){
				alert("오류...")
			},
			dataType : "json"	
		});
	});
	
	$('#objBtn').on('click',function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/jsonController.do",
			type : "post",
			data : "choice=object",
	
			success : function(data){
				// data ==> {"num":10,"name":"홍길동"}
				let htmlCode = "번호 : " + data.num + "<br>";
				htmlCode += "이름 : " + data.name + "<br>";
				
				$('#result').html(htmlCode);
			},
			error : function(xhr){
				alert("오류...")
			},
			dataType : "json"	
		});
	})
	
	$("#listBtn").on('click',function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/jsonController.do",
			type : "post",
			data : "choice=list",
	
			success : function(data){
				//data => [{"num":100,"name":"강감찬"},{"num":200,"name":"이순신"},
				//			{"num":300,"name":"성춘향"},{"num":400,"name":"이몽룡"}]
				// 배열 안에 객체가 들어간 형태
				let htmlCode = "";
				$.each(data, function(i,v){
					htmlCode += i +"번째 자료<br>";
					htmlCode += "번호 : " + v.num + "<br>";
					htmlCode += "이름 : " + v.name + "<hr>";
				});
				$('#result').html(htmlCode);
			},
			error : function(xhr){
				alert("오류...")
			},
			dataType : "json"	
		});
	})
	
	$("#mapBtn").on('click',function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/jsonController.do",
			type : "post",
			data : "choice=map",
	
			success : function(data){
				//data ==> {"name":"이순신","tel":"010-1234-5678","addr":"대전시 중구 오류동"}
				let htmlCode = "이름 : " + data.name + "<br>";
				htmlCode += "전화번호 : " + data.tel + "<br>";
				htmlCode += "주소 : " + data.addr + "<br>";
				
				$('#result').html(htmlCode);
			},
			error : function(xhr){
				alert("오류...")
			},
			dataType : "json"	
		});
	})
});

</script>

</head>
<body>

<form>
	<input type="button" id="strBtn" value="문자열">
	<input type="button" id="arrayBtn" value="배 열">
	<input type="button" id="objBtn" value="객 체">
	<input type="button" id="listBtn" value="리스트">
	<input type="button" id="mapBtn" value="Map객체">
</form>
<h3>응답 결과</h3>
<div id="result"></div>

</body>
</html>