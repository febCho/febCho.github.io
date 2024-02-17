<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<script type="text/javascript">
window.onload = function(){
	let myForm = document.getElementById('search_form');
	//이벤트 연결
	myForm.onsubmit = function(){
		let keyword = document.getElementById('keyword');
		if(keyword.value.trim()==''){
			alert('검색어를 입력하세요');
			keyword.value = '';
			keyword.focus();
			return false;
		}
	};
};
</script>
</head>
<body>
<div class="page-main">
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<div class="content-main">
		<h2>상품 목록</h2>
		<form action="itemList.do" method="get" id="search_form">
			<ul class="search">
				<li>
					<select name="keyfield" id="keyfield">
						<option value="1" <c:if test="${param.keyfield == 1}">selected</c:if>>상품명</option>
						<option value="2" <c:if test="${param.keyfield == 2}">selected</c:if>>내용</option>
					</select>
				</li>
				<li>
					<input type="search" size="16" name="keyword" id="keyword" value="${param.keyword}">
				</li>
				<li>
					<input type="submit" value="찾기">
				</li>
			</ul>
		</form>
		<div class="list-space align-right">
			<input type="button" value="목록"
				onclick="location.href='itemList.do'">
			<input type="button" value="홈으로"
				onclick="location.href='${pageContext.request.contextPath}/main/main.do'">	
		</div>
		<c:if test="${count == 0}">
		<div class="result-display">
			표시할 상품이 없습니다.
		</div>
		</c:if>
		<c:if test="${count > 0}">
		<div class="item-space">
			<c:forEach var="item" items="${list}">
			<div class="horizontal-area">
				<a href="detail.do?item_num=${item.item_num}">
					<img src="${pageContext.request.contextPath}/upload/${item.photo1}">
					<span>
						${item.name}<br>
						<b><fmt:formatNumber value="${item.price}"/>원</b>
					</span>
				</a>
			</div>	
			</c:forEach>
			<div class="float-clear align-center">${page}</div>
		</div>
		</c:if>
	</div>
</div>
</body>
</html>