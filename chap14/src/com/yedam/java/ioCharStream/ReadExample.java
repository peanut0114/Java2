package com.yedam.java.ioCharStream;
/*
 * 문자기반 입력 : 읽을 땐 string으로 읽을 수 없다
 * 모든 컴이 통신할 수 있는 단위인 byte 기반으로 읽음 (char=2byte)
 */
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample {

	public static void main(String[] args) throws IOException {
		Reader reader = new FileReader("d:/dev/temp/test7.db");	//기존 데이터 읽어오기
		//파일 크기를 모르므로 while
		while(true) {
			int data = reader.read();		
			if(data == -1) break;			//자료 끝에 도달하면 break 아니면 출력
			System.out.println((char)data);	//char타입으로 강제 변환해서 원하는 타입으로 읽기
		}
		System.out.println();
		reader.close();
		
//		//숫자테스트 했던 파일도 읽어올 수 있음
//		reader = new FileReader("d:/dev/temp/test1.db"); 
//		while(true) {
//			int data = reader.read();	
//			if(data == -1) break;			
//			System.out.println(data);	//동작자체는 같고 다루는 형태가 다를 뿐
//		}
//		System.out.println();
//		reader.close();
		
		//char타입 배열 이용
		reader = new FileReader("d:/dev/temp/test8.db");
		char[] buffer = new char[100];	//배열 크기가 2면 read로 한번에 읽을 수 있는 수가 2개
								//배열 크기가 클수록 한번에 읽을 수 있는 글자 수가 늘어남
		while(true) {
			int readCharNum = reader.read(buffer);	//buffer 배열엔 값이, 리턴은 갯수
			if(readCharNum == -1) break;			
			for(int i=0; i<readCharNum ; i++) {	//배열크기 이용
				System.out.println(buffer[i]);
			}
			System.out.println();
		}
		reader.close();
		
		reader = new FileReader("d:/dev/temp/test10.db");
		
		int readCharNum = reader.read(buffer,6,15);	//기존에 썼던 버퍼 이용
									//6번째 부터 15개 문자 출력
									//앞에 들어간 5개 문자 외의 빈자리 널값생김
									//왜 e 안 보이지??
		for(int i=0 ; i< (5+readCharNum);i++) {
			System.out.print(buffer[i]);
		}
		
		reader.close();
		
	}

}
