package com.yedam.app.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DAO {

	//Oracle DB 정보
	private String jdbcDriver;
	private String oracleUrl;
	private String connectedId;
	private String connectedPwd;
	
	//공통으로 사용되는 필드 (자식클래스에서 쓰기 위해 protected)
	protected Connection conn;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	public DAO(){
		dbConfig();	//생성자에서 실행하면 한번만 실행시켜 필드에 값을 담아둠(DB정보저장 메소드)
	}
	
	//DB에 접속하는 메소드
	public void connect() {
		try {
			Class.forName(jdbcDriver); //드라이버 로딩
			
			conn = DriverManager.getConnection(oracleUrl, connectedId, connectedPwd);
				//DriverManager클래스를 통해 넣어줌 (순서중요)
			
		}catch(ClassNotFoundException e) {	//원인이 명확히 다른 2가지 예외 구분해서 관리하기 
			System.out.println("jdbc driver 로딩 실패");
		}catch(SQLException e) {
			System.out.println("DB 연결 실패");
		}
		
	}
	
	
	//DB 정보를 properties에서 가져오는 메소드 (코드를 직접 수정하는 경우를 줄이기 위함)
	private void dbConfig() {
		String resource = "config/db.properties";
		Properties properties = new Properties(); //properties 파일을 열기 위해 Properties클래스 사용
		
		try {
			String filePath = ClassLoader.getSystemClassLoader().getResource(resource).getPath();
			// ClassLoader 클래스에서 / .getSystemClassLoader : 실행되는 클래스 정보 가져오고
			// .getResource : 접근위치 넘겨 자원찾기(지정파일) /getPath : 정확한 경로
			properties.load(new FileInputStream(filePath)); //FileInputStream : 외부 파일 엶
					// load가 정보를 key와 value 형태로 묶어줌
		} catch (IOException e) {
			e.printStackTrace();
		}
		jdbcDriver = properties.getProperty("driver");
		oracleUrl = properties.getProperty("url");
		connectedId = properties.getProperty("id");
		connectedPwd = properties.getProperty("pwd");
	}
	
	//DB 접속을 해제하는 메소드
	public void disconnect() {
		try {
			if(rs != null) rs.close();	//인스턴스가 있는지 체크
			if(pstmt != null) pstmt.close();	//사용 안 된 필드를 닫으려 하면 NullPointExecption 발생
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
			
		}catch(SQLException e) {	//※ catch 문구 안은 비워두지 말 것! 
			e.printStackTrace();	//아무것도 안 뜨면 확인불가
		}
	}
	
}
