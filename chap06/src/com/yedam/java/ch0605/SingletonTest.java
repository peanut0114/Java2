package com.yedam.java.ch0605;

public class SingletonTest {

	public static void main(String[] args) {

		//Singleton obj1 = new Singleton(); //보이지않음
		Singleton obj1 = Singleton.getInstance();	//메소드로 접근
		Singleton obj2 = Singleton.getInstance();	//여러번 불러도 하나의 인스턴스에 접근
		
		if(obj1==obj2) {
			System.out.println("같은 Singleton 객체입니다.");
		}else {
			System.out.println("다른 Singleton 객체입니다.");
		}
		
	}

}
