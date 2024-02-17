package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.dao.BoardDAO;
import kr.board.vo.BoardVO;
import kr.controller.Action;
import kr.util.StringUtil;

public class DetailAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//글 번호 반환
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		BoardDAO dao = BoardDAO.getInstance();
		//조회수 증가
		dao.updateReadcount(board_num);
		
		BoardVO board = dao.getBoard(board_num);
		
		//제목 - HTML을 허용하지 않음
		board.setTitle(StringUtil.useNoHtml(board.getTitle()));
		//내용 - HTML을 허용하지 않으면서 줄바꿈 처리
		board.setContent(StringUtil.useBrNoHtml(board.getContent()));
		
		request.setAttribute("board", board);
		
		return "/WEB-INF/views/board/detail.jsp";
	}

}
