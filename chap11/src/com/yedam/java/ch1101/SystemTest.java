package com.yedam.java.ch1101;
/*
 * 시스템클래스
 * currentRimeMillis(), nanoTime() : 현재 시각 읽기
 */
public class SystemTest {

	public static void main(String[] args) {

		long time1 = System.nanoTime();//코드 시작할 때 시간
		//얘를 처리하는동안 요청이 들어오면 시간이 늘어남 (일정한 시간 유지 x)
		int sum=0;	
		for(int i=1; i<=1000000; i++) {
			sum+=i;
		}
		long time2 = System.nanoTime();	//코드 끝날 때 시간
		System.out.println("1~1000000까지의 합 : "+sum);
		System.out.println("계산에 "+(time2-time1)+"나노초가 소요되었습니다.");
	}

}
