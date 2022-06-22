package com.yedam.app.common;
import java.util.Scanner;

import com.yedam.app.deal.ProductStockManagement;
import com.yedam.app.deal.ReceivingGoodsDAO;
import com.yedam.app.deal.TakeOutGoodsDAO;
import com.yedam.app.product.ProductDAO;
import com.yedam.app.product.ProductInfoManagement;
/*
 * 재고관리 클래스
 * 로그인 권한에 따른 접근 분류
 */
public class Management {

	//필드
	protected Scanner sc = new Scanner(System.in); //상속가능성 ->protected
	protected ProductDAO pDAO = ProductDAO.getInstance();
	protected ReceivingGoodsDAO rDAO = ReceivingGoodsDAO.getInstance();	//만들예정인 클래스
	protected TakeOutGoodsDAO tDAO = TakeOutGoodsDAO.getInstance();	//접근할 테이블명 이용하는데 길면 약어사용 (지금은풀넴)
	
	//생성자에서 while문 만들어 자식클래스 호출시 꼬일 수 있다 
	// 원하는 상태 : 부모에서 자식 들어가서 자식 처리(뒤로가기)하고 부모(메인)로 돌아오는것
	// 실제 문제상황 : 자식클래스 생성시 부모생성자도 같이 생성되면서 인스턴스 두개가 실행됨 
	//				> 입력값이 부모에 먼저 들어가서 부모(프로그램종료) 처리 후 자식으로 돌아옴
	// 해결 방안 : 메소드에서 실행
	
	//run 메소드 : 실행시키는 코드를 감싸는 메소드
	//내부에서 다른 메소드가 아닌 서브프로그램(다른 클래스 호출)이 돌아감
	
	
	//권한에 따른 접근 분류는 이곳에서
	public void run() {
		boolean role = selectRole();	//권한받아옴(관리자 true, 회원 false)
		
		while(true) {
			menuPrint(role);
			int menuNo = menuSelect();
			
			if(menuNo== 1 && role) {
				//제품정보관리 -> 일반회원X 관리자만
				new ProductInfoManagement();
			}else if(menuNo==2) {
				//제품관리 -> 일반회원은 입출고만
				new ProductStockManagement();
			}else if(menuNo==9) {
				//프로그램 종료
				exit();
				break;
			}else {
				//입력오류
				showInputError();
			}
			System.out.println();
		}
	}
	
	private boolean selectRole() {	//role이 두가지 이상일땐 불린X
		int memberRole = LoginControl.getLoginInof().getMemberRole();
		if (memberRole ==0) {
			return true;	//관리자일때만 true
		}else {
			return false;	//일반회원은 false
		}
	}

	//메소드 -> 서브프로그램에서 끌어 쓰기 위해 protected 이용
	protected void menuPrint(Boolean role) {
		String menu=" ";
		if(role) {
			menu+="1.제품정보관리";
		}
		menu+="2.제품재고관리 9.종료";
		
		System.out.println("==============================");
		System.out.println(menu);
		System.out.println("==============================");
	}
	
	protected int menuSelect() {
		System.out.print("선택 > ");
		int menuNo=0;
		try {
			menuNo = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력해주시기 바랍니다.");
		}
		return menuNo;
	}
	
	protected void exit() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	protected void showInputError() {
		System.out.println("메뉴에서 입력해주시기 바랍니다.");
	}
}
