package com.yedam.java.dep;

import java.util.List;
import java.util.Scanner;

import com.yedam.java.emp.Employee;

public class DepSystem {

	private Scanner sc = new Scanner(System.in);
	private DepDAO dao = DepDAO.getInstance();
	private static int menu = 0;

	// 생성자
	public DepSystem() {

		while (true) {
			// 메뉴출력
			menuPrint();
			// 메뉴입력
			menuSelect();
			// 각 기능별 실행
			if (menu == 1) {
				// 등록
				insertDepartment();
			} else if (menu == 2) {
				//수정
				updateDepartment();
			} else if (menu == 3) {
				//삭제
				deleteDepartment();
			} else if (menu == 4) {
				//부서조회(단건)
				selectDepartment();
			} else if (menu == 5) {
				//전체조회
				selectAllDepartment();
			} else if (menu == 9) {
				exit();
				break;
			} else {
				inputError();
			}
			System.out.println();
		}
	}
	
	private void menuPrint() {
		System.out.println("==========================================");
		System.out.println(" 1.등록 2.수정 3.삭제 4.부서조회 5.전체조회 9.종료");
		System.out.println("==========================================");
	}
	private void menuSelect() {
		try {
			System.out.print("선택 > ");
			menu = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			menu = 0;
		}
	}
	private void exit() {
		System.out.println("\n프로그램을 종료합니다.");
	}

	private void inputError() {
		System.out.println("잘못된 입력입니다.");
	}

	private void insertDepartment() {
		//부서정보 입력
		Department dep = inputAll();
		//DB에 전달
		dao.insert(dep);
	}

	private void updateDepartment() {
		//수정 정보 입력
		Department dep = inputUpdateInfo();
		//DB에 전달
		dao.update(dep);
	}

	private void deleteDepartment() {
		//사원번호 입력
		int departmentId = inputDepartmentId();
		//DB에 전달
		dao.delete(departmentId);
	}

	private Department inputUpdateInfo() {
		Department dep = new Department();
		System.out.print("수정할 부서 번호 >> ");
		dep.setDepatementId(Integer.parseInt(sc.nextLine()));
		System.out.print("지역번호 >> ");
		dep.setLocationId(Integer.parseInt(sc.nextLine()));
		return dep;
	}

	private void selectDepartment() {
		//사원번호 입력
		int departmentId = inputDepartmentId();
		//DB에 검색
		Department dep = dao.selectOne(departmentId);
		//결과 출력
		if(dep != null) {
			System.out.println(dep);
		}else {
			System.out.println("원하는 정보가 존재하지 않습니다.");
		}
	}

	private int inputDepartmentId() {
		System.out.print("부서번호 > ");
		return Integer.parseInt(sc.nextLine());
	}

	private void selectAllDepartment() {
		List<Department> list = dao.selectAll();
		for(Department dep : list) {
			System.out.println(dep);
		}
		
	}


	
	private Department inputAll() {
		Department dep = new Department();
		
		System.out.print("부서번호 > ");
		dep.setDepatementId(Integer.parseInt(sc.nextLine()));
		System.out.print("부서이름 > ");
		dep.setDepartmentName(sc.nextLine());
		System.out.print("부서장 > ");
		dep.setManagerId(Integer.parseInt(sc.nextLine()));
		System.out.print("부서 위치번호 > ");
		dep.setLocationId(Integer.parseInt(sc.nextLine()));
		
		return dep;
	}
}
