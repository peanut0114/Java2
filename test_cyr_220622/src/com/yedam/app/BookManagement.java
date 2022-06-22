package com.yedam.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.app.book.Book;
import com.yedam.app.book.BookDAO;

public class BookManagement {
	private Scanner sc = new Scanner(System.in);
	private BookDAO bdao = BookDAO.getInstance();

	public BookManagement() {
		while (true) {
			// 메뉴 출력
			menuPrint();
			// 메뉴 입력
			int menuNo = selectMenu();
			// 각 기능별 실행
			if (menuNo == 1) {
				// 1. 전체조회
				selectAll();
			} else if (menuNo == 2) {
				// 2. 단건조회
				selectOne();
			} else if (menuNo == 3) {
				// 3. 내용검색
				searchBook();
			} else if (menuNo == 4) {
				// 4. 대여가능
				isRentalable();
			} else if (menuNo == 5) {
				// 5. 책 대여
				rentBook();
			} else if (menuNo == 6) {
				// 6. 책 반납
				returnBook();
			} else if (menuNo == 7) {
				// 7. 책 등록
				inputBook();
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

	// 메소드
	private void menuPrint() {
		System.out.println("===================================================================");
		System.out.println(" 1.전체조회 2.단건조회 3.내용검색 4.대여가능 5.책 대여 6.책 반납 7.책 등록 9.종료");
		System.out.println("===================================================================");
	}

	private int selectMenu() {
		System.out.print("메뉴선택 > ");
		int menu = 0;
		try {
			menu = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자 형식으로 입력하십시오.");
		}
		return menu;
	}

	private void showInputError() {
		System.out.println("메뉴를 참고하여 입력해주시기 바랍니다..");
	}

	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

	// 1. 전체조회
	private void selectAll() {
		List<Book> list = bdao.selectAll();
		for (Book info : list) {
			System.out.println(info);
		}
	}

	// 2. 단건조회
	private void selectOne() {
		// 책 이름 입력
		String bookName = inputBookName();
		// DB에 검색
		Book book = bdao.selectOne(bookName);
		// 결과 출력
		if (book != null) {
			System.out.println(book);
		} else {
			System.out.println("원하는 정보가 존재하지 않습니다.");
		}
	}

	private String inputBookName() {
		System.out.print("책 제목 > ");
		return sc.nextLine();
	}

	// 3. 내용검색 - 입력된 키워드를 책제목과 내용에서 조회하여 해당 도서출력
	private void searchBook() {
		// 책 이름 입력
		String keyword = inputKeyword();
		// DB에 전달
		List<Book> list = bdao.serchBook(keyword);
		// 검색결과 확인
		if(list.size()==0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		for (Book info : list) {
			System.out.println(info);
		}
	}

	private String inputKeyword() {
		System.out.print("검색 내용 > ");
		return sc.nextLine();
	}

	// 4. 대여가능 도서 출력
	private void isRentalable() {
		List<Book> list = bdao.InStockBook();
		for (Book info : list) {
			System.out.println(info);
		}
	}

	// 5. 책 대여
	private void rentBook() {
		// 책 이름 입력
		String bookName = inputBookName();
		Book book = bdao.selectOne(bookName);
		// 도서 정보가 있는지 확인
		if (book == null) {
			System.out.println("해당 도서 정보가 존재하지 않습니다.");
			return;
		}
		if (!book.isBookRental()) { // 0 대여가능
			System.out.println("도서 『" + book.getBookName() + "』 대출이 완료되었습니다.");
			bdao.updateRental(book); // 대출가능여부 변경
		} else {
			System.out.println("이미 대여중인 도서입니다.");
		}
	}

	// 6. 책 반납
	private void returnBook() {
		// 책 이름 입력
		String bookName = inputBookName();
		Book book = bdao.selectOne(bookName);
		// 도서 정보가 있는지 확인
		if (book == null) {
			System.out.println("해당 도서 정보가 존재하지 않습니다.");
			return;
		}
		// 모든 도서는 한권씩 뿐이라 가정
		if (book.isBookRental()) { // 1 대여불가 상태 (반납가능)
			System.out.println("도서 『" + book.getBookName() + "』 반납이 완료되었습니다.");
			bdao.updateRental(book); // 대출가능여부 변경
		} else {
			System.out.println("해당 도서의 대출 기록이 없습니다.");
		}
	}

	// 책등록
	private void inputBook() {
		// 책정보 입력
		Book book = inputAll();
		// DB에 저장
		bdao.insert(book);
	}

	private Book inputAll() {
		Book book = new Book();
		System.out.print("책제목 > ");
		book.setBookName(sc.nextLine());
		System.out.print("저자명 > ");
		book.setBookWriter(sc.nextLine());
		System.out.print("책 내용 > ");
		book.setBookContent(sc.nextLine());
		return book;
	}

}
