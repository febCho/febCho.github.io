package kr.spring.ch04.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	@RequestMapping("/cookie/make.do")
	public String make(HttpServletResponse response) {
		
		//쿠키를 생성해서 클라이언트에 전송
		response.addCookie(new Cookie("auth", "1"));
		
		return "cookie/make";
	}
	
	@RequestMapping("/cookie/view.do")
	public String view(@CookieValue(value="auth",defaultValue = "0") String auth) {
		
		System.out.println("auth 쿠키 : " + auth);
		return "cookie/view";
	}
}
