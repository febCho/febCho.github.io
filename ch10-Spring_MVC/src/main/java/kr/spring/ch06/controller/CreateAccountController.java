package kr.spring.ch06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.spring.ch06.validator.MemberInfoValidator;
import kr.spring.ch06.vo.MemberInfo;

@Controller
public class CreateAccountController {
	
	//유효성 체크를 할 경우 자바빈(VO) 초기화 필수
	//자바빈(VO)를 초기화하면 request에 "vo" 속성명으로 저장됨
	@ModelAttribute("vo")
	public MemberInfo initCommand() {
		return new MemberInfo();
	}
	
	@GetMapping("/account/create.do")
	public String form() {
				//뷰 이름 지정
		return "account/creationForm";
	}
	
	@PostMapping("/account/create.do")
	public String submit(@ModelAttribute("vo") MemberInfo memberInfo,
						BindingResult result) {
		
		System.out.println("데이터 전송 후 : " + memberInfo);
		
		//전송된 데이터 유효성 체크
		new MemberInfoValidator().validate(memberInfo,result);
		
		//BindingResult에 유효성 체크 결과 오류에 대한 내용이 저장되어 있으면
		//데이터가 created.jsp로 넘어가지 않고 폼을 다시 호출함
		if(result.hasErrors()) {
			return "account/creationForm";
		}
		
		return "account/created";
	}
}
