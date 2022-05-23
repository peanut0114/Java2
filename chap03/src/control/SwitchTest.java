package control;

import java.util.Scanner;

public class SwitchTest {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		//test1();
		//test2();		
		test3();
	}

	public static void test3() {
		int score = scan.nextInt();
		switch(score/10){				//10으로 나눈 몫으로 점수대 구분
		case 10:
		case 9: System.out.println("A등급"); break;	//90점대
		case 8: System.out.println("B등급"); break;	//80점대
		case 7: System.out.println("C등급"); break;
		default: System.out.println("D등급"); 
		}
	}
	
	public static void test2() {
		int menu = scan.nextInt();
		//1~5:평일, 6~7:주말
		switch (menu) {			//int, char, strign, 연산식 입력가능
		case 1 : 
		case 2 :
		case 3 :
		case 4 :
		case 5 : System.out.println("평일"); break;
		case 6 : 
		case 7 : System.out.println("주말"); break;
		default : System.out.println("잘못 입력했습니다.");
		}
	}	
	
	//break 유무
	public static void test1() {
//		int menu = scan.nextInt();
//		char menu = scan.next().charAt(0);	//첫번째 자리 한 글자만 읽어내기
		String menu = scan.next();			
		switch(menu) {						//int, char, string, 연산식
			case "부장" : System.out.println("700만원"); break;
			case "과장" : System.out.println("500만원"); break;
			default : System.out.println("기타"); 
		}
	}
}
