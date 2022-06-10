package baekjun.P2739;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		for(int i=1;i<=9;i++) {
//			System.out.printf("%d * %d = %d\n",n,i,n*i);
//		}
		
//10950
//		int count = sc.nextInt();
//		for(int i=1;i<=count;i++) {
//			System.out.println(sc.nextInt()+sc.nextInt());
//		}
//	

//2869
		int a = sc.nextInt();
		int b = sc.nextInt();
		int v = sc.nextInt();
		int day=1;
		int i=a;
		for(i=0; i<v ;) {
			i+=(a-b);
			day++;
		}
		System.out.println(day);
	}
}
