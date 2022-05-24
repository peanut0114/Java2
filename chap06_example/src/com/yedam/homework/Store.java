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
			int n = Integer.parseInt(sc.nextLine());
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
				}else {
					System.out.println("더이상 추가할 수 없습니다.");
				}
			} else if (n == 3) {
				ps.printList();
			} else if (n == 4) {
				ps.printTotal();
			} else if (n == 5) {
				ps.finish();
				break;
			} else {
				System.out.println("잘못 입력했습니다.");
			}
		}
	}
}
