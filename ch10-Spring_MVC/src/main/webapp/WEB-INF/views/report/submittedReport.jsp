<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리포트 등록 완료</title>
</head>
<body>
리포트 <b>${report.subject}</b>를 등록했습니다.<br>
업로드한 파일 : ${report.reportFile.originalFilename}<br>
용량 : ${report.reportFile.size}
</body>
</html>