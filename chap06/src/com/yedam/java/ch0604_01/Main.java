package com.yedam.java.ch0604_01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean run = true;
		Calculator cal = new Calculator();

		while (run) {
			System.out.println("1.숫자갯수|2.숫자입력|3.더하기|4.빼기|5.곱하기|6.나누기|7.종료");
			System.out.print("선택 > ");
			int menu = Integer.parseInt(sc.nextLine());
			
			if (menu == 1) {
				System.out.print("숫자 갯수 > ");
				int size = Integer.parseInt(sc.nextLine());
				cal.setArraySize(size);
			} else if (menu == 2) {
				System.out.print("숫자 입력 > ");
				int num = Integer.parseInt(sc.nextLine());
				cal.setNum(num);
			} else if (menu == 3) {
				cal.plus();
			} else if (menu == 4) {
				cal.minus();
			} else if (menu == 5) {
				cal.mult();
			} else if (menu == 6) {
				cal.divide();
			} else if (menu == 7) {
				run = false;
				System.out.println("종료합니다.");
			} else {
				System.out.println("잘못 입력했습니다.");
			}
		}
	}

}
