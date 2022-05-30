package com.yedam.java.ch0901;
/*
 * 중첩클래스에서 동명의 필드와 메소드를 만들 때
 * +중첩 인터페이스 >> 중첩 정적 인터페이스를 주로 사용
 */
public class Outter {
	String field = "바깥클래스 - 필드";
	void method() {
		System.out.println("바깥클래스 - 메소드");
	}
	void methodA() {
		System.out.println("바깥클래스 - 메소드 A");
	}
	
//인스턴스 멤버 클래스
	class Nested{
		String field = "중첩클래스 - 필드";
		void method() {
			System.out.println("중첩클래스 - 메소드");
		}
		
		void print() {
			methodA();	//Outter안에 위치하기 때문에 바깥클래스 메소드 호출 가능
			System.out.println(field);
			method();	//=this.method	//동일 이름 존재시 본인(nested) 안의 메소드 호출이 우선 
			System.out.println(Outter.this.field);
			Outter.this.method();
		}
	}

//중첩 인스턴스 인터페이스 (상수와 추상메소드 only)
	interface I{
		int FIELD = 100;
		void method();
	}
//중첩 정적 인터페이스 : 연관성이 큰 구현 클래스를 만들기 위함 > UI프로그래밍에 씀(그래픽유저인터페이스GUI)
//마우스 왼클 우클 인터페이스 >실제 프로그램마다 클릭시 움직이는 동작 구현 (독립적일 수 없고 같이 가야함)
//언제 어떤 동작을 할지 알 수 없음. 스스로 무언가 못함. 사용자 동작=이벤트 처리 
//Map :다양한 변수 받아옴. 외부에서 사용되는 크래스가 가지는 메소드를 알 수 없음. 클래스가 도달하려는 결과까지의 과정을 일련의 코드로 정리
//		map 안에 인터페이스를 정의. 내부 코드가 정상적으로 작동하려면 이 인터페이스를 사용해야만 함
	
	static interface N{	//바깥 클래스 정의 없이 사용가능. 
		int FIELD = 100;
		void method();
	}
}
