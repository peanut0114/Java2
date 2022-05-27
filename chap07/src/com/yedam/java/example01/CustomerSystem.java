package com.yedam.java.example01;
/*
 * 일반적인 구성 > 메소드를 어떻게 구성해볼까!
 * 
 * 
 * 생성자 안에서 while문 (메뉴-션택) 코드 모아놓는 곳
 * 메소드 이름만 보고 기능 할 수 있게 네이밍! 중요!
 * 
 * 회원가입 입력 등은 중복해서 사용 > 따로 메소드 만들면 편함
 */
import java.util.Scanner;
public class CustomerSystem {

	// 필드
	private Repo repo = new Repo(); // 저장소 생성
	private Scanner sc = new Scanner(System.in);

	// 생성자
	public CustomerSystem() {
		while(true) {
			//메뉴 출력
			menuPrint();
			//메뉴 선택
			int menuNo = menuSelect();
			if(menuNo==1) {		//스위치의 break는 스위치만 종료. if써야함
				//메뉴1. 회원가입
				signUp();					//1-1.회원정보입력 1-2.정보저장
			}else if (menuNo==2){ 
				//메뉴2. 회원정보
				myPage();					//2-1.회원id입력 2-2.정보조회 출력
			}else if(menuNo==3) {
				//메뉴3. 결제시 금액
				payInfo();
			}else if(menuNo==4) {
				//메뉴4. 종료
				exit();
				break;
			}else {
				
			}
		}
}

// 메소드
	void menuPrint() {	//메뉴출력
		System.out.println("===================================");
		System.out.println("1.회원가입 |2.회원정보 |3.결제금액 |4.종료");
		System.out.println("===================================");
	}
	
	int menuSelect() {	//메뉴선택
		System.out.print("메뉴 > ");
		return Integer.parseInt(sc.nextLine());
	}
	
	void signUp() {		
		//등급선택, 회원정보 입력
		Customer info = inputAll();
		//가입
		repo.insert(info);
	}
	
	Customer inputAll() {
		//회원 기본 정보 입력
		System.out.print("아이디 No. > ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("이름 > ");
		String name = sc.nextLine();
		
		//회원 등급 선택
		Customer customer = getGrade();
		customer.setCustomerId(id);
		customer.setCustomerName(name);
		/*
		int selected = selectGrade(); //인스턴스 만들어 반환받으려했는데 수정필해요해서 그냥..
		Customer customer = null;
		switch(selected) {
		case 1:
			customer = new Customer(id,name);
			break;
		case 2:
			customer = new Gold(id, name);
			break;
		case 3:
			customer = new Vip(id, name, "이한나");
			break;
		}
		*/
		System.out.printf("No.%d %s님 가입 완료되었습니다.\n",customer.getCustomerId(),customer.getCustomerName());
		return customer;
		
	}
	
	/*
	int selectGrade() {
		System.out.println("1.SILVER |2.GOLD |3.VIP");
		System.out.println("------------------------");
		return Integer.parseInt(sc.nextLine());
	}
	*/
	
	Customer getGrade() {
		System.out.println("1.SILVER |2.GOLD |3.VIP");
		System.out.println("------------------------");
		int select = Integer.parseInt(sc.nextLine());
		
		Customer customer = null;
		switch(select) {
		case 1:
			customer = new Customer();
			break;
		case 2:
			customer = new Gold();
			break;
		case 3:
			customer = new Vip();
			break;
		}return customer;
	}
	
	void myPage() {
		int customerId = inputOne();	//id입력받아서 정보출력
		Customer info = repo.selectOne(customerId);
		System.out.println(info.showInfo());
	}
	void payInfo() {
		int customerId = inputOne();		
		Customer info = repo.selectOne(customerId);
		
		System.out.print("구매금액 > ");
		int price = Integer.parseInt(sc.nextLine());
		int pay = info.calPrice(price);
		System.out.println("결제 금액 : "+pay);
	}
	void exit() {
		System.out.println("\n**프로그램 종료**");
	}
	int inputOne() {						//id 입력받음
		System.out.print("고객 아이디 No. > ");
		return Integer.parseInt(sc.nextLine());
	}
}
