package com.yedam.java.ch1201;
/*
 * 스레드
 * 메인이 하나의 스레드 -> 자바가 만드는 거라 직접 제어하는게 어려움
 */
public class MainThreadTest {

	public static void main(String[] args) {
		for(int i=1;i<=5;i++) {
			System.out.println("현재 순서 : "+i);
			
			try {
				//중간에 일시적으로 스레드 중지
				Thread.sleep(500);	//ms단위 =0.5초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
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
