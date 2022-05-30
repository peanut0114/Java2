package hw0527;

import java.util.Scanner;

public class BookSystem implements BookProgram {
	Scanner sc = new Scanner(System.in);

	// 메뉴 출력
	public void menuPrint() {
		System.out.println("===================================================");
		System.out.println("1.정보입력 2.전체 조회 3.검색 4.분석 5.가격수정 6.삭제 7.종료");
		System.out.println("===================================================");
	}

	// 1. 정보입력
	@Override
	public void insertInfo(Repo repo) {
		Book newBook = insertAll(); // 새로운 책 정보 입력
		repo.insert(newBook); // repo에 저장
	}

	public Book insertAll() {
		System.out.print("책 이름 > ");
		String name = sc.nextLine();
		System.out.print("가격 > ");
		int price = Integer.parseInt(sc.nextLine());
		return new Book(name, price);
	}

	// 2. 전체조회
	@Override
	public void printAllInfo(Repo repo) {
		Book[] list = repo.selectAll();
		for (Book temp : list) {
			showInfo(temp);
		}
	}

	// 3. 검색
	@Override
	public void printInfo(Repo repo) {
		System.out.print("검색할 ");
		Book book = selectBook(repo);
		if (nullCheck(book)) {
			showInfo(book);
		}
	}

	public Book selectBook(Repo repo) {
		System.out.println("도서의 ISBN 입력 > ");
		int isbn = Integer.parseInt(sc.nextLine());
		return repo.selectOne(isbn);
	}

	// 4. 분석
	@Override
	public void printReport(Repo repo) {
		System.out.println("최고가 도서 정보 > ");
		showInfo(findMax(repo));
		System.out.println("최저가 도서 정보 > ");
		showInfo(findMin(repo));
		System.out.printf("\n최고, 최저가를 제외한 가격 평균 : %.2f원\n", findAvg(repo));
	}

	public Book findMax(Repo repo) {
		Book[] temp = repo.selectAll();
		Book MaxInfo = temp[0];
		for (int i = 0; i < temp.length; i++) {
			if (MaxInfo.getBookPrice() < temp[i].getBookPrice()) {
				MaxInfo = temp[i];
			}
		}
		return MaxInfo;
	}

	public Book findMin(Repo repo) {
		Book[] temp = repo.selectAll();
		Book MinInfo = temp[0];
		for (int i = 0; i < temp.length; i++) {
			if (MinInfo.getBookPrice() > temp[i].getBookPrice()) {
				MinInfo = temp[i];
			}
		}
		return MinInfo;
	}

	public double findAvg(Repo repo) {
		Book[] temp = repo.selectAll();
		int sum = 0;
		for (int i = 0; i < temp.length; i++) {
			sum += temp[i].getBookPrice();
		}
		if (temp.length <= 2) {
			return 0;
		} else {
			sum -= (findMax(repo).getBookPrice() + findMin(repo).getBookPrice());
			return (double) sum / (temp.length - 2);
		}
	}

	// 5. 수정
	public void updateInfo(Repo repo) {
		System.out.print("수정할 ");
		Book book = selectBook(repo);
		if (nullCheck(book)) {
			System.out.println("가격을 수정해주세요 >");
			book.setBookPrice(Integer.parseInt(sc.nextLine()));
		}
	}

	// 6. 삭제
	public void deletInfo(Repo repo) {
		System.out.println("삭제할 ");
		Book book = selectBook(repo);
		if (nullCheck(book)) {
			System.out.println("도서 '"+book.getBookName()+"'을(를) 제거합니다.");
			repo.delete(book);
		}
	}
	
	public boolean nullCheck(Book book) {
		if (book.getBookName() == null) {
			System.out.println("정보가 없습니다.");
			return false;
		} else
			return true;
	}

	public void showInfo(Book book) {
		System.out.println(book.showInfo());
	}
}
