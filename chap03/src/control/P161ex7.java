package control;

import java.util.Scanner;

public class P161ex7 {

	public static void main(String[] args) {
		boolean run = true;
		int balance = 0;

		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("\n-------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-------------------------------");
			System.out.print("선택> ");
			int num = scan.nextInt(); // 번호선택받음

			if (num == 1) {				//1. 예금
				System.out.print("예금액 : ");
				balance += scan.nextInt();
			} 
			else if (num == 2) {		//2. 출금
				System.out.print("출금액 : ");
				int m = scan.nextInt();
				if (m > balance) { // 잔고 확인
					System.out.println("잔액이 부족합니다.");
				} else {
					balance -= m;
				}
			} else if (num == 3) {
				System.out.println("잔고 : " + balance);
			} else if (num == 4) {
				break;
			} else {
				System.out.println("\n잘못된 선택입니다.");
			}
		} while (run);
		System.out.println("\n***종료합니다.***");
	}

}
