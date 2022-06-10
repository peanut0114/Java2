package com.yedam.java.ch1601;
/*
 * 람다식 문법 이용하려함
 * 
 * 반드시 하나의 메소드만 포함하고 있어야 함
 * 함수가 여러개면 어느 함수를 지정할 지 알 수 없게 되기 때문
 */

@FunctionalInterface	//람다식문법 쓸 가능성 있는 애임 (함수 생성 개수 제한함)
						//하지만 항상 람다식으로만 쓰도록 제한하지는 않음! 메소드만 제한
public interface MyFunctionalInterface {

	public void method();
	//public void method2();
	
}
