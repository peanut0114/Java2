package com.yedam.java.ch0902;
/*
 * 익명 개체
 * 필드, 로컬변수, 매개변수 어디든 익명개체 사용 가능
 * 필드와 메소드 가질 수 있지만 외부에서 호출 불가능
 * 부모클래스에 있는 메소드만 호출 가능 -> Overring을 통해 결과 도출해야만!
 */
public class PersonTest {

	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		
		//필드 - 익명 객체
		anony.field.wake();
		System.out.println();
		
		//로컬변수 - 익명 객체
		anony.method1();
		System.out.println();
		
		//매개변수 - 익명 객체
		anony.method2(new Person() {
			//필드
			String job = "학생";
			//메소드
			void study() {
				System.out.println("공부합니다.");
			}
			@Override
			void wake() {
				System.out.println("8시에 일어납니다.");
				study();
			}
		});
	}

}
