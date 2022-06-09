package com.yedam.java.ch1501;
/*
 * 제네릭 타입 클래스
 */
public class Pair <K, V> {

	//필드
	private K key;
	private V value;
	
	//생성자
	public Pair(K key, V value) {	//생성자를 통해서도 값을 받을 수 있음
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
}
