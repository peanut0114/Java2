package com.yedam.java.ch0802;
/*
 * 인터페이스를 이용한 다형성
 * 타입을 인터페이스로 정하고, 필요에따라 구현클래스로 교체
 */
public class CarTest {
	public static void main(String[] args) {
		Car myCar =  new Car();
		myCar.run();			//차를 굴립니다.
		System.out.println();
		
		//타입을 인터페이스로 정하고
		//필요에 따라 바퀴 교체
		myCar.frontLeftTire = new HanKookTire();
		myCar.frontRightTire = new HanKookTire();
		
		myCar.run();			
	}
}
