package com.yedam.java.ch0702;

public class Father extends GranPa{
	
	@Override
	void method() {
		System.out.println("Father 메소드");
	}
	
	void method2() {		//그랜파에 없는 메소드
		System.out.println("Father 고유 메소드");
	}
}
