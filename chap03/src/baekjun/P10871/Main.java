package baekjun.P10871;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 유리천재
		// 유리바부
		Scanner scan = new Scanner(System.in);
		int n;
		int x;
		int num;	//�엯�젰諛쏆� �닽�옄 
		int i=1;	//諛섎났�슏�닔
		
		n = scan.nextInt();
		x = scan.nextInt();
		do {
			num=scan.nextInt();
			if(num<x) {
				System.out.print(num+" ");
			}
			i++;			
		}while(i<=n);
		//나도작업한다잉
		
	}

}
