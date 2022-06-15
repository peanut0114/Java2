package com.yedam.java.WrapperStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

//d드라이브의 temp 파일 삭제 후 실행
public class CharterConvertExample {
	
	//입출력은 바이트 타입으로 진행되지만 실제 사용자가 문자로 입출력하고 싶을 때 사용
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("입력 문장 > ");
		String data = new Scanner(System.in).nextLine();
		write(data);
		read();
	}
	
	//출력스트림
	public static void write(String str) throws IOException {
		//1) 바이트기반 -> 일반 스트림
		OutputStream os = new FileOutputStream("D:/dev/temp/text1.txt"); //경로지정
		//os.write(str);	//바이트 기반이기때문에 값을 그대로는 못 넘김
							//직접 바이트타입을 스트링 타입으로 넘겨줘야 함 -> 그래서 보조스트림 이용함
		
		//2) 문자로 내보내고싶음 -> 보조스트림 이용 (최종 도착지가 스트림! -> 매개변수로 받음)
		Writer writer = new OutputStreamWriter(os);	//연결되어야 하는 스트림 정보를 받음 
		//프로그램 -> OutputStreamWriter -> FileOutputStream -> D:/dev/temp/text1.txt
		
		writer.write(str);	//스트링을 매개변수로 쓰는 .write() 이용하기 위해 write타입 쓰는거임
		writer.flush();
		writer.close();
	}
	
	//입력스트림
	public static void read() throws IOException {
		InputStream is = new FileInputStream("D:/dev/temp/text1.txt");	//위에서 만든 파일 읽음
		//보조스트림
		Reader reader = new InputStreamReader(is);	//연결되어야 하는 스트림 받음 (직접적으로 주고받음 불가, 경로X)
		
		char[] buffer = new char[100];	//읽는건 char타입 한번에 읽기위해 배열을 크게 줌
		int readCharNum = reader.read(buffer);	//.read()에 char 타입 넘겨줌
		reader.close(); //스트림닫음
		
		//문장으로 출력하기
		String data = new String(buffer, 0, readCharNum);	
		System.out.println(data);
	}

}
