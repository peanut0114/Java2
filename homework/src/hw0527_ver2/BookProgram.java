package hw0527_ver2;

import java.util.Scanner;

public class BookProgram implements Program {
	private Access dao = BookDAO.getInstance(); // 독자적공간
	private Scanner sc = new Scanner(System.in);

	// 메뉴 출력
	public void menuPrint() {
		System.out.println("========+=========+=====+=====+======");
		System.out.println("1.정보입력 2.전체 조회 3.검색 4.분석 5.종료");
		System.out.println("========+=========+=====+=====+======");
	}

	// 1. 정보입력
	@Override
	public void inputInfo() {
		Book newBook = inputAll(); // 새로운 책 정보 입력
		dao.insert(newBook); // dao에 저장
	}

	public Book inputAll() {
		System.out.print("제목 > ");
		String title = sc.nextLine();
		System.out.print("가격 > ");
		int price = Integer.parseInt(sc.nextLine());
		return new Book(title, price);
	}

	// 2. 전체조회
	@Override
	public void printAllInfo() {
		Book[] list = dao.selectAll();
		for (Book temp : list) { 	// list안의 모든 방에 데이터가 있는 상황
			temp.showInfo(); 		// 향상된 for문 써도 무방
		} 							// null밖에 없는 곳에 무언가 요구하면 문제발생
	}

	// 3. 검색
	@Override
	public void printInfo() {
		// isbn정보 입력
		int keyword = inputOne();
		// DAO에서 검색
		Book book = selectBook(keyword);
		// 출력
		book.showInfo();
	}

	public int inputOne() {
		System.out.println("도서의 ISBN 입력 > ");
		return Integer.parseInt(sc.nextLine());
	}

	public Book selectBook(int keyword) {
		return dao.selectOne(keyword);
	}

	// 4. 분석
	@Override
	public void printReport() {
		// 가장 비싼 책
		Book maxInfo = findMax();
		System.out.println("가장 가격이 비싼 책 > ");
		maxInfo.showInfo();
		// 가장 가격이 낮은 책
		Book minInfo = findMin();
		System.out.println("가장 가격이 낮은 책 > ");
		minInfo.showInfo();
		// 두가지를 제외한 책들의 평균 가격
		calcAvg();
	}

	private Book findMax() { // 내부에서만 쓸 내용
		// 전체 조회
		Book[] list = dao.selectAll();
		// 검색
		Book MaxInfo = list[0];
		for (Book data : list) {
			if (MaxInfo.getBookPrice() < data.getBookPrice()) {
				MaxInfo = data;
			}
		}
		// 반환
		return MaxInfo;
	}

	public Book findMin() {
		// 전체 조회
		Book[] list = dao.selectAll();
		// 검색
		Book MinInfo = list[0];
		for (Book data : list) {
			if (MinInfo.getBookPrice() > data.getBookPrice()) {
				MinInfo = data;
			}
		}
		// 반환
		return MinInfo;
	}

	public void calcAvg() {
		Book[] list = dao.selectAll();
		int sum = 0;
		for (Book data : list) {
			if (data.getBookPrice() > findMin().getBookPrice() && data.getBookPrice() < findMax().getBookPrice()) {
				// 조건을 만족하는 경우의 총합
				sum += data.getBookPrice();
				// 조건에 만족하는 경우의 정보를 출력
				//data.showInfo();
			}
		}
		double avg = (double) sum / (list.length - 2);
		System.out.printf("최고,최저 가격을 제외한 평균 : %.2f\n", avg);
	}

}
