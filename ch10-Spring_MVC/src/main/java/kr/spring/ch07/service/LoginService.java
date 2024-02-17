package kr.spring.ch07.service;

import kr.spring.ch07.vo.LoginVO;

public class LoginService {
	public void checkLogin(LoginVO loginVO) throws LoginCheckException{
		//테스트용으로 userId와 password의 값이 일치하면 로그인으로 처리
		if(!loginVO.getUserId().equals(loginVO.getPassword())) {
			System.out.println("인증 에러 : " + loginVO.getUserId());
			throw new LoginCheckException();
		}
	}
}
