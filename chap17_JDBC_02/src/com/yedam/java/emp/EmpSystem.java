package com.yedam.java.emp;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;
/*
 * 프로그램이 동작하는 클래스
 */
public class EmpSystem {
	//시스템에서 필요한 필드 : DB제한 클래스 EmpDAO의 인스턴스  + 유저에게 입력받는 스캐너
	private EmpDAO dao = EmpDAO.getInstance();
	private Scanner sc = new Scanner(System.in);
	
	//생성자 - 프로그램 동작	
	public EmpSystem() {	
		//생성자 안에 while문 넣고, 각각 기능을 메소드로 정리 -> 이렇게 시작하면 놓치는 부분 줄어듬
		while(true) {
			//메뉴 출력
			mueuPrint();
			//메뉴 입력
			System.out.println("메뉴 선택 > ");
			int menuNo = selectMenu();
			//각 기능별 실행
			if(menuNo==1) {
				//등록
				insertEmployee();
			}else if(menuNo==2){
				//수정
				updateEmployee();
			}else if(menuNo==3){
				//삭제
				deleteEmployee();
			}else if(menuNo==4){
				//사원조회(단건조회)
				selectEmployee();
			}else if(menuNo==5){
				//전체조회
				selectAllEmployee();
			}else if(menuNo==9) {
				exit();
				break;
			}else {
				inputError();
			}
		}System.out.println();
	}
	
	//private 메소드 : 생성자 안에서만 작동하도록 구성
	private void mueuPrint() {	
		System.out.println("==========================================");
		System.out.println(" 1.등록 2.수정 3.삭제 4.사원조회 5.전체조회 9.종료");
		System.out.println("==========================================");
	}

	private int selectMenu() {
		int menu=0;
		try {
			menu = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력해주세요.");	//munu=0 -> inputError() 갔다가 다시 처음으로
		}
		return menu;
	}
	
	private void exit() {
		System.out.println("\n프로그램을 종료합니다.");
	}
	
	private void inputError() {
		System.out.println("메뉴에 맞게 입력해주세요.");
	}
	
	private void insertEmployee() {
		//사원정보 입력
		Employee emp = inputAll();	//Employee형태로 정보 입력받음
		//DB에 전달
		dao.insert(emp);	//dao의 insert메소드를 통해 정보 전달
	}


	private void updateEmployee() {
		//수정하는 정보 입력
		Employee emp = inputUpdateInfo();	//Employee형태로 정보 입력받음
		//DB에 전달
		dao.update(emp);
	}

	private void deleteEmployee() {
		//사원번호 입력
		int employeeId = inputEmployeeId();
		//DB에 전달
		dao.delete(employeeId);
	}

	private void selectEmployee() {
		//사원번호 입력
		int employeeId = inputEmployeeId();
		//DB에 검색
		Employee emp = dao.selectOne(employeeId);
		//결과 출력
		if(emp != null) {
			System.out.println(emp);
		}else {
			System.out.println("원하는 정보가 존재하지 않습니다.");
		}
	}

	private void selectAllEmployee() {
		//있는 값만 받아서 출력할거라 널값 신경 X
		List<Employee> list = dao.selectAll();
		for(Employee emp : list) {
			System.out.println(emp);
		}
	}
	
	private Employee inputAll() {
		Employee emp = new Employee();
		System.out.print("사번 >> ");
		emp.setEmployeeId(Integer.parseInt(sc.nextLine()));
		System.out.print("이름 >> ");
		emp.setFirstName(sc.nextLine());
		System.out.print("성 >> ");
		emp.setLastName(sc.nextLine());
		System.out.print("이메일 >> ");
		emp.setEmail(sc.nextLine());
		System.out.print("전화번호 >> ");
		emp.setPhoneNumber(sc.nextLine());
		System.out.print("입사일(YYYY-MM-DD) >> ");
		emp.setHireDate(Date.valueOf(sc.nextLine()));	//스캐너는 데이터 타입 못 받아서 변환필요
		System.out.print("직급 >> ");
		emp.setJob_id(sc.nextLine());
		System.out.print("연봉 >> ");
		emp.setSalary(Double.parseDouble(sc.nextLine()));
		System.out.print("상여 >> ");
		emp.setSalary(Double.parseDouble(sc.nextLine()));
		System.out.print("상사 >> ");
		emp.setManagerId(Integer.parseInt(sc.nextLine()));
		System.out.print("부서 >> ");
		emp.setDepartmentId(Integer.parseInt(sc.nextLine()));
		
		return emp;
	}

	private Employee inputUpdateInfo() {
		Employee emp = new Employee();
		System.out.println("수정할 사원의 사번 >> ");
		emp.setEmployeeId(Integer.parseInt(sc.nextLine()));
		System.out.println("연봉 >> ");
		emp.setSalary(Double.parseDouble(sc.nextLine()));
		return emp;
	}

	private int inputEmployeeId() {
		System.out.println("사번 >> ");
		return Integer.parseInt(sc.nextLine());
	}
}
