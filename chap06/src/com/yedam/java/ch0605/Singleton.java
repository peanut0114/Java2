package com.yedam.java.ch0605;
/*
 * 싱글톤
 * 프로젝트 내에 딱 하나만 존재해야 할 때 사용
 */
public class Singleton {
	//**필드**
	private static Singleton singleton = new Singleton();	//자기 자신도 필드로 가질 수 있음
	//static 써야 외부에서 사용가능, private으로 아무나 접근 못하게 막음
	
	//**생성자**
	//Singleton() {}	//일반 생성자
	private Singleton() {}	//외부(main)에서 싱글톤 만들 수 없음 -> 내부에서 new
	
	//**메소드**
	static Singleton getInstance() {	//외부에서 접근하려면 메소드 사용
		return singleton;
	}
}
