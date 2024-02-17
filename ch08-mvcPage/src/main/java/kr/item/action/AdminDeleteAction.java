package kr.item.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.item.dao.ItemDAO;
import kr.item.vo.ItemVO;
import kr.util.FileUtil;

public class AdminDeleteAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Integer user_num = (Integer)session.getAttribute("user_num");
		if(user_num == null) {//로그인이 되지 않은 경우
			return "redirect:/member/loginForm.do";
		}
		
		Integer user_auth = (Integer)session.getAttribute("user_auth");
		if(user_auth != 9) {//관리자로 로그인하지 않은 경우
			return "/WEB-INF/views/commom/notice.jsp";
		}
		
		//관리자로 로그인한 경우
		int item_num = Integer.parseInt(request.getParameter("item_num"));
		ItemDAO dao = ItemDAO.getInstance();
		ItemVO db_item = dao.getItem(item_num);
		
		//상품 삭제
		dao.deleteItem(item_num);
		
		//이미지 삭제
		FileUtil.removeFile(request, db_item.getPhoto1());
		FileUtil.removeFile(request, db_item.getPhoto2());
		
		request.setAttribute("notice_msg", "정상적으로 삭제했습니다.");
		request.setAttribute("notice_url", request.getContextPath()+"/item/adminList.do");
		
		return "/WEB-INF/views/common/alert_singleView.jsp";
	}

}
