package kr.spring.ch17;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
		new ClassPathXmlApplicationContext("applicationContextAnnotation.xml");
		
		//@Resource 어노테이션을 이용한 프로퍼티 설정
		HomeController home = (HomeController)context.getBean("homeController");
		System.out.println(home);
		
		context.close();
	}
}
