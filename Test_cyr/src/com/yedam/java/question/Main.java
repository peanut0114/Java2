package com.yedam.java.question;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("전월실적 >>");
		int record = scanner.nextInt();
		
		Member member = Member.getMemberShip(record);
		member.showMemberInfo();
		
		Payment myCard = null;
		if(member instanceof Gold) {
			myCard = new VIPcard();
		}else if(member instanceof Silver) {
			myCard = new GreenCard();
		}
		System.out.println("=== 등급에 따른 카드 사용시 결제 예상금액 ===");
		System.out.println("사용할 금액 >>");
		int price = scanner.nextInt();
		System.out.println("결제방법 : 1.오프라인, 2.온라인, 3.간편결제");
		System.out.printf("선택 >> ");
		int pay= scanner.nextInt();
		
		int result = 0;
		switch(pay) {
		case 1:
			result = myCard.offline(price);
			break;
		case 2:
			result = myCard.online(price);
			break;
		case 3:
			result = myCard.simple(price);
			break;
		}
		
		System.out.println("결제 예상 금액 : " + result);
		myCard.showCardInfo();

	}

}
