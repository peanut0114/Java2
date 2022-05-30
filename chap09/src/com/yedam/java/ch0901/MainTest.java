package com.yedam.java.ch0901;
/*
 * 중첩클래스
 */
public class MainTest {
	public static void main(String[] args) {
//인스턴스 멤버 클래스
		A a = new A();
		//A의 인스턴스가 생성되어야 B 호출가능
		System.out.println();
		
		A.B b = a.new B(); 
		// A 클래스이름x, A로 만들어진 인스턴스(변수이름a)로 내부 클래스B 접근

		b.field1=1;			//사용법은 동일
		b.method1();
		System.out.println();
		
//정적 멤버 클래스		
		A.C.field2 = 2;		//A 인스턴스 없이 (위 내용 주석처리)
		A.C.method2();		//C의 정적필드, 정적메소드에 바로 접근가능
		
		A.C c = new A.C();	//A클래스의 인스턴스 생성 필요 없음
		c.field1 = 1;
		c.method1();
		System.out.println();
		
//로컬 클래스
		a.method();			//D가 들어있는 A의 메소드 호출시 생성
		
	}
}
