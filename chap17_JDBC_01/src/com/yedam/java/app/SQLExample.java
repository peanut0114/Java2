package com.yedam.java.app;
//주의 : DB를 같이 쓰기때문에 커밋/푸시로 트랜젝션 종료시켜야 함 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//순서외워야함
public class SQLExample {

	public static void main(String[] args) throws Exception {
	//1. JDBC Driver 로딩하기
		Class.forName("oracle.jdbc.driver.OracleDriver");
					//오타나 존재하지 않는 클래스 있을 수 있으니 예외처리 필요 (나중에 배움)
		
	//2. DB 서버 접속하기
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //db정보
		String id = "hr";
		String pwd = "hr";
		
		Connection con = DriverManager.getConnection(url,id,pwd);
		
	//3. CRUD 실행
		
	//************************** INSERT *************************************
	//-1. Statement or PrepredStatement 객체 생성하기
		String insert 
		= "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		//preparedStatement는 값 넣을 곳에 ?를 넣어 보냄 -> ?수만큼 set메소드 써야함
		PreparedStatement pstmt = con.prepareStatement(insert);
		
	//-2. SQL 구성 후 실행 : ?값을 대체시킴 -> set으로 어떤 타입으로 할지 적어줌(setInt)
		pstmt.setInt(1,1000); //1번째 값에 int 타입의 1000으로 대체함
		pstmt.setString(2, "Kil-Dong");
		pstmt.setString(3, "Gong");
		pstmt.setString(4, "kdHong@google.com");
		pstmt.setString(5, "82.10.11234.1234");
		pstmt.setString(6, "21/11/05");
		pstmt.setString(7, "SA_REP");
		pstmt.setInt(8, 6000);	//salary
		pstmt.setDouble(9, 0.15);
		pstmt.setInt(10, 149);
		pstmt.setInt(11, 80);
		
	//-3. 결과 출력
		int result = pstmt.executeUpdate();	//insert결과는 executeUpdate
		//어떤 쿼리를 썼냐에 따라 결과에 다른 메소드 이용해야함 
		System.out.println("insert 결과 : "+result);
		System.out.println();
		
	//***************************** UPDATE *****************************************
	//-1. Statement or PrepreStatement 객체 생성하기
		String update 
		= "UPDATE employees SET last_name= ? WHERE employee_id= ?";
		//컬럼과 테이블명에 ?불가 (?는 값을 대체하는것) -> 바꾸고픔 아예 문장으로 구성해야함	
		pstmt = con.prepareStatement(update);	//다시 preparedStatements에 값을 넣어줌
		
	//-2. SQL 구성 후 실행
		pstmt.setInt(2, 1000);	//매개변수로 위치 알리기 때문에 순서는 중요X
		pstmt.setString(1, "King");
				
	//-3. 결과 출력
		result = pstmt.executeUpdate();

	//********************************* SELECT *************************************
	//-1. Statement or PrepreStatement 객체 생성하기
		String select = "SELECT * FROM employees ORDER BY 2";
		pstmt = con.prepareStatement(select);
		
	//-2. SQL 구성 후 실행
		ResultSet rs = pstmt.executeQuery();	
	//-3. 결과 출력
		while(rs.next()) {
			String info = rs.getInt("employee_id")+" : "+rs.getString("first_name");
			System.out.println(info);
		}
		System.out.println();
		
	//********************************* DELETE **************************************
	//-1. Statement or PrepreStatement 객체 생성하기
		String delete = "DELETE FROM employees WHERE employee_id=?";		
		pstmt = con.prepareStatement(delete);
				
	//-2. SQL 구성 후 실행
		pstmt.setInt(1, 1000);
		
	//-3. 결과 출력
		result = pstmt.executeUpdate();
		System.out.println("delete 결과 : "+result);
		
	//4. 자원 해제하기
		if(rs != null) rs.close();
		
	}

}
