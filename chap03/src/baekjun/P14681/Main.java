package baekjun.P14681;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int x = Integer.parseInt(sc.nextLine());
		int y = Integer.parseInt(sc.nextLine());
		int n;
		if(x>0) {
			if(y>0) {
				n=1;
			}else n=4;
		}else {
			if(y>0) {
				n=2;
			}else n=3;
		}
		System.out.println(n);
	}

}
