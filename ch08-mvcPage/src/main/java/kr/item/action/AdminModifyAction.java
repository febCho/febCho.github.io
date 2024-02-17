package kr.item.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import kr.controller.Action;
import kr.item.dao.ItemDAO;
import kr.item.vo.ItemVO;
import kr.util.FileUtil;

public class AdminModifyAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Integer user_num = (Integer)session.getAttribute("user_num");
		if(user_num == null) {//로그인이 되지 않은 경우
			return "redirect:/member/loginForm.do";
		}
		
		Integer user_auth = (Integer)session.getAttribute("user_auth");
		if(user_auth != 9) {//관리자로 로그인하지 않은 경우
			return "/WEB-INF/views/common/notice.jsp";
		}
		
		//관리자로 로그인한 경우
		MultipartRequest multi = FileUtil.createFile(request);
		
		int item_num = Integer.parseInt(multi.getParameter("item_num"));
		String photo1 = multi.getFilesystemName("photo1");
		String photo2 = multi.getFilesystemName("photo2");
		
		ItemDAO dao = ItemDAO.getInstance();
		ItemVO db_item = dao.getItem(item_num);
		
		//전송된 정보 저장
		ItemVO item = new ItemVO();
		item.setItem_num(item_num);
		item.setName(multi.getParameter("name"));
		item.setPrice(Integer.parseInt(multi.getParameter("price")));
		item.setQuantity(Integer.parseInt(multi.getParameter("quantity")));
		item.setDetail(multi.getParameter("detail"));
		item.setPhoto1(photo1);
		item.setPhoto2(photo2);
		item.setStatus(Integer.parseInt(multi.getParameter("status")));
		
		//상품정보 수정
		dao.updateItem(item);
		
		//새로운 상품 이미지가 업로드 될 경우
		if(photo1 != null) FileUtil.removeFile(request, db_item.getPhoto1());
		if(photo2 != null) FileUtil.removeFile(request, db_item.getPhoto2());
		
		request.setAttribute("notice_msg", "정상적으로 수정되었습니다.");
		request.setAttribute("notice_url", request.getContextPath()+"/item/adminModifyForm.do?item_num="+item_num);
		
		return "/WEB-INF/views/common/alert_singleView.jsp";
	}

}
