package kr.spring.ch09.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.spring.ch09.vo.MemberVO;

@Controller
public class MemberWriteController {
	//자바빈(VO) 초기화
	@ModelAttribute("vo")
	public MemberVO initCommand() {
		return new MemberVO();
	}
	
	@GetMapping("/member/write.do")
	public String form() {
		return "member/write";
	}
	
	@PostMapping("/member/write.do")
	public String submit(@ModelAttribute("vo") @Valid MemberVO memberVO,
						BindingResult result) {
		System.out.println("데이터 전송 후 : " + memberVO);
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return form();
		}
		
		return "redirect:/index.jsp";
	}
}
