package com.yedam.java.ch1201;

public class ThreadA implements Runnable {

	@Override
	public void run() {
		for(int i=1;i<=5;i++) {
			System.out.println("현재 순서 : "+i);
			try {
				//중간에 일시적으로 스레드 중지
				Thread.sleep(500);	//ms단위 =0.5초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}


}
