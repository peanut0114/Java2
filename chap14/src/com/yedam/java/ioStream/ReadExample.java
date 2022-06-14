package com.yedam.java.ioStream;

/*
 * Input스트림(시스템기준)
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {

	public static void main(String[] args) throws IOException {

		InputStream is = new FileInputStream("d:/dev/temp/test1.db");
		// 위치 중요
		// 출력은 바이트기반, 입력 리턴은 int 타입!

		// 리드메소드
		while (true) {
			// 종료조건
			int data = is.read(); // 리드 메소드로 읽는 값이 리턴되어 옴
			if (data == -1)
				break; // 해당 파일 끝에 도달하면 -1이 리턴됨
			System.out.println(data); // 아닌 경우 정보 출력
		}
		System.out.println("------------------------------");
		is.close(); // 스트림 종료

		// 배열로 넘긴 경우
		is = new FileInputStream("d:/dev/temp/test2.db"); // 배열로 입력한 파일
		byte[] buffer = new byte[100]; // 크기가 2면 딱 2개씩 읽음
										// 비어있는 바이트 배열을 줘야 함
										// 기존 값이 있는 배열이면 그걸 덮어써버림
		while (true) {
			int readByteNum = is.read(buffer); // 배열을 넣고 읽은 바이트 수 반환
			if (readByteNum == -1)
				break;
			for (int i = 0; i < readByteNum; i++) { // 리드가 읽은 갯수만큼 for문
				System.out.println(buffer[i]); // 실체 출력은 바이트 배열 이용
			}
			System.out.println();
		}
		System.out.println("------------------------------");
		is.close();

		// 배열로 넘긴 경우2 (앞에 쓴 버퍼를 다시 쓰면 뒤에 붙여쯤)
		is = new FileInputStream("d:/dev/temp/test3.db"); // 배열로 입력한 파일

		int readByteNum = is.read(buffer, 3, 2); // 버퍼배열의 세번째 인덱스부터 2칸만 가져오겠다
		for (int i = 0; i < (3 + readByteNum); i++) {
			System.out.println(buffer[i]);	
		}
		is.close();
		
		//db만의 값
		System.out.println("\ntest3 db===");
		is = new FileInputStream("d:/dev/temp/test3.db");  
		while (true) {
			int data = is.read();
			if(data ==-1) break;
			System.out.println(data);
		}
		
		is.close();
	}

}
