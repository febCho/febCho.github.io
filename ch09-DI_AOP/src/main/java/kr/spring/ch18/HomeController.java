package kr.spring.ch18;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * 설정 파일에 <context:component-scan> 태그를 추가하고 자동 스캔을 해야 하는
 * 패키지를 지정하면 해당 패키지에서 @Component 어노테이션이 적용된 클래스를
 * 검색하여 빈 객체로 등록
 * 
 * 자동 등록된 빈의 아이디(빈 객체의 식별자)는 클래스의 첫 글자를 소문자로 바꿔서 사용함
 * 예) 클래스명이 HomeController -> 빈 객체의 식별자는 homeController
 * 
 * 빈의 이름을 지정하고 싶으면 @Component("home")이라고 명시함 또는
 * @Component
 * @Named("home")도 가능
 */
@Component
@Named("home")
public class HomeController {
	@Autowired
	private Camera camera;

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	@Override
	public String toString() {
		return "HomeController [camera=" + camera + "]";
	}
}
