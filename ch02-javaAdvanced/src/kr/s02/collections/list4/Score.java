package kr.s02.collections.list4;

public class Score {
	/*
	 * [실습]
	 * 1. 멤버 변수: 이름(name), 국어(korean), 영어(english), 수학(math)
	 * 2. 생성자: 인자가 없는 생성자, 인자가 있는 생성자
	 * 3. 메서드: 총점 구하기(int makeSum), 평균 구하기(double makeAvg),
	 *    등급 구하기(String makeGrade), set/get
	 */
	
	private String name;
	private int korean;
	private int english;
	private int math;
	
	public Score() {}

	public Score(String name, int korean, int english, int math) {
		super();
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	
	public int makeSum() {
		return korean + english + math;
	}
	
	public double makeAvg() {
		return makeSum() / 3.0;
	}
	
	public String makeGrade() {
		String grade;
		//makeAvg()의 자료형이 double이므로 (int)로 강제 형변환 필요
		switch((int)makeAvg()/10) {
		case 10:
		case 9: grade = "A"; break;
		case 8: grade = "B"; break;
		case 7: grade = "C"; break;
		case 6: grade = "D"; break;
		default: grade = "F";	
		}
		return grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
}
