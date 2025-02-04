<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- 내용 시작 -->
<div class="page-main">
	<h2>게시판 목록</h2>
	<form action="list" id="search_form" method="get">
		<ul class="search">
			<li>
				<select name="keyfield" id="keyfield">
					<option value="1" <c:if test="${param.keyfield == 1}">selected</c:if>>제목
					<option value="2" <c:if test="${param.keyfield == 2}">selected</c:if>>ID+별명
					<option value="3" <c:if test="${param.keyfield == 3}">selected</c:if>>내용
					<option value="4" <c:if test="${param.keyfield == 4}">selected</c:if>>제목+내용
				</select>
			</li>
			<li>
				<input type="search" name="keyword" id="keyword" value="${param.keyword}">
			</li>
			<li>
				<input type="submit" value="찾기">
				<input type="button" value="목록" onclick="location.href='list'">
			</li>
		</ul>
		<div class="align-right">
			<select id="order" name="order">
				<option value="1" <c:if test="${param.order == 1}">selected</c:if>>최신순
				<option value="2" <c:if test="${param.order == 2}">selected</c:if>>조회수
				<option value="3" <c:if test="${param.order == 3}">selected</c:if>>좋아요
				<option value="4" <c:if test="${param.order == 4}">selected</c:if>>댓글수
			</select>
			<c:if test="${!empty user}">
			<input type="button" value="글쓰기" onclick="location.href='write'">
			</c:if>
		</div>
	</form>
	<c:if test="${count == 0}">
	<div class="result-display">표시할 게시물이 없습니다.</div>
	</c:if>
	<c:if test="${count > 0}">
	<table class="striped-table">
		<tr>
			<th>번호</th>
			<th width="400">제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>좋아요수</th>
		</tr>
		<c:forEach var="board" items="${list}">
		<tr>
			<td class="align-center">${board.board_num}</td>
			<td>
				<a href="detail?board_num=${board.board_num}">${board.title} (${board.re_cnt})</a>
			</td>
			<td class="align-center">
				<c:if test="${empty board.nick_name}">${board.id}</c:if>
				<c:if test="${!empty board.nick_name}">${board.nick_name}</c:if>
			</td>
			<td class="align-center">${board.reg_date}</td>
			<td class="align-center">${board.hit}</td>
			<td class="align-center">${board.fav_cnt}</td>
		</tr>	
		</c:forEach>
	</table>
	<div class="align-center">${page}</div>	
	</c:if>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	//검색 유효성 체크
	$('#search_form').submit(function(){
		if($('#keyword').val().trim()==''){
			alert('검색어를 입력하세요!');
			$('#keyword').val('').focus();
			return false;
		}
	});//end of submit
	
	//정렬 선택
	$('#order').change(function(){
		location.href='list?keyfield='+$('#keyfield').val()+'&keyword='+$('#keyword').val()+'&order='+$('#order').val();
	});
});
</script>
<!-- 내용 끝 -->