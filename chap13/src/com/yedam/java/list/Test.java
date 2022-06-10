package com.yedam.java.list;
//왜 String이 set에서 중복 입력이 안 되나
import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		String data1 = "Java";
		String data2 = new String("Java");
		
		if(data1 == data2) {
			System.out.println("서로 같은 객체");
		}else
			System.out.println("서로 다른 객체"); //등호 연산자에선 다른 객체로 인식 (주소분석)
		
		Set<String> set = new HashSet<>();
		set.add(data2);
		set.add(data1);
		
		System.out.println("총 객체 수  : "+set.size());	
		//String 의 equals는 내부 값이 같은면 같은 값이라 처리하게 오버라이딩 되어있어
		//같은 값을 두번 넣기 불가능 (set은 중복입력 불가)
	}

}
