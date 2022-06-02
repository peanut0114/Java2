package com.yedam.java.ch1001;
/*
 * 예외처리 (Exception) 
 * 실행예외 -> 문법적으론 문제가 없지만 실제 실행시 발생하는 예외
 */
public class MainTest {

	public static void main(String[] args) {

// NullPointException : 접근한 변수가 null값
		String data = null; // 인스턴스가 없음 = 실행주체가 없음
		if (data != null) { // if문 예외처리
			System.out.println(data.toString()); // 도트 연산자(객체접근연산자) 사용 불가
		}

// ArrayIndexOutofBoundsException : 배열을 넘어선 값을 원할때
		if (args.length >= 2) { // 예외처리. 배열값이 2개 이상일때만
			String data1 = args[0];
			String data2 = args[1];

			System.out.println("args[0] : " + data1);
			System.out.println("args[1] : " + data2);
			// run Configuration -> Arguments에서 값을 넘겨줄 수 있음
		}

		/*
//NumberFormatException 
 			String data1 = "100"; 
 			String data2 = "a100";
		  	int value1 = Integer.parseInt(data1); 
		  	int value2 = Integer.parseInt(data2);
		  	int result = value1 + value2;
		 */

// ClassCastException : 타입변환 (상속,구현 관계에서 많이 발생)
		changeDog(new Dog());
		changeDog(new Cat()); 	// cat과 dog는 관계가 없음
								// cat을 dog로 타입변환 불가
	}

	public static void changeDog(Animal animal) {
		if (animal instanceof Dog) {	//예외처리 
			Dog dog = (Dog) animal; // animal이 dog로 바뀔 순 있음
			System.out.println(animal+"을 dog 형태로");
		}
	}

}

class Animal {} // 상속관계에 있는 클래스들
class Dog extends Animal {}
class Cat extends Animal {}
