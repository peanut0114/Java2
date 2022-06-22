package com.yedam.app.common;

import java.util.Scanner;

import com.yedam.app.members.Member;
import com.yedam.app.members.MemberDAO;

public class LoginControl {

	//필드 - 종료 전까지 로그인 정보를 저장
	private static Member loginInfo = null	;//로그인정보 저장
	public static Member getLoginInof() {	//private로 숨겨두고 필요할때만 일시적으로 넘겨줌
		return loginInfo;					
	}	
	private Scanner sc = new Scanner(System.in);
	
	//생성자
	public LoginControl() {
		while(true) {
			menuPrint();
			
			int menuNo = menuSelect();
			
			if(menuNo==1) {
				//로그인
				login();
			}else if(menuNo==2) {
				//종료
				exit();
				break;
			}else {
				showInputError();
			}
			System.out.println();
		}
	}
	
	//메소드
	private void menuPrint() {
		System.out.println("==============");
		System.out.println(" 1.로그인 2.종료");	//로그인 하지 않고 이용하는 서비스 있을시 여기 추가
		System.out.println("==============");
	}
	private int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("숫자 형식으로 입력해주세요.");
		}
		return menuNo;
	}
	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

	private void showInputError() {
		System.out.println("메뉴를 확인해주시기 바랍니다.");
	}

	private void login() {
		//아이디와 비밀번호 입력
		Member inputInfo = inputMember();
		
		//로그인 시도 : 원래 필드 만들어서 사용했는데 반복사용하지 않으므로 이렇게 씀
		loginInfo = MemberDAO.getInstance().selectOne(inputInfo);	
		
		//실패할 경우 그대로 종료
		if(loginInfo ==null) return;
		
		//성공할 경우 프로그램 실행
		new Management().run();	//권한에 무관하게 일단 실행 
	}

	private Member inputMember() {
		Member info = new Member();
		
		System.out.print("아이디 > ");
		info.setMemberId(sc.nextLine());
		System.out.print("비밀번호 > ");
		info.setMemberPassword(sc.nextLine());
		
		return info;
	}

	
}
