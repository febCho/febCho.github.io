package kr.spring.ch16;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
		new ClassPathXmlApplicationContext("applicationContextAnnotation.xml");
		
		//@Autowired 어노테이션을 이용한 의존 관계 자동 설정
		SystemMonitor monitor = (SystemMonitor)context.getBean("monitor");
		System.out.println(monitor);
		
		context.close();
	}
}
