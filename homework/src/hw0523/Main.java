package hw0523;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean run = true;
		ScoreList abc = new ScoreList();
		
		while(run){
			System.out.println("\n1.학생수 입력|2.점수등록|3.점수전체조회|4.정보분석|5.종료");
			System.out.print("선택 > ");
			int menu = Integer.parseInt(sc.nextLine());
			if(menu==1) {
				System.out.print("학생 수 : "); 
				int size = Integer.parseInt(sc.nextLine());
				abc.getNum(size);
			}
			else if(menu==2){
				System.out.print("점수 입력 : "); 
				int num = Integer.parseInt(sc.nextLine());
				abc.getScore(num);
			}
			else if(menu==3){
				abc.viewScore();
			}else if(menu==4) {
				abc.result();
			}else if(menu==5) {
				run = false;
				System.out.println("\n종료합니다.");
			}else{
				System.out.println("다시 입력하세요.");
			}
			
		}		
	}	
}
