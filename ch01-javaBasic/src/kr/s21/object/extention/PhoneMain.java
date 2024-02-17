package kr.s21.object.extention;

public class PhoneMain {
	public static void main(String[] args) {
		SmartPhone sp
			= new SmartPhone("010-1234", "A1001", "white", "안드로이드");
		FeaturePhone fp
			= new FeaturePhone("010-5432", "B1001", "black", 1000);
		
		System.out.println("===========================");
		System.out.println("번호\t\t모델\t색상\t특징(OS/화소수)");
		System.out.print(sp.getNumber() + "\t");
		System.out.print(sp.getModel() + "\t");
		System.out.print(sp.getColor() + "\t");
		System.out.println(sp.getOs());
		
		//그냥 아래와 같이 출력해도 됨.
		//System.out.println(sp.number);
				
		System.out.print(fp.getNumber() + "\t");
		System.out.print(fp.getModel() + "\t");
		System.out.print(fp.getColor() + "\t");
		System.out.println(fp.getPixel());
	}
}
