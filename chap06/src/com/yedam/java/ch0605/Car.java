package com.yedam.java.ch0605;
/*
 * 인스턴스 멤버 & 정적 멤버
 */
public class Car {
	//필드
	public String model;	//public: 다른 패키지에서도 호출가능
	public int speed;
	
	//정적필드 - 생산수량
	public static int count;		//모든 인스턴스에서 공유(모두 접근가능! 사용주의)
	
	//생성자
	public Car(String model){		//우리가 생성자 만들시 자바가 자동생성x
		this.model = model;	//this로 필드 접근
		Car.count++;		//인스턴스 만들어질 때마다 카운트 업
	}						//정적변수에는 this X. 클래스 이름으로 접근 (생략가능)
	
	//메소드
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void run() {
		for(int i=10; i<=50 ; i+=10) {	//i가 10씩 증가
			this.setSpeed(i);
			System.out.printf("%s가 달립니다.(시속:%dkm/h)\n",this.model,this.speed);
		}
	}
	
}
