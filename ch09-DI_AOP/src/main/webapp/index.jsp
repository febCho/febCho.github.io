<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC</title>
</head>    
<body>    
<a href="${pageContext.request.contextPath}/hello.do">HelloController</a><br>
<a href="${pageContext.request.contextPath}/search/internal.do?query=드라공&p=2.2">SearchController-internal.do?query=드라공&p=2.2</a><br>
<a href="${pageContext.request.contextPath}/search/external.do?p=5">SearchController-external.do?p=5</a><br>
<a href="${pageContext.request.contextPath}/article/newArticle.do">NewArticleController</a><br>
<a href="${pageContext.request.contextPath}/order/order.do">OrderController</a><br>
<a href="${pageContext.request.contextPath}/cookie/make.do">CookieController-make.do</a><br>
<a href="${pageContext.request.contextPath}/cookie/view.do">CookieController-view.do</a><br>
<a href="${pageContext.request.contextPath}/header/check.do">HeaderController</a><br>
<a href="${pageContext.request.contextPath}/search/main.do">GameSearchController</a><br>
<a href="${pageContext.request.contextPath}/account/create.do">CreateAccountController</a><br>
<a href="${pageContext.request.contextPath}/login/login.do">LoginController</a><br>
<a href="${pageContext.request.contextPath}/report/submission.do">ReportSubmissionController</a><br>
<a href="${pageContext.request.contextPath}/report/submitReport.do">SubmitReportController</a><br>
<a href="${pageContext.request.contextPath}/file/fileUpload.do">FileController(다중업로드)</a><br>
<a href="${pageContext.request.contextPath}/member/write.do">MemberWriteController</a><br>
<!-- 
400에러만 보면 어떤 문제로 이 에러가 발생했는지 찾기 쉽지 않기 때문에 log4j.xml에 힌트를 얻기 위해 로그 메시지를 남김
<logger name="org.springframework.web.servlet">
   <level value="debug">
</logger>
 -->
<a href="${pageContext.request.contextPath}/math/divide.do?op1=5&op2=0">ArithmeticOperatorController - divide.do?op1=5&op2=0</a><br>
<a href="${pageContext.request.contextPath}/math/add.do">ArithmeticOperatorController - add.do</a><br>

<a href="${pageContext.request.contextPath}/file.do">DownloadController</a><br> 
<a href="${pageContext.request.contextPath}/pageRanksExcel.do">/pageRanksExcel.do(엑셀)</a><br> 
<a href="${pageContext.request.contextPath}/pageReportPDF.do">/pageReportPDF.do(PDF)</a><br> 
<a href="${pageContext.request.contextPath}/pageXmlReport.do">/pageXmlReport.do(XML)</a><br>
<a href="${pageContext.request.contextPath}/pageXmlReport2.do">/pageXmlReport.do(XML - @ResponseBody 사용)</a><br>
<a href="${pageContext.request.contextPath}/pageJsonReport.do">/pageJsonReport.do(JSON)</a><br> 
<a href="${pageContext.request.contextPath}/pageJsonReport2.do">/pageJsonReport2.do(JSON - @ResponseBody 사용)</a><br> 
</body>
</html>