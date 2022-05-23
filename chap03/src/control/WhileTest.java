package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WhileTest {

	public static void main(String[] args) throws FileNotFoundException {
		
		//while1();
		//for1();
		//for2();
		//gugudan1();
		//findMax();		//최댓값
		//findMin();		//최솟값
		findMinMax();
	}
	
	//최댓값 최솟값 구하기
	public static void findMinMax() throws FileNotFoundException {
		//파일에서 입력받을 것임
		Scanner scan = new Scanner(new File("score.txt"));
		int min = scan.nextInt();		//첫번째 숫자를 입력받아 min값 넣기
		int max = min;
		for (int i=1;i<=9;i++) {
			int num=scan.nextInt();
			if(num<min)		//작은 수보다 작으면 min 변수에 저장
				min=num;
			if(num>max)		//큰 수보다 크면 max 변수에 저장
				max=num;
		}
		System.out.printf("최솟값=%d, 최댓값=%d",min,max);
	}
	
	//최솟값 구하기
	public static void findMin() throws FileNotFoundException {
		Scanner scan = new Scanner(new File("score.txt"));
		int min= scan.nextInt();		//첫번째 숫자를 입력받아 min값 넣기
		for (int i=1;i<=9;i++) {
			int num=scan.nextInt();
			if(num<min)
				min=num;
		}
		System.out.printf("최솟값=%d",min);
	}
	
	//최댓값 구하기
	public static void findMax() throws FileNotFoundException {
		//10번 반복
		Scanner scan = new Scanner(new File("score.txt") );
		int max = 0;
		
		for(int i=0 ; i<10; i++) {
			int num = scan.nextInt(); //숫자를 입력
			if(num>max) {
				max=num;
			}
		}
		System.out.println("최댓값="+ max);//60보다 크면 출력				
	}
	
	//구구단 5단 5*1~5*9까지
	public static void gugudan1() {
		Scanner scan = new Scanner(System.in);
		int dan = scan.nextInt();
		for (int i=1;i<=9;i++) {
			System.out.printf("%d*%d=%d\n",dan,i,dan*i); //5*1=5
		}
		
	}
	//10~1 출력
	public static void for2() {
		for(int i=10; i>0 ;i-=1) {
			System.out.println("반복"+i);
		}
	}
	
	//1부터 10까지 반복 : for
	public static void for1() {
		for( int i=1;i<=10 ;i+=2 ) {
			System.out.println("반복"+i);
		}
	}
	
	//1부터 10까지 반복 : do-while
	public static void while1() {
		int count = 1;
		do {
			System.out.println(count);
			count++;			
		} while(count<=10);		
	}
}