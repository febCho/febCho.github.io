package kr.s24.object6.inter;

//인터페이스: 형식만 있고 내용이 없음
interface CookieMold{//쿠키틀
	public abstract void makeStar();
	public abstract void makeCircle();
	public abstract void makeDiamond();
}
class Cookie implements CookieMold{
	//인터페이스가 형식을 제공하면 클래스에 구현해서 내용을 채워준다.
	@Override
	public void makeStar() {
		System.out.println("별 모양의 쿠키를 만들다");
	}
	@Override
	public void makeCircle() {
		System.out.println("원 모양의 쿠키를 만들다");
	}
	@Override
	public void makeDiamond() {
		System.out.println("다이아몬드 모양의 쿠키를 만들다");
	}
}

public class InterMain03 {
	public static void main(String[] args) {
		Cookie cookie = new Cookie();
		cookie.makeStar();
		cookie.makeCircle();
		cookie.makeDiamond();
	}
}
