package com.yedam.java.example1;

import java.util.Scanner;

public class SchedulerSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("전화 상담 할당 방식을 선택하세요.");
			System.out.println("R : 한명씩 차례대로 할당");
			System.out.println("L : 쉬고 있거나 대기가 가장 적은 상담원에게 할당");
			System.out.println("P : 우선 순위가 높은 고객 먼저 할당");
			System.out.println("E : 종료");
			//선택
			System.out.println("Setting > ");
			String ch = sc.next();
			
			Scheduler scheduler =null;
			
			if("R".equals(ch) || "r".equals(ch)) {
				scheduler = new RoundRobin();
			}else if("L".equals(ch) || "l".equals(ch)){
				scheduler = new LeastJob();
			}else if("P".equals(ch) || "p".equals(ch)){
				scheduler = new PriorityAllocation();
			}else if("E".equals(ch) || "e".equals(ch)){
				System.out.println("프로그램 종료");
				break;
			}else {
				System.out.println("지원되지 않는 기능입니다.");
			}
			
			scheduler.getNextCall();
			scheduler.sendCallToAgent();
			
			System.out.println();
		}
	}


}
