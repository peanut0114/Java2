package com.yedam.java.ch1201;
/*
 * 실제 동작 => 충돌생김
 */
public class UserTest {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		User user1 = new User();
		user1.setCalculator(cal);
		user1.start();
		//유저1 : User100 메모리 200 
		
		User user2 = new User();
		user2.setCalculator(cal);	//위 결과 뜨기 전에 얘가 먼저 실행되어버림
		user2.start();
		//유저2 : User200 메모리 300
	}
	
/*	동기화 전에 돌려보면 예상값과 다른 결과가 출력됨
 * 
 * 	현재 스레드 : User100 , memory : 300
	현재 스레드 : User200 , memory : 300
	: 동시에 같은 스레드를 사용중
		유저1이 cal 인스턴스 메모리에 100넣고 sleep했을때 일시적으로 스레드 잠시 멈춤 (출력 전)
		유저2가 등장하면서 값을 300으로 바꾸고 본인 동작을 멈춤
		
		유저1이 살아나서 cal의 메모리 값을 가져옴
		유저2도 살아나서 지금 cal의 메모리값 가져와서 출력
		
	스레드는 흘럭는 흐름, 메모리상의 값을 넣거나 불러오거나 하는것 인스턴스와 따로 돌아가는것
	멀티스레드는 하나의 메모리에 여러 스레드가 접근 가능해서 예상 결과값이 달라질 수 있음
	환경에 따라 동인한 결과가 나오지 않는다면 문제가 생김!!! => 동기화 이용
 */
	

}
