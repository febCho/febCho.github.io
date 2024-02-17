package kr.s31.util.calendar;

import java.util.Calendar;

public class CalendarMain01 {
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		System.out.println(today);
		
		int year = today.get(Calendar.YEAR);//연도
		int month = today.get(Calendar.MONTH)+1;//월(0~11)
		int date = today.get(Calendar.DATE);//일
		
		System.out.printf("%d년%d월%d일 ", year, month, date);
		
		int day = today.get(Calendar.DAY_OF_WEEK);//요일(1~7)
		
		String[] days = {"일", "월", "화", "수", "목", "금", "토"};
		               // 0     1    2    3    4     5    6
		System.out.println(days[day-1]+"요일");
		//0부터 시작하는 배열 값과 맞춰주기 위해 추출한 요일 값에 -1을 함.
		
		int amPm = today.get(Calendar.AM_PM);//오전 0, 오후 1
		String str = amPm == Calendar.AM ? "오전" : "오후";
		
		//HOUR: 0~11, 정오와 자정은 12가 아니라 0으로
		int hour = today.get(Calendar.HOUR);//시(12시 표기)
		int hour2 = today.get(Calendar.HOUR_OF_DAY);//시(24시 표기)
		int min = today.get(Calendar.MINUTE);//분
		int sec = today.get(Calendar.SECOND);//초
		
		System.out.printf("%s %d시%d분%d초", str, hour, min, sec);
	}
}
