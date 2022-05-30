package com.yedam.java.ch0901;
/*
 * 중첩클래스
 * 바깥클래스 상태에 따라 달라지는 상황
 */
public class Y {
	//필드
	int field1;
	static int field2;
	
	//메소드
	void method1() {}
	static void method2() {}
	
//인스턴스 멤버 클래스 	-> Y클래스의 인스턴스가 반드시 존재
//					-> 인스턴스가 접근할 수 있는 모든 내부 멤버를 호출할 수 있음.
	class B{
		void method() {
			field1 =1;
			field2 =1;
			
			method1();
			method2();
		}
	}
	
//정적 멤버 클래스	-> Y클래스의 인스턴스가 존재하지 않을때도 사용가능
//				-> Y클래스의 정적 내부 멤버들만 호출 할 수 있음.
	static class C{		
		void method() {
			//field1 =1;	//Y클래스의 필드에 접근할때
			field2 =1;	//정적 필드만 사용가능 (인스턴스 필요없는 정적멤버만!)
			
			//method1();
			method2();
		}
	}
	
//로컬 클래스
	//메인 돌리다가 필요에따라 작업을 실행시키고 결과를 반환시키는 기능 쓸때 (알람 기능 등)
	//경우에 따라 메소드가 종료되는것과 무관하게 로컬 클래스 인스턴스가 살아있을 수 있음.(드문경우)
	int method(final int arg) {	//final 안 써도 자동으로 final ->수정x(상수성격)
		final int var = 1;		// "
		//arg = 100;
		//var = 90;
		class D{						
			void method() {				//상위 메소드는 종료되고 얘만 남으면
				int result = arg +var;	//값을 가져올 수가 없음 ->오류 
			}//시작할 때 값을 복사해놓고 나중에 D가 호출될 때를 대기함 
		}	 //언제 끝날지 알 수 없기때문에 시작할 때 저장. ->상위 메소드 내부에서 값을 새로 넣으면 결과가 달라질 수 있음 (주석처리)
		D d = new D();
		d.method();
		//var = 2;
		return var;
	}
}
