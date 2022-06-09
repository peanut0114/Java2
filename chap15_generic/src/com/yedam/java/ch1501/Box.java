package com.yedam.java.ch1501;
/*
 * 제네릭타입 : 클래스, 인터페이스 등을 정의 할 때 기본 클래스 타입을 대체함
 * <> 안에 쓸만큼 적어 줌 (영문대문자, 개수 상관없음)
 * 
 * 타입을 대체할 수 있다는것 외에는 일반 클래스처럼 필드,생성자,메소드 다 가능
 */
public class Box<T, V, K> {
	T t;
	V v;
	K k;
	int num; 
	
	public void setT(T t) {
		this.t = t;
	}
	
	public T getT() {
		return t;
	}

	public V getV() {
		return v;
	}

	public void setV(V v) {
		this.v = v;
	}

	public K getK() {
		return k;
	}

	public void setK(K k) {
		this.k = k;
	}
	
	
}
