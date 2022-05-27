package com.yedam.java.ch0801;
/*
 * 인터페이스 : 상수필드와 추상메소드로 구성... +일반메소드 추가가능(1.8ver 이상)
 * 필드는 상수만(변수x)	
 * 생성자x
 * 메소드는 추상메소드(abstract,실행블록x) 
 */
public interface RemoteControl {
	//상수 필드 > 무조건 상수(초기화필수)
	public static final int MAX_VOLUME = 10;
	public int MIN_VOLUME = 0;	//초기화 안해도 상수로 인식해서 오류 냄
	
	//추상메소드
	public abstract void turnOn();
	public void turnoff(); 		//abstract 안 써도 자동으로 추상메소드로 인식
	public void setVolume(int volume);	//만능리모콘
	
	
/*//////////////////////////////추가된 기능////////////////////////////////
//추상메소드 추가하면 모든 구현 클래스에서 구현(정의)해야함 > 모두들 안 쓰는걸 추가하고픔
//실제로 많이 쓰지는 않음.
 	
	//일반메소드
	public default void show() {			//default붙임
		System.out.println("추가한 메소드");
	}
	//정적 메소드
 
*/
}
