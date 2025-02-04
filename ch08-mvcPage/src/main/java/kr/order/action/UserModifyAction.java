package kr.order.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.controller.Action;
import kr.order.dao.OrderDAO;
import kr.order.vo.OrderVO;

public class UserModifyAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Integer user_num = (Integer)session.getAttribute("user_num");
		if(user_num == null) {//로그인이 되지 않은 경우
			return "redirect:/member/loginForm.do";
		}
		
		//전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		//주문번호 반환
		int order_num = Integer.parseInt(request.getParameter("order_num"));
		
		OrderDAO dao = OrderDAO.getInstance();
		OrderVO db_order = dao.getOrder(order_num);
		if(db_order.getMem_num() != user_num) {
			//구매자 회원번호와 로그인한 회원번호가 불일치할 경우
			return "/WEB-INF/views/common/notice.jsp";
		}
		
		//배송지 수정 전 배송 상태 체크
		if(db_order.getStatus()>1) {
			//배송 준비 중 이상인 상태로 관리자가 변경한 상품을 주문자가 변경할 수 없음
			request.setAttribute("notice_msg", "배송상태가 변경되어 주문 정보 변경 불가");
			request.setAttribute("notice_url", request.getContextPath()+"/order/orderList.do");
			return "/WEB-INF/views/common/alert_singleView.jsp";
		}
		
		OrderVO order = new OrderVO();
		order.setOrder_num(order_num);
		order.setReceive_name(request.getParameter("receive_name"));
		order.setReceive_post(request.getParameter("receive_post"));
		order.setReceive_address1(request.getParameter("receive_address1"));
		order.setReceive_address2(request.getParameter("receive_address2"));
		order.setReceive_phone(request.getParameter("receive_phone"));
		order.setNotice(request.getParameter("notice"));
		//주문정보 수정
		dao.updateOrder(order);
		
		request.setAttribute("notice_msg", "정상적으로 수정되었습니다.");
		request.setAttribute("notice_url", request.getContextPath()+"/order/orderModifyForm.do?order_num=" + order_num);
		
		return "/WEB-INF/views/common/alert_singleView.jsp";
	}

}
