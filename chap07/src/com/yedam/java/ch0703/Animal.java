package com.yedam.java.ch0703;
/*
 * 추상클래스
 */
public abstract class Animal {

	public void breathe() {	//공통특성
		System.out.println("숨을 쉽니다.");
	}
	
	public abstract void sound(); //다 다른 구현. 시그니처만 만듬
}
