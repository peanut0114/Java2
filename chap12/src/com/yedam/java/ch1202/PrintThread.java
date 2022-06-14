package com.yedam.java.ch1202;

public class PrintThread extends Thread {// thread를 상속받는 자식클래스

	@Override
	public void run() {
		
//		// 1. 외부에서 인터럽트 발생시 작업 스레드를 종류시킬 경우
//		try {
//			while (true) { // 무한반복 스레드
//				System.out.println("실행중");
//				Thread.sleep(1000);
//			}
//		} 
//		//외부에서 인터럽트를 걸 경우
//		catch (InterruptedException e) {	//내부에 sleep 있는 경우 발생시키는것
//			System.out.println("interrupt method 실행");
//		}
//		System.out.println("자원 정리");
//		System.out.println("종료");
//		
		
		//2. 작업중 일시적인 추가작업이 필요한 경우
		//인터럽트가 들어가도 종료시키지 않으려면 while문 안에 try catch를 넣어줌
		while (true) {
			System.out.println("실행중");
			try {
				Thread.sleep(1000);
			}
			// 외부에서 인터럽트를 걸 경우
			catch (InterruptedException e) { 
				System.out.println("interrupt method 실행");
			}
		}
	}

}
