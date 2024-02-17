package kr.web.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	//추상메서드
	public String execute(HttpServletRequest requset,
						  HttpServletResponse response)
								  		throws Exception;
}