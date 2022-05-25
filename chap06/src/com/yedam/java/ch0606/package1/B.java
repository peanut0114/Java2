package com.yedam.java.ch0606.package1;
/*
 * 접근 제한자
 * A의 필드에 접근
 */
public class B {
		//필드
		A a1 = new A(true);
		A a2 = new A(1);
	//	A a3 = new A("문자열");	//private는 클래스 내에서만 접근가능
		
		//생성자
		public B() {
			A a = new A();
			a.field1 = 1;
			a.field2 = 2;
		//	a.field3 = 3;
			
			a.method1();
			a.method2();
		//	a.method3();
		}
		
}
