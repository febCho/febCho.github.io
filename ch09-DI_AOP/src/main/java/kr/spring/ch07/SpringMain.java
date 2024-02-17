package kr.spring.ch07;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		/*
		 * applicationContext2.xml 설정파일을 읽어들여 스프링 컨테이너를 생성
		 */
		AbstractApplicationContext context = 
		new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		//DI 프로퍼티 설정 방식으로 생성된 객체 호출
		RegisterService service = (RegisterService)context.getBean("registerService");
		service.write();
		
		//어플리케이션 종료 시 컨테이너에 존재하는 모든 빈(객체)를 종료
		context.close();
	}
}
