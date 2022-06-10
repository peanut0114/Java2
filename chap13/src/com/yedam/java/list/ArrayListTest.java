package com.yedam.java.list;
/*
 * 컬렉션 프레임 워크
 * List 컬렉션(인터페이스)을 구현하는 클래스 ArrayList
 * : 인덱스로 관리, 변경시 인덱스 자동 조정, 크기 자동 조정
 */
import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		//어떤 값을 할지 미리 넣어줌(String)
		//타입은 List인터페이스, 인스턴스는 arrayList
		List<String> list = new ArrayList<>();
		
		//add 값 추가 : 순차적으로 저장
		list.add("Java");			//0
		list.add("JDBC");			//1	
		list.add("Servlet/JSP");	//2 ->3
		list.add(2, "Database");	//2의 위치를 밀어내고 들어감 ->2
		list.add("iBATIS");			//4
		
		System.out.println("총 객체 수 : "+ list.size());	//size :크기
		System.out.println();
		
		String skill = list.get(2);	//get : 인덱스의 값 반환
		System.out.println("2 : " + skill);
		System.out.println();
		
		for (int i=0 ; i<list.size(); i++) {	//각 위치 출력
			System.out.println(i+" : "+list.get(i));
		}
		
		System.out.println();
		
		//remove : 제거
		list.remove(2);	//2번 자리 삭제 : Database
		list.remove(2);	//2번 자리 삭제 : Servlet/JSp 
		list.remove("iBATIS");	//iBATIS 삭제
		
		for(String data : list) {
			System.out.println(data);
		}
		
	}

}
