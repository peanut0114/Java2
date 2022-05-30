package com.yedam.java.ch0901;
/*
 * 중첩 클래스 사용법
 */
public class Z {
//인스턴스 멤버 -> Z클래스의 인스턴스가 존재
	B field1 = new B();	//Z클래스의 인스턴스가 존재
	C field2 = new C();	//Z클래스의 정보만 있으면 됨
	
	void method1() {
		B var1 = new B();
		C var2 = new C();
	}
//정적 멤버 -> Z클래스의 인스턴스가 없을 수 있다
	//인스턴스 없이움직이는 정적 필드, 정적메소드 > Z인스턴스 없더라도 사용가능해야함
	//static B field3 = new B(); 	//B는 반드시 Z인스턴스가 필요
	static C field4 = new C();	//C는 Z클래스의 정보만 필요
		
	static void method2() {
		//B var1 = new B();
		C var2 = new C();
	}
	
//인스턴스 멤버 클래스
	class B{}
//정적 맴버 클래스
	static class C{}
	
}
