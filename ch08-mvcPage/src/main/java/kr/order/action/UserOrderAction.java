package kr.order.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.cart.dao.CartDAO;
import kr.cart.vo.CartVO;
import kr.controller.Action;
import kr.item.dao.ItemDAO;
import kr.item.vo.ItemVO;
import kr.order.dao.OrderDAO;
import kr.order.vo.OrderDetailVO;
import kr.order.vo.OrderVO;

public class UserOrderAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Integer user_num = (Integer)session.getAttribute("user_num");
		if(user_num == null) {//로그인이 되지 않은 경우
			return "redirect:/member/loginForm.do";
		}
		
		//POST 방식의 접근만 허용
		if(request.getMethod().toUpperCase().equals("GET")) {
			return "redirect:/item/itemList.do";
		}
		
		//전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		CartDAO dao = CartDAO.getinstance();
		int all_total = dao.getTotalByMem_num(user_num);
		if(all_total <= 0) {
			request.setAttribute("notice_msg", "정상적인 주문이 아니거나 상품의 수량이 부족합니다.");
			request.setAttribute("notice_url", request.getContextPath()+"/item/itemList.do");
			return "/WEB-INF/views/common/alert_singleView.jsp";
		}
		
		//정상적인 주문
		//장바구니에 담겨 있는 상품 정보 반환
		List<CartVO> cartList = dao.getListCart(user_num);
		//주문 상품의 대표 상품명 생성
		String item_name;
		if(cartList.size()==1) {
			item_name = cartList.get(0).getItemVO().getName();
		}else {
			item_name = cartList.get(0).getItemVO().getName() + " 외 " + (cartList.size()-1) + "건";
		}
		
		//개별 상품정보 담기
		List<OrderDetailVO> orderDetailList = new ArrayList<OrderDetailVO>();
		ItemDAO itemDao = ItemDAO.getInstance();
		for(CartVO cart : cartList) {
			//주문 상품정보 반환
			ItemVO item = itemDao.getItem(cart.getItem_num());
			if(item.getStatus()==1) {
				//상품 미표시
				request.setAttribute("notice_msg", "["+item.getName()+"]상품 판매 중지");
				request.setAttribute("notice_url", request.getContextPath()+"/cart/list.do");
				return "/WEB-INF/views/common/alert_singleView.jsp";
			}
			
			if(item.getQuantity() < cart.getOrder_quantity()) {
				//상품 재고수량 부족
				request.setAttribute("notice_msg", "["+item.getName()+"]재고수량 부족으로 주문 불가");
				request.setAttribute("notice_url", request.getContextPath()+"/cart/list.do");
				return "/WEB-INF/views/common/alert_singleView.jsp";
			}
			
			OrderDetailVO orderDetail = new OrderDetailVO();
			orderDetail.setItem_num(cart.getItem_num());
			orderDetail.setItem_name(cart.getItemVO().getName());
			orderDetail.setItem_price(cart.getItemVO().getPrice());
			orderDetail.setOrder_quantity(cart.getOrder_quantity());
			orderDetail.setItem_total(cart.getSub_total());
			
			orderDetailList.add(orderDetail);
			
		}//end of for
		
		//주문 정보 담기
		OrderVO order = new OrderVO();
		order.setItem_name(item_name);//대표 상품 이름
		order.setOrder_total(all_total);//총 구매 금액
		order.setPayment(Integer.parseInt(request.getParameter("payment")));
		order.setReceive_name(request.getParameter("receive_name"));
		order.setReceive_post(request.getParameter("receive_post"));
		order.setReceive_address1(request.getParameter("receive_address1"));
		order.setReceive_address2(request.getParameter("receive_address2"));
		order.setReceive_phone(request.getParameter("receive_phone"));
		order.setNotice(request.getParameter("notice"));
		order.setMem_num(user_num);
		
		OrderDAO orderDao = OrderDAO.getInstance();
		orderDao.insertOrder(order, orderDetailList);
		
		//Refresh 정보를 응답 헤더에 추가
		response.addHeader("Refresh", "2;url=../main/main.do");
		request.setAttribute("accessMsg", "주문이 완료되었습니다.");
		request.setAttribute("accessUrl", request.getContextPath()+"/main/main.do");
		return "/WEB-INF/views/common/notice.jsp";
	}

}
