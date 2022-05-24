package com.yedam.java.ch0605;

public class CarTest2 {

	public static void main(String[] args) {

		Car first = new Car("레이");
		Car second = new Car("모닝");
		System.out.println("정적 필드 : "+Car.count);	 	//정적필드값 출력
		System.out.println("first : "+first.count);		//공유됨
		System.out.println("second : "+second.count);
		
	}

}
