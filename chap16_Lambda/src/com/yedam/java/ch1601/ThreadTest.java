package com.yedam.java.ch1601;

public class ThreadTest {

	public static void main(String[] args) {
		//runnable 인터페이스에도 메소드 딱 하나 : 람다식 가능
		//1. 변수 이용
		Runnable rn = () -> {
			System.out.println("람다식으로 구현");
			for(int i=0;i<10;i++) {
				System.out.println(i);
			}
		};	//익명구현객체
		
		Thread thread = new Thread(rn);//매개변수로 runnable 와야 함
		thread.start();
		
		//2. 변수 없이 (매개변수 자리에 바로 람다식)
		thread = new Thread( ()->{
			System.out.println("매개변수 <= 람다식");
			for(int i=0 ; i<10 ; i++) {
				System.out.println("두번째 "+i);
			}
		});
		thread.start();
	}

}
