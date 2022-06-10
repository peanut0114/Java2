package com.yedam.java.set;
/*
 * Set 컬렉션(인터페이스)을 구현하는 클래스 HashSet
 * set은 인덱스x, 순서X, 중복x
 */
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StringTest {

	public static void main(String[] args) {
		//타입은 Set, 인스턴스는 HashSet
		Set<String> set = new HashSet<>();
		
		//5개의 값 추가
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");		//중복저장 : 하나로 인식
		set.add(new String("Java"));//Java를 또 넣고 싶어서 new연산자로 새 인스턴스 만들었음 근데 또 중복으로 처리됨
									//비교하는 부분인 String의 해시코드와 이퀄스를 보니 내부 값으로 비교하게 되어있음
		set.add("iBATIS");
		
		System.out.println("총 객체 수 : "+ set.size());
		System.out.println();
		
		//구분자. set 컬렉션 안에 든것과 동일한 타입 줘야함
		Iterator<String> iterator = set.iterator();
		
		//출력은 보통 while문. hasNext()로 다음 값이 있는지 확인 
		while(iterator.hasNext()) {	
			String element = iterator.next(); //순서는 따로 없음
			System.out.println("\t"+element);
		}
		System.out.println();
		
		//제거는 원하는 값 자체를 지정
		set.remove("JDBC");
		set.remove("iBATIS");
		
		//향상된 for문으로 출력 (구분자 안 써도 출력 가능)
		for(String data : set) {
			System.out.println(data);
		}
		
		System.out.println();
		
		set.clear(); //내부의 모든 데이터 제거
		if(set.isEmpty()) {	//내부의 값이 있는지 없는지 체크하는 불린메소드
			System.out.println("텅텅 비어있음");
		}
	}

}
