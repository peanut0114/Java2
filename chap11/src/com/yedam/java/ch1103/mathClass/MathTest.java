package com.yedam.java.ch1103.mathClass;
/*
 * 래퍼클래스
 * 래퍼클래스는 내부값을 못 건들기 때문에 기본타입에 언박싱해서 넣어 씀
 * 기본타입과 래퍼클래스를 동일하게 취급해도 이클립스가 알아서 자동 박싱/언박싱 해줌
 * 여러값이 들어있으면 불가능하지만 래퍼클래스가 값을 하나만 갖고있음
 */
public class MathTest {

	public static void main(String[] args) {
//박싱
		//코드는 살아있지만 더이상 사용하지 말라며 그어버림
		Integer obj1 = new Integer(100); 
		//요거 쓰면 됨. 실수타입 래퍼클래스를 만듬
		Integer obj2 = Integer.valueOf("100");
		Integer obj3 = 100;	//정수 넣어도 알아서 박싱해줌 (100.0은 더블이라 오류)
//언박싱
		int val2 = obj2.intValue();	//공식 언박싱 메소드. 인트타입 값을 끄집어냄
		int val3 = obj3;	//Integer 클래스가 기본타입인 int에 대입이 됨. 자동 언박싱됨
							//둘을 동일하게 써도 문제 없음.\
		int result = obj2 + val3;	//원래는 타입이 달라서 연산 불가능하지만 integer라 자동 연산시켜버림
//값비교	: 언박싱해서 값을 비교하던가, 이퀄즈 쓰던가
		Integer object1 = 300;
		Integer object2 = 300;
		//래퍼클래스도 클래스! 산술연산 할 때는 자동 언박싱하지만, 등호연산자 비교할때는 클래스로 인식
		System.out.println("== 결과 : "+ (object1==object2));
		System.out.println("언박싱 후 == 결과 : "+(object1.intValue()==object2.intValue()));
		System.out.println("equals 결과 : "+object1.equals(object2));
		
		
	}

}
