<%@page import="vo.FileInfoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	//서블릿에서 보내온 자료를 받는다.
	List<FileInfoVO> fileList = (List<FileInfoVO>)request.getAttribute("fileList");

%>
<body>
<h3>전체 파일 목록</h3><br><hr>
<a href="<%=request.getContextPath()%>/fileUpload.do">파일 업로드</a>

<table border="1">
<thead>
<tr>
	<th>번호</th><th>작성자</th><th>저장파일명</th><th>원래의 파일명</th>
	<th>파일 크기</th><th>날 짜</th><th>비 고</th>
</tr>
</thead>
<tbody>
<%
	if(fileList==null || fileList.size()==0){
%>
	<tr>
		<td colspan="7">파일 목록이 하나도 없습니다...</td>
	</tr>
<%
	}else{
		for(FileInfoVO fvo : fileList){
%>
	<tr>
		<td><%=fvo.getFile_no() %></td>
		<td><%=fvo.getFile_writer() %></td>
		<td><%=fvo.getSave_file_name() %></td>
		<td><%=fvo.getOrigin_file_name() %></td>
		<td><%=fvo.getFile_size() %></td>
		<td><%=fvo.getFile_date() %></td>
		<td><a href="<%=request.getContextPath()%>/fileDownload.do?fileno=<%=fvo.getFile_no()%>">DownLoad</a></td>
	</tr>
<%
		}
	}
%>		
</tbody>
</body>
</html>