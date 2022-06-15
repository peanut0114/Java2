package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//JDBC 기본 사용
public class SelectExample {
	public static void main(String[] args) throws Exception {
	//1. JDBC Driver 로딩하기
		Class.forName("oracle.jdbc.driver.OracleDriver"); //로딩하고자 하는 드라이브 정보 복사
		
	//2. DB 서버 접속하기
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";	//인사관리에 접근
		String pwd = "hr";
		Connection con = DriverManager.getConnection(url, id, pwd);	//DB의 정보 필요, 정보를 가져옴(newX)
		
	//3. Statement or PreparedStatement 객체 생성하기
		Statement stmt = con.createStatement(); //import : sql (커넥션을 이용해 스테이트먼트 만듬)
		//statement : 완전히 구성된 쿼리 요구 / prepareStatement대체 변수를 ?로 구성
		
	//4. Query 구성
		String sql = "SELECT * FROM employees WHERE last_name='King'"; //sql문을 ; 빼고 String으로 작성
					//쿼리는 developer에서 미리 실행해보고 맞는지 확인해보자
		
	//5. Query 실행
		ResultSet rs = stmt.executeQuery(sql); //실행하는 sql문 넘겨줌 (select결과는 resultSet을 통해 받음)
		
	//6. 결과값 출력하기
		while(rs.next()) {	//행을 커서로 가리킴. 끝까지 가면 false를 반환함
			String name = rs.getString(2)+" "+rs.getString("last_name");	
			//get : 매개변수로 컬럼명 사용(컬럼 순서 번호로 써도 됨), 반환타입 써야함
			System.out.println(name);
		}
		
	//7. 자원해제하기 : 생성된 순서의 반대로 닫아야함
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(con != null) con.close();
		
	}
}
