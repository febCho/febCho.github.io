package kr.spring.ch21;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.spring.product.Product;

public class SpringMain {
	public static void main(String[] args) {
		//컨테이너를 생성
		AbstractApplicationContext context = 
		new ClassPathXmlApplicationContext("applicationContextAOP2.xml");
		
		//핵심 기능이 구현된 메서드 호출
		Product p = (Product)context.getBean("product");
		p.launch();
		
		context.close();
	}
}
