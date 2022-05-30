package com.yedam.java.ch0901;
/*
 * 중첩클래스 개념
 * A의 인스턴스 멤버 클래스 B
 * A의 정적 멤버 클래스 C (정적 = 인스턴스와 무관)
 * A의 method의 로컬 클래스 D
 * 
 * MainTest
 */
public class A {
	A() {
		System.out.println("A 인스턴스가 생성됨.");
	}

// 인스턴스 멤버 클래스	>하나의 인스턴스를 통해 접근(A필수)
	class B {
		// 필드
		int field1;
		//static int fields;	 	//정적필드 불가
		// 생성자
		B() {
			System.out.println("B 인스턴스가 생성됨.");
		}// 상속은 인스턴스가 동시에 생기지만 중첩클래스는 따로 생김

		// 메소드
		void method1() {}
	}
	
//정적 멤버 클래스	
	static class C{	
		//필드
		int field1;	//인스턴스필드
		static int field2;			//!정적필드!
		//생성자
		C(){
			System.out.println("C 인스턴스가 생성됨.");
		}
		//메소드
		void method1() {}	
		static void method2() {}	//!정적메소드!
	}
	
//로컬 클래스	> 선언하고 바로 써야 함!
	void method() {
		
		class D{
			//필드
			int field;				//정적 불가
			//생성자
			D(){
				System.out.println("D 인스턴스가 생성됨.");
			}
			//메소드
			void method1() {}
		}
		
		D d = new D();	//안에서 쓰기 때문에 A정보 필요X
		d.field = 1;
		d.method1();
	}
	
	
}
