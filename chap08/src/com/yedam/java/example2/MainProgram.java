package com.yedam.java.example2;

import java.util.Scanner;

public class MainProgram {

	// 필드
	private Scanner sc = new Scanner(System.in);
	private Access dao = StudentRepo.getInstance(); // 저장소. dao : 데이터 오브젝트레포트 -db에 대응되는.. 광용적 사용...
	private Program pro = new StudentProgram();	//인터페이스추가

	// 생성자
	public MainProgram() {
		while (true) {
			// 메뉴출력
			pro.menuPrint();
			// 메뉴선택
			int menuNo = menuSelect();
			// 각 메뉴 실행
			if (menuNo == 1) {
				pro.inputInfo(dao);
			} else if (menuNo == 2) {
				pro.printAllInfo(dao);
			} else if (menuNo == 3) {
				pro.printInfo(dao);
			} else if (menuNo == 4) {
				pro.printRepot(dao);
			}else if(menuNo==5) {
				exit();
				break;
			} else {
				System.out.println("잘못 입력했습니다.");
			}
			System.out.println();
		}
	}

	// 메소드
	public int menuSelect() {
		System.out.print("선택 > ");
		return Integer.parseInt(sc.nextLine());
	}

	public void exit() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	
}
