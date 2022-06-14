package com.yedam.java.ch1201;

public class MultiThreadTest {

	public static void main(String[] args) {
		//작업하는 스레드 정보를 객체로 가져옴. 메인이든 작업스레드든 동작시점 스레드 정보 가져오는 메소드
		Thread main = Thread.currentThread(); 
		System.out.println("메인 스레드 : "+main.getName());	//메인 스레드 이름은 메인
//		Runnable a = new ThreadA();	//Runnable 구현
//		Thread thread = new Thread (a);
		ThreadB thread = new ThreadB(); //상속받은 자식클래스 이용
		thread.setName("threadA");		//setName으로 원하는 이름으로 바꿀 수 있음
		System.out.println("작업 스레드 : "+ thread.getName());//작업 스레드 Thread-0
		thread.start();
		
		for(int i=1;i<=5;i++) {
			System.out.println(i + "번째 출력");
			
			try {
				//중간에 일시적으로 스레드 중지
				Thread.sleep(500);	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
