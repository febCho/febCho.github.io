<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.board.dao.BoardDAO" %>
<%@ page import="kr.board.vo.BoardVO" %>
<%
	//list.jsp로부터 get 방식으로 전달 받은 데이터 반환 -> getBoard() 메서드 인자
	int num = Integer.parseInt(request.getParameter("num"));
	BoardDAO dao = BoardDAO.getInstance();
	BoardVO boardVO = dao.getBoard(num);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 상세</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="page-main">
	<ul>
		<li>글 번호 : <%=boardVO.getNum() %></li>
		<li>제목 : <%=boardVO.getTitle() %></li>
		<li>작성자 : <%=boardVO.getName() %></li>
	</ul>
	<hr size="1" noshade="noshade" width="100%">
	<p>
		<%=boardVO.getContent() %>
	</p>
	<div class="align-right">
		작성일 : <%=boardVO.getReg_date() %>
		<input type="button" value="수정"
			onclick="location.href='updateForm.jsp?num=<%=boardVO.getNum()%>'">
		<input type="button" value="삭제"
			onclick="location.href='deleteForm.jsp?num=<%=boardVO.getNum()%>'">
		<input type="button" value="목록"
			onclick="location.href='list.jsp'">	
		
	</div>
</div>
</body>
</html>