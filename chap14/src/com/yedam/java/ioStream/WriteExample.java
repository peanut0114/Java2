package com.yedam.java.ioStream;
/*
 * Output스트림 (시스템기준)
 * int형 출력 -> byte 타입으로
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {

	public static void main(String[] args) throws IOException {
		OutputStream os = new FileOutputStream("d:/dev/temp/test1.db");
		// 파일을 출력할거라 FileOutput (지정 자리에 파일없으면 자동생성)
		// 외부파일 불러오는거라 예외처리 필요
		
		byte a = 10;// 데이터 보낼때는 항상 바이트타입으로 보내야 한다!
		byte b = 50;// 매개변수는 int 타입이지만 실제로 내보내는건 바이트타입
		byte c = 30;//	바이트기반!출력!

		os.write(a);// 쓰고자하는 파일을 넘겨줌
		os.write(b);
		os.write(c);

		os.flush(); // 스트림 안에 데이터 남아있을 수 있음 반드시 남아있을지 모르는 데이터 밀어내야함
		os.close(); // 출력 스트림 손실 막는 flush 후 스트림 닫음

		// 지정 위치로 가면 파일이 생겨있음!

		// 바이트 배열로도 보낼 수 있음(배열 통째로 넘기기)
		os = new FileOutputStream("d:/dev/temp/test2.db"); // 새로운 스트림
		byte[] array1 = { 20, 40, 70 };

		os.write(array1);

		os.flush();
		os.close();

		// 배열로 넘기면서 index로 출력하고자 하는 값을 지정
		os = new FileOutputStream("d:/dev/temp/test3.db"); // 새로운 스트림
		byte[] array2 = { 10, 20, 30, 40, 50 };

		os.write(array2,3,2);//3번째 인덱스부터 2개의 값을 출력하겠다

		os.flush();
		os.close();
		
		
	}

}
