package com.yedam.java.ch1202;

import java.util.Scanner;

public class PrintThreadTest {
	public static void main(String[] args) {
//		new PrintThread().start();
		Thread jobThread = new PrintThread();
		jobThread.start();
		
		//0이 아닌 수 입력시 프로그램 종료
		System.out.println("프로그램을 종료하시겠습니까?");
		
		int result = new Scanner(System.in).nextInt();
		if(result>0) {
			jobThread.interrupt();	//인터럽트를 걸어줌
		}
	}
}
