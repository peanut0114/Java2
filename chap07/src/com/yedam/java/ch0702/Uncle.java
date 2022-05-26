package com.yedam.java.ch0702;

public class Uncle extends GranPa {
	@Override
	void method() {
		System.out.println("Uncle 메소드");
	}
	
	void methd3() {	//그랜파에 없는 메소드
		System.out.println("Uncle 고유 메소드");
	}
}
