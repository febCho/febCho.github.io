package kr.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.order.dao.OrderDAO;
import kr.order.vo.OrderVO;

public class AdminModifyStatusAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Integer user_num = (Integer)session.getAttribute("user_num");
		if(user_num == null) {
			return "redirect:/member/loginForm.do";
		}
		Integer user_auth = (Integer)session.getAttribute("user_auth");
		if(user_auth != 9) {//관리자가 아닌 경우
			return "/WEB-INF/views/common/notice.jsp";	
		}
		
		//전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		OrderVO order = new OrderVO();
		order.setStatus(Integer.parseInt(request.getParameter("status")));
		order.setOrder_num(Integer.parseInt(request.getParameter("order_num")));
		
		OrderDAO dao = OrderDAO.getInstance();
		OrderVO db_order = dao.getOrder(order.getOrder_num());
		//사용자가 배송 상태를 5로 변경했을 경우
		if(db_order.getStatus() == 5) {
			request.setAttribute("notice_msg", "사용자가 배송 상태를 주문 취소로 변경하여 배송 상태를 수정할 수 없음");
			request.setAttribute("notice_url", request.getContextPath()+"/order/adminDetail.do?order_num="+order.getOrder_num());
			return "/WEB-INF/views/common/alert_singleView.jsp";
		}
		
		dao.updateOrderStatus(order);
		
		request.setAttribute("notice_msg", "정상적으로 수정되었습니다.");
		request.setAttribute("notice_url", request.getContextPath()+"/order/adminDetail.do?order_num="+order.getOrder_num());
		
		return "/WEB-INF/views/common/alert_singleView.jsp";
	}

}
