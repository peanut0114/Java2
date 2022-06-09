package com.yedam.java.ch1501;
/*
 * 전체적으로 제네릭 타입 사용 X
 * 제네릭 메소드 O
 */
public class Util {  
	//리턴 타입 앞에 제네릭 쓰겠다고 꺽쇠 추가, 매개 변수 안에 그 제네릭 타입 입력
	public static <T> BoxA<T> boxing(T t){
		//매개변수 타입 T가 전부 영향 줌
		BoxA<T> box = new BoxA<>();
		box.set(t);
		return box;
	}
	
	//매개변수로 제네릭 타입 클래스 2개를 받는 불린타입 메소드
	public static <K, V> boolean compare(Pair<K,V> p1, Pair<K,V> p2) {
			//여기 쓴 K,V값만 	  			여기 K,V 타입 넣을 수 있음
		
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		//equals를 사용하기 위해 generic 타입이 클래스나 인터페이스 타입이 되어야 함
		//오브젝트에 있는 equals, override해주는게 좋음??
		return keyCompare && valueCompare;
	}
	
	public static <K, V> V printInfo (K key) {
		V v = null;
		return v;
	}
}
