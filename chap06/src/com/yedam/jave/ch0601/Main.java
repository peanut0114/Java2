package com.yedam.jave.ch0601;

public class Main {

	public static void main(String[] args) {

		Car myCar = new Car();
		System.out.println(myCar);	//변수가 참조한 인스턴스 주소 다름
		Car yourCar = new Car();
		System.out.println(yourCar);
	}

}
