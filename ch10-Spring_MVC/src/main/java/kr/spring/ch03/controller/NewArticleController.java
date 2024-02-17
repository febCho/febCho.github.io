package kr.spring.ch03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.spring.ch03.service.ArticleService;
import kr.spring.ch03.vo.NewArticleVO;

@Controller
public class NewArticleController {
	@Autowired
	private ArticleService articleService;
	
	//@Autowired를 멤버변수에 명시하면 멤버변수에 대응한 set 메서드를 자동 생성
	/*
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	*/

	//Get 요청이 들어올 때 호출
	@GetMapping("/article/newArticle.do")
	public String form() {
		return "article/newArticleForm";
	}
	
	/*
	 * @ModelAttribute 어노테이션을 이용해서 전송된 데이터를 자바빈(VO)에 담기
	 * [기능]
	 * 1. 자바빈(VO) 생성
	 * 2. 전송된 데이터를 자바빈에 저장
	 * 3. View에서 사용할 수 있도록 request에 자바빈을 저장
	 * [형식]
	 * 1. @ModelAttribute(속성명) 자바빈클래스명 참조변수명
	 * 	  지정한 속성명으로 JSP에서 request에 접근해서 자바빈 호출 가능
	 * 예) ${속성명.title}
	 * 2. @ModelAttribute를 명시할 때 속성명을 생략할 수 있음
	 * 	  속성명을 생략하면 클래스명의 첫글자를 소문자로 속성명을 자동 생성
	 * 3. @ModelAttribute 생략
	 *    호출 메서드에 인자명만 명시
	 *    예) NewArticleVO vo
	 *    request에 저장되는 속성명은 클래스명의 첫글자를 소문자로 자동 생성
	 *    예) NewArticleVO -> newArticleVO
	 */
	//Post 요청이 들어올 때 호출
	@PostMapping("/article/newArticle.do")
	public String submit(NewArticleVO newArticleVO) {
		
		articleService.writeArticle(newArticleVO);
		
		return "article/newArticleSubmitted";
	}
}
