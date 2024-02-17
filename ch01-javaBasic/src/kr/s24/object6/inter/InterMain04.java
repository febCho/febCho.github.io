package kr.s24.object6.inter;

interface I{
	public abstract void play();
}

class Pianist implements I{
	@Override
	public void play() {
		System.out.println("피아노를 연주하다.");
	}
}

class Cellist implements I{
	@Override
	public void play() {
		System.out.println("첼로를 연주하다.");
	}
}

class Stage{
	//Pianist와 Cellist의 부모 클래스인 object에는 play 메서드가 없어서 불가
	//그렇다고 둘 중 하나만 하면 다른 건 못 쓰기 때문에
	//공통의 자료형으로 인터페이스 I를 명시
	public void autoPlay(I i) {
		i.play();
	}
}
public class InterMain04 {
	public static void main(String[] args) {
		Stage a = new Stage();
		a.autoPlay(new Pianist());//Pianist -> I
		                         //클래스 타입 -> 인터페이스 타입으로 형변환
		a.autoPlay(new Cellist());//Cellist -> I
		
		//Pianist p = new Pianist();
		//a.autoPlay(p);
		//Cellist c = new Cellist();
		//a.autoPlay(c);
		//위와 같이 작성하면 변수를 한 번밖에 쓰지 않으니
		//굳이 변수를 쓰지 않고 생성자를 바로 메서드 안에 대입함.
	}
}
