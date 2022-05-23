package memory;
/*
 * 180p
 */

public class ArrayTest {

	public static void main(String[] args) {

		int[] month = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
		//배열 객체를 생성 할 때에만 값을 한번에 넣을 수 있음. 
		
		//2월달의 마지막날은?
		System.out.println(month[1]);
		
		char[] week = {'월','화','수','목','금','토','일'};
						//new char[] 생략가능
		int[] score = new int[10];
		//score = {4,5,6,7,8} ; error
		score[0] = 100;	//하나하나 입력해야함		
		score = new int[] {1,2,3,4}; //새로 객체 만들면 한번에 입력가능
		
		
	}

}
