package cmdNumGame;

/*
 * https://developer.mozilla.org/ko/docs/Learn/JavaScript/First_steps/A_first_splash
 */
import java.util.Scanner;

public class StartGame {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println("*GAME*START*");
			Game numGame = new Game();

			while (run) { // 10번동안 실행

				System.out.print("입력 > ");
				int num = Integer.parseInt(sc.nextLine());
				numGame.setGuessNum(num); // 입력한 숫자 기록

				if (num < numGame.getrand()) {
					System.out.println(num + " UP! ");
				} else if (num > numGame.getrand()) {
					System.out.println(num + " DOWN! ");
				} else {
					System.out.printf("\n**정답입니다!**\n시도횟수 : %d\n", numGame.getIndex());
					break;
				}
				if (numGame.getIndex() >= 10) {
					System.out.println("\n**********\n** FAIL **\n**********\n");
					run = false;
				}
			} // 한 게임 종료
			
			boolean run1=true;
			while (run1) {
				System.out.print("\n* ? TRY AGAIN ? * Y/N > ");
				
				switch (sc.nextLine()) {
				case "Y":
				case "y":
					System.out.println();
					run = true;
					run1= false;
					break;
				case "N":
				case "n":
					System.out.println();
					run = false;
					run1= false;
					break;
				default: System.out.println("잘못 입력했습니다.");
				}
			}
		} // 프로그램 종료
		System.out.println("**********\n***GAME*OVER***\n**********\n");
	}

}
