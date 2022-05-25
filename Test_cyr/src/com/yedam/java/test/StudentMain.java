package com.yedam.java.test;

import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		boolean run = true;
		StudentSystem system = new StudentSystem();
		
		while(run) {
			system.menuSet();	//메뉴출력
			int n = Integer.parseInt(sc.nextLine());
			//학생정보 수 지정
			if(n==1) {
				System.out.print("학생 수 > ");
				system.listSize(Integer.parseInt(sc.nextLine()));
			}//학생정보 입력
			else if(n==2) {
				if(system.check()) {	//등록가능한 수를 넘어가는지 체크
					System.out.print("학번 > ");
					int num = Integer.parseInt(sc.nextLine());
					System.out.print("이름 > ");
					String name = sc.nextLine();
					System.out.print("점수 > ");
					int score = Integer.parseInt(sc.nextLine());
					system.makeList(num, name, score);
				}else {
					System.out.println("더이상 등록할 수 없습니다.\n");
				}
			}//학생정보 전체조회
			else if(n==3) {
				system.printList();
				System.out.println();
			}//학생정보 분석
			else if(n==4) {
				system.printResult();
			}//종료
			else if(n==5) {
				System.out.println("\n프로그램 종료");
				run=false;
			}else {
				System.out.println("다시 입력하세요.\n");
			}
		}
	}

}
