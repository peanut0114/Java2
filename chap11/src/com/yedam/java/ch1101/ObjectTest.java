package com.yedam.java.ch1101;
/*
 * Object의 메소드 (override해서 사용하는 세가지)
 * equals 와 hashCode : 필드 같은지 식별(필수)
 * toString : 관례적 이용 많음 (우리쓰던 showInfo)
 */
public class ObjectTest {

	public static void main(String[] args) {
		Object obj1 = new Object();	
		Object obj2 = new Object();	//새로운 인스턴스를 만들었기에 동등하지 않음
		
//오버라이딩 하지 않은 오브젝트의 이퀄스
		if(obj1.equals(obj2)) {	//논리적으로 동등한가 = 동일한 타입, 동일한 필드값인가?
			System.out.println("obj1과 obj2가 논리적으로 동등합니다.");
		}else {
			System.out.println("obj1과 obj2가 논리적으로 동등하지 않습니다.");
		}
		if(obj1==obj2) {
			System.out.println("obj1과 obj2가 논리적으로 동등합니다.");
		}

//메소드 재정의함 (equals를 Members에서 오버라이딩 함)
		
		//3개의 인스턴스 생성
		Member m1 = new Member("blue");
		Member m2 = new Member("blue");	//m1과 m2는 내부 필드값이 동일
		Member m3 = new Member("red");
		
		if(m1.equals(m2)) {	//같은 필드값을 가질 때 동등함
			System.out.println("m1과 m2는 동등합니다.");	
		} else {
			System.out.println("m1과 m2는 동등하지 않습니다.");
		}
		
		if(m1.equals(m3)) {
			System.out.println("m1과 m3는 동등합니다.");
		} else {
			System.out.println("m1과 m3는 동등하지 않습니다.");
		}
	}

}
