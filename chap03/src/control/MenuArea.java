package control;

import java.util.Scanner;

/*
 * 1. 사각형	2. 삼각형	0. 종료
 */

public class MenuArea {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int menu;
		//반복
		do {
			menu = Integer.parseInt(scan.nextLine());	//menu 입력
			
			if (menu==0)
				break;
			if (menu==1) {
				System.out.println("사각형"); //1이면 "사각형" 출력
			}
			else if(menu==2 ) {
				System.out.println("삼각형"); //2이면 "삼각형" 출력
			}
			else
				System.out.println("다시 입력 하십시오.");
		}while(true);
		
		System.out.println("프로그램종료");
	}

}
