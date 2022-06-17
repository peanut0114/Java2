package com.yedam.app; //move-app

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.yedam.app.common.Info;
import com.yedam.app.history.History;
import com.yedam.app.history.HistoryDAO;
import com.yedam.app.product.Product;
import com.yedam.app.product.ProductDAO;

public class StockManagement {
	// 테이블이 2개.. 클래스가 나눠진걸 인스턴스로 만들어야함
	private Scanner sc = new Scanner(System.in);
	private ProductDAO pDAO = ProductDAO.getInstance();
	private HistoryDAO hDAO = HistoryDAO.getInstance();

	public StockManagement() {
		while (true) {
			// 메뉴 출력
			menuPrint();
			// 메뉴 입력
			int menuNo = selectMenu();
			// 각 기능별 실행
			if (menuNo == 1) {
				// 제품등록
				inputProduct(); // 이름이 다르게 들어간다는 전제조건으로 짬
			} else if (menuNo == 2) {
				// 제품입고
				productIn();
			} else if (menuNo == 3) {
				// 제품출고
				productOut();
			} else if (menuNo == 4) {
				// 제품재고
				productStock();
			} else if (menuNo == 5) {
				// 전체재고
				allProductStock();
			} else if (menuNo == 9) {
				// 종료
				exit();
				break;
			} else {
				showInputError();
			}
			System.out.println();
		}
	}

	private void menuPrint() {
		System.out.println("=============================================");
		System.out.println(" 1.제품등록 2.입고 3.출고 4.제품재고 5.전체재고 9.종료");
		System.out.println("=============================================");
	}

	private int selectMenu() {
		int menu = 0;
		try {
			menu = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자 형식으로 입력하십시오.");
		}
		return menu;
	}

	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

	private void showInputError() {
		System.out.println("메뉴를 참고하여 입력해주시기 바랍니다.");
	}

	private void inputProduct() {
		// 제품정보 입력
		Product product = inputAll();
		// DB에 저장
		pDAO.insert(product);
	}

	private void productIn() {
		//1. 입고할 제품과 수량 입력
		Info info = inputAmount();	
		//2. 기존에 등록된 제품인지 확인
		Product product = pDAO.selectOne(info.getProductName()); //상품명으로 검색

		if (product != null) {
			// 2-1. 기존에 등록된 제품일 경우 입고처리
			History history = new History();
			history.setProductId(product.getProductId());
			history.setProductCategory(1);//입고=1
			history.setProductAmount(info.getProductAmount());
			
			hDAO.insert(history); //해당자료 입력
		} else {
			// 2-2. 기존에 등록되지 않은 경우 별도 안내
			System.out.println("해당 제품의 정보를 우선 등록해주세요.");
		}
	}
	
	private void productOut() {
		//1. 출고할 제품과 수량을 입력
		Info info = inputAmount();
		//2. 등록되어있는 제품인지 확인
		Product product = pDAO.selectOne(info.getProductName()); //상품명으로 검색
		if(product == null) {		//등록되지 않은 경우 메소드 종료
			System.out.println("해당 제품의 정보를 확인해주세요");
			return;
		} 							//등록된 제품이면 밑으로 내려감
		//3-1. 재고량이 있는지 확인
		int stock = selectStock(product.getProductId());
		//3-2. 재고량과 출고량 비교
		if(stock >= info.getProductAmount()) {	//재고가 같거나 많은 경우 ok
			//4-1. 조건을 모두 잔족하는 경우 출고처리
			History history = new History();	//history를 생성해서 데이터 정리
			history.setProductId(product.getProductId());
			history.setProductCategory(2);
			history.setProductAmount(info.getProductAmount());
			
			hDAO.insert(history);
		}
		else {
		//4-2. 각 조건이 만족되지 않는 경우 적합한 문구를 출력
		System.out.println("재고가 부족합니다.");
		}
	}
	
	private void productStock() {
		//검색하고자 하는 제품 정보 입력
		String productName = inputName();
		//등록된 제품인지 확인
		Product product = pDAO.selectOne(productName);
		if(product ==null) {
			System.out.println("해당 제품의 정보가 등록되어있지 않습니다.");
			return;
		}
		//해당 제품의 재고 출력
		int stock = selectStock(product.getProductId());
		
		System.out.println("제품정보 : "+product.getProductId()
						+", 제품이름 : "+product.getProductName()
						+", 재고 : "+stock);
	}
	
	//JOIN을 배제한 방식
	private void allProductStock() {
		//제품번호과 재고 담는 map
		Map<Integer, Integer> list = hDAO.selectAllAmount(); //history에서 정보 가져옴
		Set<Integer> productList = list.keySet();	//key에 대한 set컬렉션
		for(int productId : productList) {
			Product product = pDAO.selectOne(productId);	//product에서 id기반 정보 가지고옴
			int stock = list.get(productId);	//재고 가지고옴
			
			System.out.println("제품정보 : "+product.getProductId()
							+", 제품이름 : "+product.getProductName()
							+", 재고 : "+stock);
		}
	}
	
	private Product inputAll() {
		Product product = new Product();
		System.out.print("제품이름 > ");
		product.setProductName(sc.nextLine());
		System.out.print("제품가격 > ");
		product.setProductPrice(Integer.parseInt(sc.nextLine()));
		return product;
	}

	private Info inputAmount() {
		Info info = new Info();
		System.out.println("제품이름 > ");
		info.setProductName(sc.nextLine());
		System.out.println("제품수량 > ");
		info.setProductAmount(Integer.parseInt(sc.nextLine()));
		
		return info;
	}
	
	private String inputName() {
		System.out.println("제품이름 > ");
		return sc.nextLine();
	}
	
	private int selectStock(int productId) {
		int in = hDAO.selectInAmount(productId);
		int out = hDAO.selectOutAmount(productId);
		return (in-out);
	}
}
