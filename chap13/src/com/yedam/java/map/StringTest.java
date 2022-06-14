package com.yedam.java.map;
/*
 * 컬렉션 프레임워크
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StringTest {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		//타입은 맵, 키: 스트링, 값: 인테테져 = 인트턴스 구현클래스: 해쉬맵
		map.put("시윤권", 85); //값을 집어넣는건 put뿐
		map.put("홍길동", 90);
		map.put("동장군", 80);
		System.out.println("총 Entry 수 : "+map.size());//2개의 클래스를 한 쌍으로 가진 객체 entry
		
		//put은 값을 넣는것만이 아니라 리턴값을 이용해 있던 값을 덮어씌운건지 빈공간에 넣은건지 판별 가능
		Integer returnVal = map.put("홍길동", 100);	//put하면 기존 값이 리턴되어 나옴 (비어있었으면 널)
													//기존 값 상관없이 무조건 새 값은 입력됨
		if(returnVal != null) {	 					//add도 리턴값 있다는데.. 쓸 일은 없을듯..?
			System.out.println("기존 값 : "+returnVal);
		}
		System.out.println("\t홍길동 : "+map.get("홍길동"));
		System.out.println();
		
		//set : 중복되지 않는 구성 이용 (반복자while을 쓰든 for문을 쓰든 Set써야함)
		//1) keySet을 이용
		Set<String> keySet = map.keySet(); 
		Iterator<String> keyIterator = keySet.iterator(); 	// 반복자 이터레이터 이용
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			Integer value = map.get(key);
			System.out.println("\t"+key+" : "+value);
		}
		System.out.println();	
		
		for(String key : keySet) {							//향상된 for문 이용
			Integer value = map.get(key);
			System.out.println("\t"+key+" : "+value);
		}
		System.out.println();
		
		//제거
		map.remove("홍길동");	//키 기준
		
		//값 : 중복된 상태
		//2) entrySet 이용
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		while(entryIterator.hasNext()) {	//반복자를 통한 while
			Map.Entry<String, Integer> entry = entryIterator.next();	//entry를 먼저 끄집어냄
			
			String key = entry.getKey();		//키과
			Integer value = entry.getValue();	//값을 꺼냄
			System.out.println("\t"+key+" : "+value);
		}
		System.out.println();
		
		for(Map.Entry<String, Integer> entry : entrySet) {	//향상된 for문 사용
			String key = entry.getKey();		//키과
			Integer value = entry.getValue();	//값을 꺼냄
			System.out.println("\t"+key+" : "+value);
		}
	}

}
