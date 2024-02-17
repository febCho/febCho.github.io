<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.board.dao.BoardDAO" %>
<%@ page import="kr.board.vo.BoardVO" %>
<%
	//전송된 데이터 인코딩 처리
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="boardVO" class="kr.board.vo.BoardVO"/>
<jsp:setProperty property="*" name="boardVO" />
<%
	BoardDAO dao = BoardDAO.getInstance();
	
	//비밀번호 인증하기
	//getBoard()를 통해 num에 해당하는 레코드를 갖고 있는 자바빈
									//전송된 데이터가 프로퍼티에 맵핑된 자바빈
	BoardVO db_board = dao.getBoard(boardVO.getNum());
	boolean check = false;
	if(db_board!=null){
		//비밀번호 일치 여부 체크
		check = db_board.isCheckedPassword(boardVO.getPasswd());
	}
	if(check){//인증 성공
		boardVO.setIp(request.getRemoteAddr());
		dao.update(boardVO);
%>
	<script type="text/javascript">
		alert('글 수정을 완료했습니다.');
		location.href='detail.jsp?num=<%= boardVO.getNum()%>';
	</script>
<%		
	}else{//인증 실패
%>
	<script type="text/javascript">
		alert('비밀번호 불일치');
		history.go(-1);
	</script>
<%		
	}
%>  
