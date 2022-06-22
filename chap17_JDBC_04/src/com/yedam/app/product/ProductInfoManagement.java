package com.yedam.app.product;

import java.util.List;
import com.yedam.app.common.Management;

/*
 * product 테이블의 제품에 대한 정보를 등록, 수정, 삭제
 * 그 테이블이 다른 테이블과 영향을 미치기 때문에 rDAO등도 필요
 */
public class ProductInfoManagement extends Management {

	public ProductInfoManagement() {
		while (true) {
			menuPrint(); // 오버라이딩필요
			int menuNo = menuSelect(); // 부모에게 있는 메소드 그대로 사용

			if (menuNo == 1) {
				// 제품정보등록
				insertProductInfo();
			} else if (menuNo == 2) {
				// 제품정보수정 - 가격
				updateProductInfo();
			} else if (menuNo == 3) {
				// 단건 정보조회
				selectOne();
			} else if (menuNo == 4) {
				// 전체 정보조회
				selectAll();
			} else if (menuNo == 5) {
				// 제품정보삭제
				deleteProductInfo();
			} else if (menuNo == 9) {
				// 뒤로가기
				back();
				break;
			} else {
				// 입력오류
				showInputError();
			}
			System.out.println();
		} // Info가 끝나면 Management로 돌아감
	}


	private void selectOne() {
		String productName = inputName();
		
		Product product = pDAO.selectOne(productName);
		if(product==null) {
			System.out.println("등록된 제품이 아닙니다.");
			return;
		}
		System.out.println(product);
	}
	
	private void selectAll() {
		List<Product> list = pDAO.selectAll();
		
		for (Product info : list) {
			System.out.println(info);
		}
	}

	protected void menuPrint() {
		System.out.println("=======================================================");
		System.out.println(" 1.제품등록 2.제품수정 3.제품조회 4.전체조회 5.제품삭제 9.뒤로가기");
		System.out.println("=======================================================");
	}

	private void back() {
		System.out.println("메인으로 돌아갑니다.");
	}

	private void insertProductInfo() {
		// 제품정보 입력
		Product product = inputAll(); // VO클래스 끌고오기
		// DB에 저장
		pDAO.insert(product);
	}

	private void deleteProductInfo() {
		// 제품이름 입력
		String productName = inputName();
		// 제품정보 검색
		// -1 product 테이블에서 정보 갖고옴
		Product product = pDAO.selectOne(productName);

		if (product == null) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		}
		// -2 입고내역에서 검색 > 입고상황일때 삭제 막음
		boolean isSelected = rDAO.selectInfo(product.getProductId());// id로 있는지여부 확인(있으면 true)
		// DB에서 삭제
		if (!isSelected) { // 반전연산자 (헷갈리면 if와 else 위치를 바꿔 그냥 쓸걸)
			pDAO.delete(product.getProductId());
		} else {
			System.out.println("거래내역이 존재합니다. 삭제가 불가능합니다.");
		}
	}

	private void updateProductInfo() {
		// 제품이름 입력
		String productName = inputName();

		// 제품정보 검색 - 이름
		// 업뎃 쿼리에 이름,가격 값을 모두 넣어야하기 때문에 바꾸지 않는다면 원래 값을 그대로 반환하도록 가져옴
		Product product = pDAO.selectOne(productName);

		if (product == null) {
			System.out.println("등록된 정보가 없습니다.");
			return;
		}
		// 수정할 정보 입력 - 기존정보를 받아서 반환하는 형태
		product = inputUpdateInfo(product);

		// DB 수정 -> 무조건 수정됨 (이름, 가격정보 둘 다 들어있어야함)
		pDAO.updateInfo(product);

	}

	private Product inputAll() {
		Product product = new Product();
		System.out.print("제품이름 > ");
		product.setProductName(sc.nextLine());
		System.out.print("제품가격 > ");
		product.setProductPrice(Integer.parseInt(sc.nextLine()));
		return product;
	}

	private String inputName() {
		System.out.print("제품이름 > ");
		return sc.nextLine();
	}

	private Product inputUpdateInfo(Product product) { // 현재 컬럼 값을 가져와야함
		// 쿼리문에 이름, 가격을 둘 다 바꾸게 짜놨음
		// 둘 다 값을 넣어야하기 때문에 바꾸지 않는다면 원래 값을 그대로 반환

		System.out.println("기존 > " + product.getProductName());
		System.out.print("수정 (수정하지 않을 경우 0입력) > ");
		String name = sc.nextLine();
		if (!name.equals("0")) { // 입력이 0이 아닌 경우만 이름변경
			product.setProductName(name);
		}

		System.out.println("기존 > " + product.getProductPrice());
		System.out.print("수정 (수정하지 않을 경우 -1입력) > ");
		int price = Integer.parseInt(sc.nextLine());
		if (price > -1) { // 입력이 0이 아닌 경우만 이름변경
			product.setProductPrice(price);
		}
		return product;

	}
}
