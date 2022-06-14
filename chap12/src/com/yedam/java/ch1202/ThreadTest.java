package com.yedam.java.ch1202;
/*
 * threadA
 */
public class ThreadTest {

	public static void main(String[] args) {
		ThreadA thread = new ThreadA();
		thread.start();
		
		try {
			Thread.sleep(1000);	//1초간 작동시킴
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thread.setStop(true);	//stop하겠다 넣으면 자동으로 stop
		
		System.out.println("----------------------------------");
		
		//익명자식객체
		Thread sub = new Thread() {
			
			@Override
			public void run() {
				while (true) {
					if(Thread.interrupted()) //sleep을 기다리지 않아도 됨
						break;
					System.out.println("===실행 중===");
				}
				System.out.println("==자원 정리==");
				System.out.println("==종료==");
			}
		};
		
		sub.start();
		try {
			Thread.sleep(500);	//0.5초간 실행
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sub.interrupt();
	}

}
