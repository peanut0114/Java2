package com.yedam.java.ch1102;

public class StringTest2 {

	public static void main(String[] args) {
//toLowerCase & toUpperCase
		String str1 = "Java Programing";
		String str2 = "JAVA PROGRAMING";//논리적으로 같은 뜻을 가짐

		if(str1.equals(str2)) {				//대소문자 구분
			System.out.println("str1과 str2는 같은 값입니다.");
		}else {
			System.out.println("str1과 str2는 다른 값입니다.");
		}
		
		String val1 = str1.toLowerCase();
		String val2 = str2.toLowerCase();
		
		if(val1.equals(val2)) {	
			System.out.println("val1과 val2는 같은 값입니다.");
		}else {
			System.out.println("val1과 val2는 다른 값입니다.");
		}
		
		if(str1.equalsIgnoreCase(str2)) {	//대소문자 구분없이 값 비교
			System.out.println("str1과 str2는 같은 값입니다.");
		}else {
			System.out.println("str1과 str2는 다른 값입니다.");
		}
		
//trim : 앞뒤 공백제거 (중간은 못 건드림)
		String subject = "			자바    프로그래밍	 	 	 ";
		String newData = subject.trim();	//앞 뒤 공백 잘라냄
		System.out.println(newData+" 수업입니다");
		
		String newData1 = newData.substring(0,2);
		String newData2 = newData.substring(newData.indexOf("프로"));
		System.out.println(newData1+" "+newData2);
//valueOf : 다른 타입을 문자열로
		String value1 = String.valueOf(10);
		String value2 = String.valueOf(10.5);
		String value3 = String.valueOf(true);
		String value4 = ""+100; //빈문자열에 붙이면 자동으로 문자로 인식
		System.out.println(value1+" "+value2+" "+value3+" "+value4);
	}
	
}
