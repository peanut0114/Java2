package com.yedam.java.ch1502;

public class MainTest {

	public static void main(String[] args) {
	//	int result1 = Util.<String>compare("g","ㅎ"); //숫자만 받도록 막아둬서 오류남
		
		int result2 = Util.compare(1, 10);	//정수
		
		int result3 = Util.compare(0.5, 0.9); //실수 가능
	}

}
