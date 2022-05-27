package com.yedam.java.ch0802;
/*
 * vehicle을 상속하는 Texi
 */
public class Taxi implements Vehicle{

	@Override
	public void run() {		//사용방법 정의 중요  
		System.out.println("택시가 달립니다.");
	}

}
