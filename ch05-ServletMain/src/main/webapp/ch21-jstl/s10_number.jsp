<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>formatNumber 태그</title>
</head>
<body>
숫자 : <fmt:formatNumber type="number" value="10000"/>
<br>
통화 : <fmt:formatNumber type="currency" value="10000" 
									currencySymbol="$"/>
<br>									
통화 : <fmt:formatNumber type="currency" value="10000" 
									currencySymbol="\\"/>
<br>
퍼센트 : <fmt:formatNumber type="percent" value="0.3"/>
<br>
패턴 : <fmt:formatNumber value="12.345" pattern="00.00"/>																		
</body>
</html>