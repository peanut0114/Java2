package array;

import java.util.Scanner;

public class MainApp {

	// 배열선언
	static int[] scores; // int scores[]; 와 같음
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("값을 입력합니다.\n");
		init(); // 배열생성과 초기화
		int menu;
		// 반복문
		do {
			// 메뉴출력
			System.out.println("\n1.전체출력 2.최솟값 3.최댓값 4.평균 5.종료");
			System.out.print("번호 선택 > ");
			// 메뉴입력
			menu = scan.nextInt();

			switch (menu) {
				case 1:
					printAll(); // 전체출력
					break;
				case 2:
					findMin();
					break;
				case 3:
					findMax();
					break;
				case 4:
					findAvg();
					break;
				case 5:
					break;
				default:
					System.out.println("잘못 입력했습니다.");
					break;
			}
		} while (menu!=5);
		
		System.out.println("\n**종료합니다.**");
	}

	public static void init() {
		// 배열생성
		scores = new int[10]; // 공간확보 10칸 (0~9)
								// 힙 영역에 저장된 배열(new) 초기값은 0
		// 배열초기화
		for (int i = 0; i < 10; i++) {
			scores[i] = scan.nextInt();
		}
	}

	public static void printAll() {
		// 배열값조회
		for (int i = 0; i < 10; i++) {
			System.out.print(scores[i] + " ");
		}
		System.out.println();
		// 2번학생 *배열은 0부터 시작이므로 scores[2] x
		// System.out.printf("두번째 학생은 %d점입니다.\n",scores[1]);
	}

	public static void findMin() {
		// 최솟값
		int min = scores[0];
		for (int i = 1; i < 10; i++) {
			if (scores[i] < min) {
				min = scores[i];
			}
		}
		System.out.printf("최솟값은 %d점입니다.\n", min);
	}

	public static void findMax() {
		// 최댓값
		int max = scores[0];
		for (int i = 1; i < 10; i++) {
			if (scores[i] > max) {
				max = scores[i];
			}
		}
		System.out.printf("최댓값은 %d점입니다.\n", max);
	}

	public static void findAvg() {
		// 평균
		int totalS = 0;
		for (int i = 0; i < 10; i++) {
			totalS += scores[i];
		}
		double avg = totalS / (double) 10; // = totalS/10.0
		System.out.printf("평균은 %.2f점입니다.\n", avg);
	}

}
