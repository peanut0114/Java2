package baekjun.P10430;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
//		int a=scan.nextInt();
//		int b=scan.nextInt();
//		int c=scan.nextInt();
//		
//		System.out.println((a+b)%c);
//		System.out.println(((a%c)+(b%c))%c);
//		System.out.println((a*b)%c);
//		System.out.println(((a%c)*(b%c))%c);
		
		int len= scan.nextInt();	
		int sum=0;
		double num= scan.nextDouble();
		double a=1;
		int b=0;
		for(int i=len;i>0;i--) {
			for(int j=1;j<i;j++) {
				a*=10;
			}
			b=(int) (num/a);
			sum+=b;
			num-=b*a;
			a=1;
		}	
			System.out.println(sum);
	}
		
}
