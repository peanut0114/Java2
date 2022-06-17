package com.yedam.java.emp;
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
/*
 * DAO
 * 가능한 싱글톤으로 만들것 : 이 인스턴스로만 접근하도록! (접속 연결관리)
 * CRUD작업을 전부 다룬다
 */
public class EmpDAO {
	// 싱글톤
	private static EmpDAO empDAO = null;// static필드는 프로젝트 시작할때 초기화됨 (안 쓰게 되면 불필요한 인스턴스)

	private EmpDAO() {
	} // private생성자

	public static EmpDAO getInstance() {// 이렇게 바꾸면 get메소드 호출되는 순간에 new연산자 호출되면서 인스턴스가 생기게됨
		if (empDAO == null) { // 사용 시점에 인스턴스를 생성하겠다 (생성시기 차이)
			empDAO = new EmpDAO(); // 널일때만 생성자 호출
		}
		return empDAO;
	}

	// Oracle(DB) 연결 정보
	String jdbc_driver;
	String oracle_url;
	String connectedId;
	String connectiedPwd;

	// 각 메소드에서 공통적으로 사용하는 필드
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

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

	// 3.CRUD 실행 : 어떤 기능 쓸거냐에 따라 달라짐, 항상 connect로 시작해서 disconnect로 끝남
	
	// 3-1) 전체조회 (각 건이 반환, 개수 모르므로 배열불가 -> list)
	public List<Employee> selectAll() {
		List<Employee> list = new ArrayList<>();
		try {								// SQL을 다루기때문에 try-catch 문으로 감싸줌
			connect(); // 시작하기 전에 커넥트

			String sql = "SELECT * FROM employees ORDER BY 2";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) { // rs의 한 행이 employees와 대응됨
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id")); // 해당 컬럼 값을 가져와서 다시 setter에 넣는다
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setJob_id(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setDepartmentId(rs.getInt("department_id"));

				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return list; // 리턴이 있을때는 대응되는 변수는 먼저 선언해서 널포인트 예외를 방지하자
	}

	// 3-2) 단건조회
	public Employee selectOne(int employeeId) {
		Employee emp = null; // 단건조회는 널 초기화(찾는 값이 없으면 null)

		try {
			connect();
			String sql = "SELECT * FROM employees WHERE employee_id=" + employeeId;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				emp = new Employee(); // 값이 있을때 인스턴스 생성

				emp.setEmployeeId(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setEmail(rs.getString(4));
				emp.setPhoneNumber(rs.getString(5));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setJob_id(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setDepartmentId(rs.getInt("department_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return emp;
	}

	// 3-3) 등록
	public void insert(Employee emp) {
		// dao 는 중간역할, 들어갈 내용은 프로그램이 입력받아 dao에 입력하면 쿼리문으로 바꿔서 넣음
		try {
			connect();
			String sql = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmployeeId()); // 1번째 값에 int 타입의 1000으로 대체함
			pstmt.setString(2, emp.getFirstName());
			pstmt.setString(3, emp.getLastName());
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp.getPhoneNumber());
			pstmt.setDate(6, emp.getHireDate());
			pstmt.setString(7, emp.getJob_id());
			pstmt.setDouble(8, emp.getSalary()); // salary
			pstmt.setDouble(9, emp.getCommissionPct());
			pstmt.setInt(10, emp.getManagerId());
			pstmt.setInt(11, emp.getDepartmentId());

			int result = pstmt.executeUpdate(); // DB로 쿼리 넘기기

			if (result > 0) {
				System.out.println(result + "건이 등록 완료되었습니다.");
			} else {
				System.out.println("등록되지 않았습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	// 수정
	public void update(Employee emp) {
		try {
			connect();
			String sql = "UPDATE employees SET salary=? WHERE employee_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, emp.getSalary()); // 1번째 값에 int 타입의 1000으로 대체함
			pstmt.setInt(2, emp.getEmployeeId());

			int result = pstmt.executeUpdate(); // DB로 쿼리 넘기기

			if (result > 0) {
				System.out.println(result + "건이 UPDATE 완료되었습니다.");
			} else {
				System.out.println("수정되지 않았습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 삭제
	public void delete(int employeeId) {
		try {
			connect();
			String sql = "DELETE FROM employees WHERE employee_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, employeeId);

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println(result + "건 삭제되었습니다.");
			} else {
				System.out.println("정상적으로 삭제되지 않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

}
