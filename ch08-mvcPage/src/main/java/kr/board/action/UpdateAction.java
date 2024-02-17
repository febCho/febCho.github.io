package kr.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import kr.board.dao.BoardDAO;
import kr.board.vo.BoardVO;
import kr.controller.Action;
import kr.util.FileUtil;

public class UpdateAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Integer user_num = (Integer)session.getAttribute("user_num");
		if(user_num==null) {//로그인이 되지 않은 경우
			return "redirect:/member/loginForm.do";
		}
		
		MultipartRequest multi = FileUtil.createFile(request);
		int board_num = Integer.parseInt(multi.getParameter("board_num"));
		String filename = multi.getFilesystemName("filename");
		
		BoardDAO dao = BoardDAO.getInstance();
		//수정 전 데이터 반환
		BoardVO db_board = dao.getBoard(board_num);
		if(user_num!=db_board.getMem_num()) {
			//로그인한 회원번호와 작성자 회원번호가 불일치
			FileUtil.removeFile(request, filename);
			return "/WEB-INF/views/common/notice.jsp";
		}
		
		//로그인한 회원번호와 작성자 회원번호가 일치
		BoardVO board = new BoardVO();
		board.setBoard_num(board_num);
		board.setTitle(multi.getParameter("title"));
		board.setContent(multi.getParameter("content"));
		board.setIp(request.getRemoteAddr());
		board.setFilename(filename);
		
		//글 수정
		dao.updateBoard(board);
		
		if(filename!=null) {//새 파일로 교체할 때 원래 파일 제거
			FileUtil.removeFile(request, db_board.getFilename());
		}
		
		return "redirect:/board/detail.do?board_num=" + board_num;
	}

}
