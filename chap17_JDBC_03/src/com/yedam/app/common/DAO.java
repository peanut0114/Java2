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

/*
 * empDAO와 depDAO의 공통부분
 */
public class DAO {

	// 필드 
	// Oracle(DB) 연결 정보 - 상속X DAO클래스에서만 건들 수 있음
	String jdbc_driver;
	String oracle_url;
	String connectedId;
	String connectiedPwd;

	// 각 메소드에서 공통적으로 사용하는 필드 
	// 자식 클래스가 생길 예정이기에 protected로 수정
	protected Connection conn;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	public void connect() { // 묶는역할
		dbConfig(); // db.proberties에서 값 읽어서 넣어줌

		try {
			// 1.JDBC Driver 로딩
			Class.forName(jdbc_driver); // 필드에 정보 넣어서 전달할거임
			// 2.DB 서버 접속
			conn = DriverManager.getConnection(oracle_url, connectedId, connectiedPwd);

		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
		}
	}

	private void dbConfig() {
		String resource = "config/db.properties"; // 우리가 접근하려는 프로젝트 내에 위치
		Properties properties = new Properties();

		try {

			String filePath = ClassLoader.getSystemClassLoader().getResource(resource).getPath();
			// ClassLoader : 클래스 정보 갖고 옴 / .getSystemClassLoader : 실행되는 클래스 정보
			// /.getResource : 접근위치 넘겨 자원찾기
			properties.load(new FileInputStream(filePath)); // properties 확장자에 대응되는 클래스를 이요해 별도의 처리를 거치지 않고 손쉽게 사용
			// 틀만 유지되면 내부적으로 key와 value를 알아서 분류해서 가짐
		} catch (IOException e) {
			e.printStackTrace();
		}
		jdbc_driver = properties.getProperty("driver");
		oracle_url = properties.getProperty("url");
		connectedId = properties.getProperty("id");
		connectiedPwd = properties.getProperty("pwd");
	}

	// 4.자원 해제
	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
