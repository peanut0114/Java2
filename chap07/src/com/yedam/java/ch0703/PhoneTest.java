package com.yedam.java.ch0703;

public class PhoneTest {

	public static void main(String[] args) {
/*
 * 		기본클래스처럼 new 연산자 사용 불가
		Phone phone =  new Phone("Z플립","블랙"); 
		phone.powerOn();
	*/
		
		DmbPhone dmbPhone = new DmbPhone("Z플립","블랙");
		dmbPhone.powerOn();
		dmbPhone.showDmb();
		dmbPhone.bell();
	}

}
