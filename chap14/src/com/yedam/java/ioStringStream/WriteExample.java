package com.yedam.java.ioStringStream;
/*
 * 문자기반 출력 : char, string 모두 가능
 * 자바가 다루는 타입이라 write 메소드가 알아서 char로 내보내는 것
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExample {

	public static void main(String[] args) throws IOException {
		// 문자기반 출력 스트림
		Writer writer = new FileWriter("d:/dev/temp/test7.db"); // 파일에 넣는거라 FileWriter

		char a = 'C';
		char b = 'A';
		char c = 'T';

		// 한글자씩 내보내기
		writer.write(a);
		writer.write(b);
		writer.write(c);

		writer.flush();
		writer.close();

		// char 배열을 이용해 한꺼번에 내보내기
		writer = new FileWriter("d:/dev/temp/test8.db");

		char[] array1 = { 'H', 'A', 'P', 'P','Y' };

		writer.write(array1);

		writer.flush();
		writer.close();
		
		//배열의 일부분만 보내기
		writer = new FileWriter("d:/dev/temp/test9.db");

		char[] array2 = { 'P', 'E', 'T', 'S','H','O','W' };
		writer.write(array2, 3,4);
		writer.flush();
		writer.close();
		
		//스트링으로 바로 내보내기 (자르는건 배열이든 스트링이든 전부 가능)
		writer = new FileWriter("d:/dev/temp/test10.db");
		String str1 = "ABCDE\n";
		String str2 = "abcde";
		
		writer.write(str1);
		writer.write(str2,3,2);
		
		writer.flush();
		writer.close();
	}

}
