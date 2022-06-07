package com.yedam.java.ch1103.dateCalendar;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Date 클래스 : 전체출력. 한줄에 연도,월,일,시간 까지 한줄에 보여줌 (요즘 캘린더로 많이 넘어감)
 *				 new 연산자로 생성사 호출 당시의 정보가 묶임 (정보 저장용으로 쓰임)
 * Calendar 클래스 : 각각의 개별정보를 꺼내옴 (날짜 조작할 때 많이 사용)
 *
 */
public class dateTest {
	public static void main(String[] args) {
		Date now = new Date();	//외국형식
		System.out.println(now);	

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		
		String result = sdf.format(now);
		System.out.println(result);
		
	}
}
