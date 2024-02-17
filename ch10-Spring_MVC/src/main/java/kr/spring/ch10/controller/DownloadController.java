package kr.spring.ch10.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadController {
	@RequestMapping("/file.do")
	public ModelAndView download(HttpSession session) {
		String path = session.getServletContext().getRealPath("/WEB-INF/file.txt");
		File downloadFile = new File(path);
								//뷰 이름    뷰에서 호출할 속성명   속성값
		return new ModelAndView("download","downloadFile",downloadFile);
	}
}
