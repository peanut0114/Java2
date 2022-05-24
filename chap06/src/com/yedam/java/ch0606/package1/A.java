package com.yedam.java.ch0606.package1;
/*
 * 접근제한자 차이
 * 같은 패키지 내 B, 같은 프로젝트 다른 패키지 내 C에서 접근
 */
public class A {
	//필드
	A a1 = new A(true);
	A a2 = new A(1);
	A a3 = new A("문자열");
	
	//생성자
	public A(boolean b) {}	//public
	A(int b){}				//default
	private A(String s) {}	//private
	
	
///////////////////////////////////////////////////////////////////
	
	//필드
	public int field1;
	int field2;
	private int field3;
	
	//생성자
	public A() {
		field1 = 1;
		field2 = 2;
		field3 = 3;
		
		method1();
		method2();
		method3();
	}
	
	//메소드
	public void method1() {}
	void method2() {}
	private void method3() {}
	
	
}
