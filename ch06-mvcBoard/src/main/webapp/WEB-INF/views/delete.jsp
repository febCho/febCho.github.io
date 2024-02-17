<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:if test="${check}">
	<script>
		alert('글 삭제를 완료했습니다.');
		location.href='list.do';
	</script>
</c:if>
<c:if test="${!check}">
	<script>
		alert('비밀번호 불일치');
		history.go(-1);
	</script>
</c:if>