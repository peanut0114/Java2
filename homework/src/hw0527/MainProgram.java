package hw0527;

import java.util.Scanner;

public class MainProgram {

	Scanner sc = new Scanner(System.in);
	Access re = BookDAO.getInstance();
	BookProgram pro = new BookSystem();

	public MainProgram() {
		while (true) {
			pro.menuPrint();
			int n = select();
			if (n == 1) {
				pro.insertInfo(re);
			} else if (n == 2) {
				pro.printAllInfo(re);
			} else if (n == 3) {
				pro.printInfo(re);
			} else if (n == 4) {
				pro.printReport(re);
			} else if (n == 5) {
				pro.updateInfo(re);
			} else if (n == 6) {
				pro.deletInfo(re);
			} else if (n == 7) {
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
