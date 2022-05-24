package com.yedam.java.ch0605;

public class CarTest {

	public static void main(String[] args) {

		//CarTest ct = new CarTest();	//생성자 만들어서
		//ct.print();					//public void print() 호출가능
		print();
		Car myCar = new Car("포르쉐");
		Car yourCar = new Car("벤츠");
		
		myCar.run();
		System.out.println(yourCar.speed);
		yourCar.run();
	}
	
	public  static void print() {	//정적 메소드 : 필드가 필요없을때 주로 사용(출력, 랜덤 등)
		System.out.println();		//system클래스의 필드에 있는 out클래스, 그 안의 println메소드 호출
	}

}
