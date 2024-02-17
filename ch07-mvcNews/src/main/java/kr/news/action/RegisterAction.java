package kr.news.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.controller.Action;
import kr.news.dao.NewsDAO;
import kr.news.vo.NewsVO;
import kr.util.FileUtil;

public class RegisterAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MultipartRequest multi = FileUtil.createFile(request);
		NewsVO vo = new NewsVO();
		vo.setTitle(multi.getParameter("title"));
		vo.setWriter(multi.getParameter("writer"));
		vo.setPasswd(multi.getParameter("passwd"));
		vo.setEmail(multi.getParameter("email"));
		vo.setArticle(multi.getParameter("article"));
		vo.setFilename(multi.getFilesystemName("filename"));
		
		NewsDAO dao = NewsDAO.getinstance();
		dao.registerNews(vo);
		
		return "/WEB-INF/views/register.jsp";
	}

}