package control;

import java.util.Scanner;

public class GuessNumber {

	public static void main(String[] args) {

		int rand = (int) (Math.random() * 10) + 1; // 1~10난수
		int num; // 유저가 입력하는 값
		String result;
		int count = 0;
		Scanner scan = new Scanner(System.in);

		// 반복
		do {
			//시도 횟수가 5회 이상이면 게임 종료
			count++;
			if (count>5) {
				System.out.println("실패~~~~");
				break;
			}
			// 키보드 정수값을 읽어서 num 변수에 저장
			num = Integer.parseInt(scan.nextLine());

			if (rand > num)
				result = "크다";// rand>num "크다"출력

			else if (rand < num)
				result = "작다";// rand<num "작다"출력

			else {
				System.out.println("***정답!***");
				break;// rand==num break
			}
			System.out.printf("%d보다 %s\n", num, result);
		
		} while (true);
		System.out.println("-게임 종료-");
	}

}
