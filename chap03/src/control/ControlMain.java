package control;

import java.util.Scanner;

public class ControlMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String grade;		//점수 입력
		int score ;			//등급
		
		//조건이 맞을 동안은 반복 실행
		do {
			//점수를 키보드로부터 입력받음
			score = Integer.parseInt(scan.nextLine());
			if (score==0)
				break;		//반복문을 빠져나감
			// 등급계산 조건문
			if (score >= 90) {
				grade = "A등급";
			} else if (score >= 80) {
				grade = "B등급";
			} else if (score >= 70) {
				grade = "C등급";
			} else
				grade = "D등급";
			//등급결과출력
			System.out.printf("%d점은 %s입니다.\n", score, grade);
		} while(true);		//while()이 참인 동안 반복
		System.out.println("프로그램 종료");
	}

}
