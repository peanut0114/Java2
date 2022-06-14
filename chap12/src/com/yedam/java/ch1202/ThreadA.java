package com.yedam.java.ch1202;

public class ThreadA extends Thread {//thread를 상속받는 자식클래스
	public boolean stop;
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop) {
			System.out.println("실행 중");
		}
		System.out.println("\n자원 정리");
		System.out.println("종료");
	}	
	
}
