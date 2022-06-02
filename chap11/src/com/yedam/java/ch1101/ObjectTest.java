package com.yedam.java.ch1101;
/*
 * Object의 메소드 equals 와 해시코드 
 */
public class ObjectTest {

	public static void main(String[] args) {
		Object obj1 = new Object();	
		Object obj2 = new Object();	//새로운 인스턴스를 만들었기에 동등하지 않음
		
		if(obj1.equals(obj2)) {	//논리적으로 동등한가 = 동일한 타입, 동일한 필드값인가?
			System.out.println("obj1과 obj2가 논리적으로 동등합니다.");
		}else {
			System.out.println("obj1과 obj2가 논리적으로 동등하지 않습니다.");
		}
		if(obj1==obj2) {
			System.out.println("obj1과 obj2가 논리적으로 동등합니다.");
		}
	}

}
