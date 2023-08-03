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
	$('#save').on('click',function(){
		location.href="<%=request.getContextPath()%>/insertMember.do";
	});
	$('#list').on('click',function(){
		location.href="<%=request.getContextPath()%>/memberList.do";
	});
	
	$('#checkId').on('click',function(){
		memId = $('#memId').val();
		$.ajax({
			url : "<%=request.getContextPath()%>/memberDetail.do",
			data : "id="+memId,
			type : 'post',
			success : function(res){
				id = $('#memId').val();
				if(id.length<1){
					//왜 id==null 하면 안됨?/////////////////////////////////////////////////////
					alert("아이디를 입력하세요");
					return;
				}
				if(res!=null){
					code = "사용 불가능한 아이디"
					$('#result').html(code).css('color','red');
				}else{
					code = "사용 가능한 아이디"
					$('#result').html(code).css('color','red');
				}
			},
			error : function(xhr){
				alert("상태 : " + xhr.status);
			},
			dataType : 'json'
			
		});//ajax끝
	});//checkId click 끝
	
});
</script>
</head>
<body>
<form action="<%=request.getContextPath()%>/insertMember.do" method="post">
<table border="1">
	<tr>
		<td>회원ID</td>
		<td>
			<input type="text" id="memId" name="memId">
			<div id="result"></div>
			<input type="button" id="checkId" value="중복확인">
		</td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td>
			<input type="password" id="memPass1" name="memPass1">
		</td>
	</tr>
	<tr>
		<td>비밀번호 확인</td>
		<td>
			<input type="password" id="memPass2" name="memPass2">
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
</body>
</html>