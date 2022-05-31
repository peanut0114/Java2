package hw0527_ver2;

import java.util.Scanner;

public class MainProgram {

	Scanner sc = new Scanner(System.in);
	Program pro = new BookProgram();

	public MainProgram() {
		while (true) {
			pro.menuPrint();
			int n = select();
			if (n == 1) {
				pro.inputInfo();
			} else if (n == 2) {
				pro.printAllInfo();
			} else if (n == 3) {
				pro.printInfo();
			} else if (n == 4) {
				pro.printReport();
			} else if (n == 5) {
				exit();
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
			System.out.println();
		}
	}

	public int select() {
		System.out.print("선택 > ");
		return Integer.parseInt(sc.nextLine());
	}

	public void exit() {
		System.out.println("\n프로그램을 종료합니다.");
	}
}
