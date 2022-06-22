package com.yedam.app.book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.yedam.app.common.DAO;

public class BookDAO extends DAO {

	//싱글톤
	private BookDAO() {}
	private static BookDAO bdao = null;
	public static BookDAO getInstance() {
		if(bdao==null) {
			bdao = new BookDAO();
		}
		return bdao;
	}
	
	//CRUD
	//입력
	public void insert(Book book) {	
		try {
			connect();	//처음 등록시 대여가능 (rental=0)
			String sql = "INSERT INTO books(book_name, book_writer, book_content) "
						+ "VALUES(?, ?, ?)";	//줄바꿈시 공백주의
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getBookName());
			pstmt.setString(2, book.getBookWriter());
			pstmt.setString(3, book.getBookContent());
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println(result+"건 등록되었습니다.");
			}else {
				System.out.println("정상적으로 등록되지 않았습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			disconnect();
		}
	}
	
	//수정 - 대여가능여부
	public void updateRental(Book book) {	
		try {
			connect();
			int isRental=0;	
			if(!book.isBookRental()) {	//대여 가능(0)상태를 대여불가(1)로 바꿈
				isRental=1;
			}
			String sql = "UPDATE books "
						+" SET book_rental ="+isRental
						+" WHERE book_name ='"+book.getBookName()+"'";
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			if(result>0) {
				System.out.println("정상적으로 정보가 수정되었습니다.");
				
			}else {
				System.out.println("※정상적으로 수정되지 않았습니다.※");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			disconnect();
		}
	}
	
	//삭제
	public void delete(String bookName) {	
		try {
			connect();
			String sql = "DELETE FROM books WHERE book_name='" + bookName+"'";
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(sql);
			if(result>0) {
				System.out.println(result+"건 삭제되었습니다.");
			}else {
				System.out.println("정상적으로 삭제되지 않았습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			disconnect();
		}
	}
	
	//단건조회
	public Book selectOne(String bookName) {	
		Book book = null;
		try {
			connect();
			String sql = "SELECT * FROM books WHERE book_name =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookName);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				book = new Book();
				book.setBookName(rs.getString("book_name"));
				book.setBookWriter(rs.getString("book_writer"));
				book.setBookContent(rs.getString("book_content"));
				book.setBookRental(rs.getBoolean("book_rental"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			disconnect();
		}
		return book;
	}
	
	//키워드 조회 (제목, 내용 중에서 검색)
	public List<Book> serchBook(String keyword) {	
		List<Book> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM books "
						+ "WHERE book_name LIKE '%"+keyword+"%' "
						+ "OR book_content LIKE '%"+keyword+"%' "
						+ "ORDER BY 1";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Book book = new Book();
				book.setBookName(rs.getString("book_name"));
				book.setBookWriter(rs.getString("book_writer"));
				book.setBookContent(rs.getString("book_content"));
				book.setBookRental(rs.getBoolean("book_rental"));
				
				list.add(book);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			disconnect();
		}
		return list;
	}
	//대출 가능 도서 조회 (rental = 0)
	public List<Book> InStockBook() {	
		List<Book> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM books WHERE book_rental=0 ORDER BY 1";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Book book = new Book();
				book.setBookName(rs.getString("book_name"));
				book.setBookWriter(rs.getString("book_writer"));
				book.setBookContent(rs.getString("book_content"));
				book.setBookRental(rs.getBoolean("book_rental"));
				
				list.add(book);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			disconnect();
		}
		return list;
	}
	//전체조회
	public List<Book> selectAll(){
		List<Book> list = new ArrayList<>();
		
		try {
			connect();
			String sql = "SELECT * FROM books ORDER BY book_name";
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Book book = new Book();
				book.setBookName(rs.getString("book_name"));
				book.setBookWriter(rs.getString("book_writer"));
				book.setBookContent(rs.getString("book_content"));
				book.setBookRental(rs.getBoolean("book_rental"));
				
				list.add(book);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}
	
	
}
