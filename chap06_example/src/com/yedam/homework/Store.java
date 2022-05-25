package com.yedam.homework;

import java.util.Scanner;

public class Store {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ProductSystem ps = new ProductSystem();
		boolean run = true;

		while (run) {
			System.out.println("------------------------------------------------");
			System.out.println("1.상품 수|2.상품 및 가격 입력|3.제품별 가격|4.분석|5.종료");
			System.out.print("선택 > ");
			int n = Integer.parseInt(sc.nextLine()); // nextLine과 다른 next시리즈 혼용사용X
			// nextInt,double 등등 : enter 전까지의 입력 가져감. enter가 무시되어 계속 남아있음 (혼용가능)
			// nextLine : enter를 포함한 데이터를 읽음. 위에 남은 enter읽어버림 > 공백가져감 (최대한 혼자쓸것)

			if (n == 1) {
				System.out.print("상품 수 > ");
				ps.setListSize(Integer.parseInt(sc.nextLine()));
			} else if (n == 2) {
				if (ps.check()) {
					System.out.print("상품명 > ");
					String name = sc.nextLine();
					System.out.print("가격 > ");
					int price = Integer.parseInt(sc.nextLine());
					ps.putProduct(name, price);
				} else {
					System.out.println("더이상 추가할 수 없습니다.");
				}
			} else if (n == 3) {
				ps.printList();
			} else if (n == 4) {
				ps.printTotal();
			} else if (n == 5) {
				run = ps.finish();
			} else {
				System.out.println("잘못 입력했습니다.");
			}
		}
	}
}
