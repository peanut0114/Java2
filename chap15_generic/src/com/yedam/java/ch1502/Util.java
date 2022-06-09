package com.yedam.java.ch1502;
/*
 * < ? extends A >
 * 와일드카드 <?>의 제한
 * 
 * extends ~
 * 숫자클래스의 최상위 클래스 Number 
 * 를 상속받는 클래스만 제네릭 타입으로 받겟따
 * 
 * super ~
 * 얘의 상위 클래스 타입만 받겠다
 */
public class Util {
	//숫자가늠			extends 뒤의 클래스로 제한됨
	public static <T extends Number> int compare(T t1, T t2) {
		
		double v1 = t1.doubleValue();	//Number의 메소드
		double v2 = t2.doubleValue();
		return Double.compare(v1, v2);
	}
	
}
