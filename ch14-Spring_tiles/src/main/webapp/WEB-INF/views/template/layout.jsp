<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title"/></title>
</head>
<body>
<table style="width:100%;">
	<tr>
		<td height="100" colspan="2"><tiles:insertAttribute name="header"/></td>
	</tr>
	<tr>
		<td height="400" width="15%" valign="top">
			<tiles:insertAttribute name="menu"/>
		</td>
		<td width="85%" align="center">
			<tiles:insertAttribute name="body"/>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<tiles:insertAttribute name="footer"/>
		</td>
	</tr>
</table>
</body>
</html>