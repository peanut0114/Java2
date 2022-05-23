package com.yedam.jave.ch0604;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {

		boolean run = true;
		Scanner sc = new Scanner(System.in);
		Program program = new Program();
		
		while(run) {
			System.out.println("---------------------------------------");
			System.out.println(" 1.학생수|2.점수입력|3.점수리스트|4.분석|5.종료 ");
			System.out.println("---------------------------------------");
			System.out.print("선택 > ");
			int menu = Integer.parseInt(sc.nextLine());
			
			if(menu == 1) {
				System.out.print("학생 수 > ");
				int student = Integer.parseInt(sc.nextLine());
				program.setNum(student);
			}else if(menu==2) {
				System.out.print("점수 > ");
				int score =  Integer.parseInt(sc.nextLine());
				program.setScore(score);
			}else if(menu==3) {
				program.printScores();
			}else if(menu==4) {
				program.printResult();
			}else if(menu==5) {
				run=false;
				System.out.println("\n프로그램 종료");
			}
		}
		
		}
	

}
