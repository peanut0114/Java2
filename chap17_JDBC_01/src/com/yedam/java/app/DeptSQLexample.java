package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//department table접근
public class DeptSQLexample {

	public static void main(String[] args) {
		try {
	//1. JDBC Driver 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
	//2. DB 서버 접속
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pwd = "hr";
		Connection conn = DriverManager.getConnection(url,id,pwd);
		
	//3. CRUD 실행 (Create(생성), Read(읽기), Update(갱신), Delete(삭제))
		
		/******************************** INSERT ********************************/
		//-1. PreparedStatement 객체 생성
		String isert = "INSERT INTO departments VALUES(?,?,?,?)";	//sql문
		PreparedStatement pstmt = conn.prepareStatement(isert);
		
		//-2. Query 구성
		pstmt.setInt(1, 1000);
		pstmt.setString(2, "YEDAM");
		pstmt.setInt(3, 100);	//제약조건 걸려있음
		pstmt.setInt(4, 2500);	//제약조건 걸려있음
		
		//-3. 실행 후 결과 출력
		int result = pstmt.executeUpdate();	//insert, update, delete : 몇개의 행을 실행했는지 반환
		System.out.println("Insert 실행 : "+result);
		
		/******************************** UPDATE ********************************/
		//-1. PreparedStatement 객체 생성
		String update = "UPDATE departments SET department_name = ? WHERE department_id=?";	//sql문
		pstmt = conn.prepareStatement(update);
		
		//-2. Query 구성
		pstmt.setString(1, "JAVA");
		pstmt.setInt(2, 1000);
		
		
		//-3. 실행 후 결과 출력
		result = pstmt.executeUpdate();	//insert, update, delete : 몇개의 행을 실행했는지 반환
		System.out.println("UPDATE 실행 : "+result);
		
		/******************************** SELECT ********************************/
		//-1. PreparedStatement 객체 생성
		String select = "SELECT * FROM departments ORDER BY department_id";	//sql문
		pstmt = conn.prepareStatement(select);
		
		//-2. Query 구성
		
		//-3. 실행 후 결과 출력
		ResultSet rs = pstmt.executeQuery();	//SELECT
		while(rs.next()) {
			String info = "부서번호 : "+rs.getInt("department_id")
						+ ", 부서이름 : "+rs.getString("department_name");
			System.out.println(info);
		}
		
		/******************************** DELETE ********************************/
		//-1. PreparedStatement 객체 생성
		String delete = "DELETE FROM departments WHERE department_id=?";
		pstmt =  conn.prepareStatement(delete);
		
		//-2. Query 구성
		pstmt.setInt(1, 1000);
		
		//-3. 실행 후 결과 출력
		result = pstmt.executeUpdate();
		System.out.println("Delete 실행 : "+result);
		
		//4. 자원해제
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
		
	}catch(ClassNotFoundException e){
		System.out.println("DB 서버 접속 실패");
	}catch(SQLException e) {
		System.out.println("Query 실행 실패");
		e.printStackTrace();
	}
	finally {	
		
	}

}
}
