package kr.news.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.news.dao.NewsDAO;
import kr.news.vo.NewsVO;
import kr.util.FileUtil;

public class DeleteAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		//전송된 데이터 반환
		int num = Integer.parseInt(request.getParameter("num"));
		String passwd = request.getParameter("passwd");
		
		NewsDAO dao = NewsDAO.getinstance();
		NewsVO db_news = dao.getNews(num);
		boolean check = false;
		if(db_news!=null) {
			check = db_news.isCheckedPassword(passwd);
		}
		if(check) {
			//인증에 성공했다면, 삭제 작업 진행 + db에 저장된 파일도 제거
			dao.deleteNews(num);
			FileUtil.removeFile(request, db_news.getFilename());
		}
		request.setAttribute("check", check);
		
		//JSP 경로 반환
		return "/WEB-INF/views/delete.jsp";
	}

}