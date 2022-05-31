package com.yedam.java.ch0902;
/*
 * 익명 자식 개체
 */
public class Anonymous extends Person{
	//필드
	Person field = new Person() {	//본인 이름이 없기에 new부모클래스 호출
		//필드
		String job = "회사원";
		//메소드
		void work() {
			System.out.println("출근합니다.");
		}
		
		@Override
		void wake() {
			System.out.println("6시에 일어납니다.");
			work();
		}
	};
	//생성자
	
	//메소드
	void method1() {
		//로컬변수
		Person var = new Person() {
			//필드
			String job = "취준생";
			//메소드
			void walk() {
				System.out.println("면접을 봅니다.");
			}
			
			@Override
			void wake() {
				System.out.println("7시에 일어납니다.");
				walk();
			}
		};
		
		var.wake();//부모가 가진 wake만 사용가능. job이나 walk 접근불가
	}
	
	void method2(Person person) {
		person.wake();
	}
}
