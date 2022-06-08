package hw0603;

//게임 돌아가는 과정 담은 클래스
import java.util.Scanner;

public class PlayGameQ3 {

	Scanner sc = new Scanner(System.in);
	Keypad game = null;
	boolean run = true;
	static int front;
	static int jump;

	PlayGameQ3() { // 랜덤 초기화
		int n = (int) (Math.random() * 2);
		if (n == 0) {
			game = new ArcadeGame();
		} else if (n == 1) {
			game = new RPGgame();
		}
		jump = front = 0;

		System.out.println();
	}

	public void mainProgram() {

		printMenu();
		while (run) {

			int select = selectMenu();

			if (select == 1) {
				game.leftUpButton();
			} else if (select == 2) {
				game.leftDownButton();
			} else if (select == 3) {
				game.rightUpButton();
			} else if (select == 4) {
				game.rightDownButton();
			} else if (select == 5) {
				game.changeMode();
			} else if (select == 0) {
				gameChange();
			} else if (select == 9) {
				exit();
			} else {
				System.out.println("입력 오류");
			}
			System.out.println();
		}

	}

	public void printMenu() {
		System.out.println("=================================================================================");
		System.out.println("1.LeftUp |2.LeftDown |3.RightUp |4.RightDown |5.ModeChange |0.GameChange |9.EXIT");
		System.out.println("=================================================================================");
	}

	public int selectMenu() { // NumberFormationException 실행 예외 처리
		try {
			System.out.printf("선택 > ");
			return Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			return 7; // 입력오류 뜨게 반환
		}
	}

	public void gameChange() {
		if (game instanceof RPGgame) {
			game = new ArcadeGame();
		} else if (game instanceof ArcadeGame) {
			game = new RPGgame();
		}
	}

	public void exit() {
		System.out.println("\nEXIT");
		run = false;
	}

	public void moveView() {
		for (int i = 0; i < front; i++) {
			System.out.print("  ");
		}
		System.out.println("★");
		for (int i = 0; i < jump; i++) {
			System.out.println();
		}
		System.out.println("-----------------");
	}

	public void plusPoint(int n) {
		if (n == 1) {
			if (game instanceof RPGgame) {
				jump++;
			} else {
				front++;
			}
		}else if(n==2) {
			if (game instanceof RPGgame) {
				jump--;
			} else {
				front--;
			}
		}else if(n==3) {
			
		}
	}

	public void minusPoint() {
		
	}
}