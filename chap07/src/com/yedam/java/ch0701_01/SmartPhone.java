package com.yedam.java.ch0701_01;
/*
 * 폰을 상속중
 */
import com.yedam.java.ch0701.Phone;

public class SmartPhone extends Phone {

	//폰을 상속하려면 이 형태의 생성자는 필수!
	public SmartPhone(String model, String color) {
		super(model, color);
	}


	@Override
	public void bell() {	
		super.bell();
		System.out.println("벨 소리 : 싸이 - that that!");
	}

/*	
	@Override
	void call() {
		super.call();
		System.out.println("안내 문구 : 전화는 용건만 간단히");
	}
*/
	void print() {
		super.bell();
	}

}
