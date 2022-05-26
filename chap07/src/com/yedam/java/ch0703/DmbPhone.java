package com.yedam.java.ch0703;
/*
 * 실체클래스 : 고유의 특성 추가
 * phone을 상속하는 dmbphone 필요
 * 추상메소드를 재정의 해줘야 함 (안 하면 오류!)
 */
public class DmbPhone extends Phone {
	
	public DmbPhone(String model, String color) {
		super(model,color);
	}
	
	@Override
	public void powerOn() {
		super.powerOn();
		System.out.println("부팅이 완료되었습니다.");
	}

	public void showDmb() {
		System.out.println("DMB를 실행합니다.");
	}

	@Override
	public void bell() {	//추상메소드를 재정의
		System.out.println("벨이 울립니다.\n♬11:11-태연(TAEYEON)♬");
	}

}
