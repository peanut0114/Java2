package array;
/*
 *	숫자맞추기
 *	입력했던 숫자들도 출력하기
 */

import java.util.Scanner;

public class GuessNum2 {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int rand = (int) (Math.random()*10)+1;
		int[] num = new int[10];
		int counter = 1;
	
		for (int i=0 ; i<10 ; i++) {
			
			System.out.print("\n숫자 입력 :");		//추측하는 숫자 입력받기
			num[i] = scan.nextInt();
			
			if (num[i]<rand) {
				System.out.printf("%d보다 큽니다.\n",num[i]);
			}
			else if (num[i]>rand) {
				System.out.printf("%d보다 작습니다.\n",num[i]);
			}
			else {
				System.out.println("**정답입니다!** "+rand);
				break;
			}
			
			System.out.print("\n기록 > ");
			
			for (int j=0 ; j<counter ; j++) {	//입력한 숫자 출력
				System.out.print(num[j]+" ");	
			}
			
			counter++;
		}
		if (counter>10)
			System.out.println("\n~~~~~실패~~~~~~");
		System.out.println("게임을 종료합니다.");
	}
}
