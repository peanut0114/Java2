package com.yedam.java.dep;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DepDAO {

	// 싱글톤
	public static DepDAO dapDAO = null;

	private DepDAO() {
	}

	public static DepDAO getInstance() {
		if (dapDAO == null) {
			dapDAO = new DepDAO();
		}
		return dapDAO;
	}

	// Oracle DB 연결 정보
	String jdbc_driver;
	String oracle_url;
	String connectedId;
	String connectiedPwd;

	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	public void connect() {
		dbConfig();
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

	public void dbConfig() {
		String resource = "config/db.properties";
		Properties properties = new Properties();

		try {
			String filePath = ClassLoader.getSystemClassLoader().getResource(resource).getPath();
			properties.load(new FileInputStream(filePath));
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

	// 3. CRUD 실행
	// 3-1. 전체조회
	public List<Department> selectAll() {
		List<Department> list = new ArrayList<>();
		try {
			connect();
			String sql = "SELECT * FROM departments ORDER BY 1";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Department dep = new Department();
				dep.setDepatementId(rs.getInt("department_id"));
				dep.setDepartmentName(rs.getString("department_name"));
				dep.setManagerId(rs.getInt("manager_id"));
				dep.setLocationId(rs.getInt("location_id"));

				list.add(dep);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 3-2. 단건조회
	public Department selectOne(int departmentId) {
		Department dep = null;

		try {
			connect();
			String sql = "SELECT * FROM departments WHERE department_id=" + departmentId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				dep = new Department();
				dep.setDepatementId(rs.getInt("department_id"));
				dep.setDepartmentName(rs.getString("department_name"));
				dep.setManagerId(rs.getInt("manager_id"));
				dep.setLocationId(rs.getInt("location_id"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return dep;
	}
	
	//3-3. 등록
	public void insert(Department dep) {
		try {
			connect();
			String sql = "INSERT INTO departments VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dep.getDepatementId());
			pstmt.setString(2, dep.getDepartmentName());
			pstmt.setInt(3, dep.getManagerId());
			pstmt.setInt(4, dep.getLocationId());
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println(result+"건이 등록되었습니다.");
			}else {
				System.out.println("등록되지 않았습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//3-4. 수정
	public void update(Department dep) {
		try {
			connect();
			String sql = "UPDATE departments SET location_id=? WHERE department_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(2, dep.getDepatementId());
			pstmt.setInt(1, dep.getLocationId());
			
			int result = pstmt.executeUpdate();
			
			if (result>0) {
				System.out.println(result+"건이 수정되었습니다.");
			}else {
				System.out.println("수정되지 않았습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
	//3-5. 삭제
	public void delete(int departmentId) {
		try {
			connect();
			String sql = "DELETE FROM departments WHERE department_id="+departmentId;
			stmt = conn.createStatement();
			
			int result = stmt.executeUpdate(sql);
			if(result >0) {
				System.out.println(result+"건 삭제되었습니다.");
			}else {
				System.out.println("정상적으로 삭제되지 않았습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}

}
