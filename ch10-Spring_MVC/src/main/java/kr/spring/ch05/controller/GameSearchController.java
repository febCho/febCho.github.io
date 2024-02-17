package kr.spring.ch05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.ch05.service.SearchService;
import kr.spring.ch05.vo.SearchVO;

@Controller
public class GameSearchController {
	@Autowired
	private SearchService searchService;
	
	@RequestMapping("/search/main.do")
	public String main() {
		return "search/main";
	}
	
	@RequestMapping("/search/game.do")
	public ModelAndView search(SearchVO searchVO) {
		
		System.out.println("검색어 : " + searchVO.getQuery());
		
		//service의 메서드가 동작 후 반환하는 데이터를 받음
		String result = searchService.search(searchVO);
		
		ModelAndView mav = new ModelAndView();
		//뷰 이름 지정
		mav.setViewName("/search/game");
		//뷰에 전달할 데이터 지정
		mav.addObject("result",result);
		
		return mav;
	}
}
