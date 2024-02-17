package kr.s30.util.date;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateMain {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		System.out.println(now.toString());//to String 재정의
		System.out.println("=================");
		
		//deprecated 되어 사용하지 않음
		System.out.println(now.toLocaleString());
		
		//getInstance 메서드를 통해 객체를 생성하여 df로 반환
		DateFormat df = DateFormat.getInstance();
		String today = df.format(now);
		System.out.println(today);
		System.out.println("==================");
		
		df = DateFormat.getDateTimeInstance();
		today = df.format(now);
		System.out.println(today);
		System.out.println("====================");
		
		df = DateFormat.getDateInstance();
		today = df.format(now);
		System.out.println(today);
		System.out.println("==================");
		
		df = DateFormat.getTimeInstance();
		today = df.format(now);
		System.out.println(today);
		System.out.println("=====================");
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy년MM월dd일 (E) a hh:mm:ss");
		today = sf.format(now);
		System.out.println(today);
	}
}
