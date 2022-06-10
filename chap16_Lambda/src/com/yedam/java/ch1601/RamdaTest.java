package com.yedam.java.ch1601;
/*
 * MyFunInterface 시리즈 인터페이스 이용한 람다식
 */
public class RamdaTest {

	public static void main(String[] args) {
		
//매개변수도 리턴타입도 없는 람다식-----------------------------------------
		MyFunInterfaceA fa = () -> {	//실행블록 안에서는 원하는대로 입력
			String str = "method call A 1";
			System.out.println(str);
		};
		fa.method();
		
		fa = () -> { System.out.println("mathod call A 2"); };
		fa.method();
		//실행부분이 한줄이면 중활호 생략가능
		fa = () -> System.out.println("mathod call A 3");	
		fa.method();
		
		System.out.println();
		
//매개변수가 있고 리턴타입이 없는 람다식-------------------------------------
		 MyFunInterfaceB fb = (int x) -> {
			 int result = x*5;
			 System.out.printf("%d * 5 = %d\n",x,result);
		 };
		 fb.method(10);
		 
		 //인터페이스에 타입 있기때문에, 메소드에 타입을 빼고 매개변수만 입력가능
		 fb = (x) -> { System.out.println(x*5);};
		 fb.method(7);
		 
		 fb = x -> System.out.println(x*5);	//단순화
		 fb.method(7);
		 
		 System.out.println();
		 
//매개변수과 리턴타입이 있는 경우 -----------------------------------------
		 MyFunInterfaceC fc = (int x, int y) -> {
			 int result = x+y;
			 return result;
		 };
		 System.out.println(fc.method(1, 2));
		 
		 fc = (x,y) -> { return x+y; };
		 System.out.println(fc.method(5, 4));
		 
		 fc = (x,y) -> x+y;	//return 구문만 실행시키는 경우 표현식만 써도 됨
		 System.out.println(fc.method(5, 3));
		 
		 fc = (x,y) -> Math.max(x, y);	//기존 메소드 호출시 이렇게 사용 가능
//		 fc = (x,y) -> {				//정석형태
//			 //int result = Math.max(x, y);
//			 //return result;
//			 return Math.max(x, y);
//		 }
		 System.out.println(fc.method(2, 7));
		 
//주의사항(외부변수 사용)---------------------------------------------------
		 
		 int val1=10;
		 int val2=20;
		 
		 //람다식에서 외부변수를 가져올 경우 주소가 아닌 값만 가져옴
		 fa = () -> {
			 int result = val1+val2;	//외부 변수 가질 수 있음
			 System.out.println(result);//이때 외부변수는 final 값임
		 };
		 
		 //val1=100;	값 변경 불가(final)
		 fa.method();	//값이 변하면 결과가 달라질 수 있기 때문
		 
//스레드-----------------------------------------------------------
		 //러너블 구현하는 메소드가 하나
		 //람다식도 인터페이스 메소드가 하나
	}

}
