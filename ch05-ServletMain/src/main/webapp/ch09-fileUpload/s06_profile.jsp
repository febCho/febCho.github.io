<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.oreilly.servlet.MultipartRequest" %>
<%@ page import = "com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 사진 업로드 처리</title>
</head>
<body>
<%
String saveFolder = "/upload";//파일 업로드 경로
String encType = "utf-8";//인코딩 타입
int maxSize = 5*1024*1024;//최대 업로드 사이즈 5MB
//upload 절대 경로
String realFolder = application.getRealPath(saveFolder);

MultipartRequest multi = new MultipartRequest(request,realFolder,maxSize,
		                              encType, new DefaultFileRenamePolicy());
                                      //file <input> 태그의 파라미터명 = file
	String file = multi.getFilesystemName("file");
%>
<img src="/ch05-ServletMain/upload/<%=file %>" width="500">
</body>
</html>