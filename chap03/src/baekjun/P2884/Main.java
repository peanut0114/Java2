package baekjun.P2884;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
			int h = scan.nextInt();
			int m = scan.nextInt();
			if (m<45) {
				m+=15;
				h-=1;
			}
			else
				m-=45;
			if(h<0)
				h+=24;
			System.out.printf("%d %d",h,m);
	}

}
