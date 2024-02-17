package kr.spring.ch07.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.spring.ch07.vo.LoginVO;

public class LoginVOValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return LoginVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LoginVO loginVO = (LoginVO)target;
		if(loginVO.getUserId() == null || loginVO.getUserId().isEmpty()) {
							   //필드      에러코드
			errors.rejectValue("userId", "required");
		}
		if(loginVO.getPassword() == null || loginVO.getPassword().isEmpty()) {
			errors.rejectValue("password", "required");
		}
	}
}
