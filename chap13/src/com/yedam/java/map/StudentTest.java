package com.yedam.java.map;
/*
 * Student 클래스를 이용한 맵
 */
import java.util.HashMap;
import java.util.Map;

public class StudentTest {

	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<>();
		
		map.put(new Student(1,"홍길동"), 95);	//새 인스턴스 
		map.put(new Student(1,"홍길동"), 90);	//또 새 인스턴스 (메모리상 다른 위치)
											//해시코드에서 false인식
		System.out.println("총 Entry 수 : "+ map.size());		//오버라이딩 전 2개
		System.out.println("학번 : 1, 이름 : 홍길동, 성적 : "
		                  +map.get(new Student(1,"홍길동")));	//오버라이딩 전 성적 null (새 인트턴스)
		//세개가 제각각 new 연산자로 다른 인스턴스라 다르게 취급 됨 
		//-> Student 클래스의 이퀄즈, 해시코드 수정 (같은 값이면 같은 인스턴스라 인식하도록)
		//오버라이딩 후 entry 수 1개, 홍길동 성적이 들어간걸 볼 수 있음
		
		System.out.println();
		
		
		//변수 이용시 Student 오버라이딩 없이 원하는 결과를 얻을 수 있음 하지만 임시방편임
		Student s = new Student(1,"홍길동");
		map.put(s, 95);	
		map.put(s, 100);
		System.out.println("총 Entry 수 : "+ map.size());		
		System.out.println("학번 : 1, 이름 : 홍길동, 성적 : "+map.get(s));
		
	}
}
