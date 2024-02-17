package kr.spring.ch06.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.spring.ch06.vo.MemberInfo;

public class MemberInfoValidator implements Validator{
	
	//Validator가 검증할 수 있는 타입인지를 검사
	@Override
	public boolean supports(Class<?> clazz) {
		return MemberInfo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberInfo memberInfo = (MemberInfo)target;
		if(memberInfo.getId() == null || memberInfo.getId().isEmpty()) {
			errors.rejectValue("id", "required");
		}
		if(memberInfo.getName() == null || memberInfo.getName().isEmpty()) {
			errors.rejectValue("name", "required");
		}
		if(memberInfo.getZipcode() == null || memberInfo.getZipcode().isEmpty()) {
			errors.rejectValue("zipcode", "required");
		}
		if(memberInfo.getAddress1() == null || memberInfo.getAddress1().isEmpty()) {
			errors.rejectValue("address1", "required");
		}
		if(memberInfo.getAddress2() == null || memberInfo.getAddress2().isEmpty()) {
			errors.rejectValue("address2", "required");
		}
	}
}
