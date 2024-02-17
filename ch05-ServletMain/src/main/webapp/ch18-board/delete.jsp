<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.board.dao.BoardDAO" %>
<%@ page import="kr.board.vo.BoardVO" %>
<%
	//전송된 데이터 인코딩 처리
	request.setCharacterEncoding("utf-8");

	//전송된 데이터 반환
	int num = Integer.parseInt(request.getParameter("num"));
	String passwd = request.getParameter("passwd");
	
	BoardDAO dao = BoardDAO.getInstance();
	//비밀번호 인증하기
	BoardVO db_board = dao.getBoard(num);
	boolean check = false;
	if(db_board!=null){
		//비밀번호 일치 여부 체크
		check = db_board.isCheckedPassword(passwd);
	}
	if(check){//인증 성공
		dao.delete(num);
%>
	<script>
		alert('글 삭제를 완료했습니다.');
		location.replace('list.jsp');
	</script>
<%	
	}else{//인증 실패
%>
	<script>
		alert('비밀번호 불일치');
		history.go(-1);
	</script>
<%
	}
%>	