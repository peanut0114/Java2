package com.yedam.java.ch1101;

import java.util.Date;	//util 써야함

public class ToStringTest {

	public static void main(String[] args) {
		Object obj1 = new Object();
		System.out.println(obj1.toString());
		//toString : 자기 입맛대로 바꿈
		//java.lang.Object@3d012ddd -> 마지막 숫자는 메모리주소
		
		Date date = new Date();
		System.out.println(date.toString());
		
		Member member = new Member("홍길동");
		System.out.println(member);	//println이 자동으로 toString을 호출함
		System.out.println(member.toString()); //호출하나 변수만 던지나 동일
	}

}
