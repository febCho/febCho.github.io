<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.story.dao.StoryDAO" %>
<%@ page import="kr.story.vo.StoryVO" %>
<%@ page import="java.util.List" %>
<%@ page import="kr.util.PagingUtil" %>
<%
	//선택한 페이지 번호
	String pageNum = request.getParameter("pageNum");

	//pageNum이 전송되지 않으면 2페이지로 처리
	if(pageNum==null){
		pageNum = "1";
	}
	
	//한 페이지에 몇 개의 글(행, 레코드)를 보여줄 지 지정
	int rowCount = 10;
	//한 화면에 몇 개의 페이지 수를 보여줄 지 지정
	int pageCount = 10;
	//현재 선택한 페이지(String -> int)
	int currentPage = Integer.parseInt(pageNum);

	StoryDAO dao = StoryDAO.getInstance();
	//총 레코드 수
	int count = dao.getCount();
		
	//페이지 처리
	PagingUtil util = new PagingUtil(currentPage,count,rowCount,pageCount,"list.jsp");
	
	List<StoryVO> list = null;
	if(count > 0){
		list = dao.getList(util.getStartRow(), util.getEndRow());
	}
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 이야기 목록</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="page-main">
	<h1>사원들의 이야기</h1>
	<div class="align-right">
<%
	Integer user_snum = (Integer)session.getAttribute("user_snum");
	if(user_snum!=null){
%>
		<input type="button" value="게시글 작성" onclick="location.href='writeForm.jsp'">
<%		
	}
%>
		<input type="button" value="메인으로" onclick="location.href='main.jsp'">
<%
	if(count==0){
%>
		<div class="result-display">게시글이 존재하지 않습니다.</div>
<%		
	}else{
%>
	<!-- 목록 출력 시작 -->
	<table>
		<tr class="align-center">
			<th>글 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
<%
	for(StoryVO vo : list){
%>
	<tr>
		<td><%=vo.getNum() %></td>
		<td><a href="detail.jsp?num=<%=vo.getNum()%>"><%=vo.getTitle() %></a></td>
		<td><%=vo.getId()%></td>
		<td><%=vo.getReg_date() %></td>
	</tr>	
<%		
	}
%>
	</table>
	<!-- 목록 출력 끝 -->
	<!-- 페이지 표시 시작 -->
	<div class="align-center">
		<%=util.getPage() %>
	</div>
	<!-- 페이지 표시 끝 -->
<%
	}
%>					
	</div>
</div>
</body>
</html>