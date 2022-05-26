package com.yedam.java.ch0703;
/*
 * 실체클래스
 * 추상클래스의 추상메소드까지 정의해야 함 (필수)
 */
public class Dog extends Animal {

	@Override
	public void sound() {
		System.out.println("월!월!('t'u"); //장군이 보구싶다아 
	}

}
