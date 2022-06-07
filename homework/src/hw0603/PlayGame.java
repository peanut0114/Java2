package hw0603;
//Q3 게임 돌아가는 과정 담은 클래스
import java.util.Scanner;

public class PlayGame {

	Scanner sc = new Scanner(System.in);
	private Keypad game;	//현재 게임 저장하는 필드
	boolean run = true;

	public PlayGame() { // 랜덤 초기화
		int n = (int) (Math.random() * 2); //0~1
		
		if (n == 0) {
			game = new ArcadeGame();
		} else {
			game = new RPGgame();
		}
	}

	public void mainProgram() {	//메소드부분을 생성자에 다 넣어도 괜춘

		while (run) {

			printMenu();				//메뉴출력
			int select = selectMenu();	//메뉴 입력

			if (select == 1) {			//기능별 실행
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
				printInputError();
			}
			System.out.println();
		}

	}

	private void printMenu() {
		System.out.println("=================================================================================");
		System.out.println("1.LeftUp |2.LeftDown |3.RightUp |4.RightDown |5.ModeChange |0.GameChange |9.EXIT");
		System.out.println("=================================================================================");
	}

	private int selectMenu() {	//NumberFormationException 실행 예외 처리
		try {
			System.out.printf("choice > ");
			return Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			return 7; // 입력오류 뜨는 int값으로 반환
		}
	}

	private void gameChange() {
		System.out.println();
		if (game instanceof RPGgame) {
			this.game = new ArcadeGame();
		} else if (game instanceof ArcadeGame) {
			this.game = new RPGgame();
		}
	}

	private void exit() {
		System.out.println("\nEXIT");
		run = false;
	}
	private void printInputError(){
		System.out.println("입력 오류");
	}
}
