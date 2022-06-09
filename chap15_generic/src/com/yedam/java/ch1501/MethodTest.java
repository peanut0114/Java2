package com.yedam.java.ch1501;

public class MethodTest {
	public static void main(String[] args) {
/*		Util.<Integer>boxing(100); //원래 메소드 앞에 타입 적어줘야함
		Util.boxing(100);	
		//util은 타입도 하나라서.. 매개변수 값(100)을 이용해서 타입 안 써도 int로 유추함
*/		
		//리턴타입 변수에 넣어준다
		BoxA<Integer> intValue = Util.boxing(100);
		
		Pair<Integer, String> p1 = new Pair<>(1,"사과");
		Pair<Integer, String> p2 = new Pair<>(1,"사과");
		
		boolean result1 = Util.<Integer, String>compare(p1, p2);
		if(result1) {
			System.out.println("논리적으로 동등한 객체입니다.");
		}else {
			System.out.println("논리적으로 동등하지 않습니다.");
		}
		
		Util.<String, Integer> printInfo("홍길동");
	}
}
