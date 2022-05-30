package com.yedam.java.ch0901;

public class OutterTest {
	public static void main(String[] args) {
		Outter outter = new Outter();
		
		Outter.Nested nested = outter.new Nested();
		nested.print();
		
	}

}
