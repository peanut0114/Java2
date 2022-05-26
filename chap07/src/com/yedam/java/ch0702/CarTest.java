package com.yedam.java.ch0702;

public class CarTest {

	public static void main(String[] args) {

		Car car = new Car();
		
		for (int i=1 ; i<=5 ; i++) {
			int problemLocation = car.run(); //문제 발생시 위치 갖고 옴
			
			switch(problemLocation) {
			case 1:
				System.out.println("앞왼쪽 HankookTire 교체");
				car.frontLeftTire = new HankookTire("앞왼쪽",11);
				break;
			case 2:
				System.out.println("앞오른쪽 Tire 교체");
				car.frontRightTire = new Tire("앞오른쪽",14);
				break;
			case 3:
				System.out.println("뒤왼쪽 KumhoTire 교체");
				car.backRightTire = new KumhoTire("뒤왼쪽",13);
				break;
			case 4:
				System.out.println("뒤쪽 Tire 교체");
				car.backLeftTire = new Tire("뒤오른쪽",12);
				break;
			}
			System.out.println("=============================");
		}
	}

}
