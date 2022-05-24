package com.yedam.java.ch0606.package2;
/*
 * 접근 제한자
 * pachage2의 A에 접근
 */
import com.yedam.java.ch0606.package1.A;

public class C {
		//필드
		A a1 = new A(true);		//public : 프로젝트 내의 어느 패키지에서든 가능
		A a2 = new A(1);		//default : 다른 패키지에서 오류
		A a3 = new A("문자열");	//private : 다른 클래스에서부터 오류
		
		//생성자
		public C() {
			A a = new A();
			a.field1 = 1;
			a.field2 = 2;
			a.field3 = 3;
			
			a.method1();
			a.method2();
			a.method3();
		}
}
