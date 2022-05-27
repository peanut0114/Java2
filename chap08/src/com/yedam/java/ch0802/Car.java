package com.yedam.java.ch0802;
/*
 * 독립된 클래스 Car
 */
public class Car {
	//타입은 인터페이스
	Tire frontLeftTire = new KumhoTire();
	Tire frontRightTire = new KumhoTire();
	Tire backLeftTire = new KumhoTire();
	Tire backRightTire = new KumhoTire();
	
	void run() {
		frontLeftTire.roll();
		frontRightTire.roll();
		backLeftTire.roll();
		backRightTire.roll();
	}
}
