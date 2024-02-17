package kr.web.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//request에 데이터 저장    속성명       속성값
		request.setAttribute("message","목록 페이지입니다.");
		//JSP 경로 반환
		return "/ch22-mvc/list.jsp";
	}

}