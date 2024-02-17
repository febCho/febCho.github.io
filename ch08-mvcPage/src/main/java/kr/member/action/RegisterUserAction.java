package kr.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.controller.Action;
import kr.member.dao.MemberDAO;
import kr.member.vo.MemberVO;

public class RegisterUserAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//전송된 데이터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		//자바빈(VO) 생성
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setName(request.getParameter("name"));
		vo.setPasswd(request.getParameter("passwd"));
		vo.setPhone(request.getParameter("phone"));
		vo.setEmail(request.getParameter("email"));
		vo.setZipcode(request.getParameter("zipcode"));
		vo.setAddress1(request.getParameter("address1"));
		vo.setAddress2(request.getParameter("address2"));
		
		MemberDAO dao = MemberDAO.getinstance();
		dao.insertMember(vo);
		
		//JSP 경로 반환
		return "/WEB-INF/views/member/registerUser.jsp";
	}

}
