package com.yedam.java.ch0606;
/*
 * 접근 제한자
 * 
 */
import com.yedam.java.ch0605.Car; //현재 패키지에 있지 않은 클래스 가져오기 (ctrl shift O)

public class MainTest {

	public static void main(String[] args) {
		Car myCar =  new Car("포르쉐");	//다른 패키지의 클래스 (ctrl shift O)
		myCar.run();
		
	}

}
