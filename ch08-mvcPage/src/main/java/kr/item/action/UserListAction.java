package kr.item.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.item.dao.ItemDAO;
import kr.item.vo.ItemVO;
import kr.util.PageUtil;

public class UserListAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) pageNum = "1";
		
		String keyfield = request.getParameter("keyfield");
		String keyword = request.getParameter("keyword");
		
		ItemDAO dao = ItemDAO.getInstance();
		// status > ?이므로 표시 상품만 읽어옴
		int count = dao.getItemCount(keyfield, keyword, 1);
		
		//페이지 처리
		PageUtil page = new PageUtil(keyfield,keyword,Integer.parseInt(pageNum),count,25,10,"itemList.do");
		
		List<ItemVO> list = null;
		if(count > 0) {
			list = dao.getListItem(page.getStartRow(), page.getEndRow(), keyfield, keyword, 1);
		}
		
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("page", page.getPage());
		
		return "/WEB-INF/views/item/user_list.jsp";
	}

}
