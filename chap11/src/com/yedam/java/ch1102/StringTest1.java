package com.yedam.java.ch1102;
/*
 * String 클래스 메소드 : 원본 건드리지 않고 수정본 새로 만드는 것
 */
import java.io.UnsupportedEncodingException;

public class StringTest1 {

	public static void main(String[] args) {
		//byte 타입. 컴퓨터끼리 통신시 이 형태로 받음
		byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};
		//문자셋을 이클립스 설정 기반으로 해서 아스키코드를 읽음
		//사용자에게 보여주기 위해 text형태로 바꿔야함
		//그냥 집어넣는 방법을 많이 사용
		String str1 = new String(bytes);
		System.out.println(str1);
		
		String str2 = new String(bytes,6,4); //index 6(0부터 시작)에서부터 4개를 가져옴
		System.out.println(str2);
		System.out.println();
		
		//String 타입이 byte보다 용량이 큼. 통신에 용의친 않음
//String -> byte -> String
		String str = "안녕하세요";
		
		byte[] bytes1 = str.getBytes(); //Byte 변환, 배열로 넣음
		System.out.println(bytes1);		//통신을 함
		String strs1 = new String(bytes1);	//다시 String 타입으로 변환
		System.out.println(strs1);		//사람이 알 수 있는 형태로 보임, 데이터손실X
		System.out.println();
		
		try {
			byte[] bytes2 = str.getBytes("EUC-KR");	//getBytes할때 뭘 기준으로 인코딩할지 지정
			System.out.println(bytes2);
			String strs2 = new String(bytes2);	//기준이 없으면 제대로 디코딩 안 됨
			System.out.println(strs2);			//결과 깨짐
			String strs3 = new String(bytes2,"EUC_KR");//EUC-KR로 디코딩 하겠다고 해야 값을 처리함
			System.out.println(strs3);
		} 
		catch (UnsupportedEncodingException e) {	//EUC-KR를 자바가 모를수도 있으니 예외발생
			e.printStackTrace();					//(오타나 잘못된 정보일수도 있음)
		} System.out.println();
//charAt : 한 글자만 가져오기
		String ssn = "010624-1230123"; //주민번호를 보고 여자인지 남자인지를 알아보고자 함
		char gender = ssn.charAt(7);	//index 7번째 글자를 복사해옴 (index는 0부터 시작)
		switch(gender) {
		case '1':
		case '3':
			System.out.println("남자입니다.");
			break;
		case '2':
		case '4':
			System.out.println("여자입니다.");
			break;
		}
		for(int i=0;i<ssn.length();i++) {
			System.out.println(ssn.charAt(i)); //char형태의 배열처럼 하나하나 떼서 봄
		} System.out.println();	
//문자열 비교는 ==안됨! equals이용!	
		String val1 = "신민철";	//1. 새로운 인스턴스 생성
		String val2 = "신민철";	//2. 프로젝트 내를 뒤져봄> 동일한 값 있네!> 1과 똑같은 인스턴스 공유
		String val3 = new String("신민철");	//3. 새로운 인스턴스 생성
		
		if(val1.equals(val2)) {	//내부 값이 같은지 다른지 알 수 있음
			System.out.println("val1과 val2는 값이 같습니다.");
		} else {
			System.out.println("val1과 val2는 값이 다릅니다.");
		}
		
		if(val1.equals(val3)) {
			System.out.println("val1과 val3는 값이 같습니다.");
		} else {
			System.out.println("val1과 val3는 값이 다릅니다.");
		}
		
		if(val1==val2) {		//등호연산자==는 인스턴스 비교
			System.out.println("val1과 val2는 같은 인스턴스입니다.");
		} else {
			System.out.println("val1과 val2는 다른 인스턴스입니다.");
		}
		if(val1==val3) {
			System.out.println("val1과 val3는 같은 인스턴스입니다.");
		} else {
			System.out.println("val1과 val3는 다른 인스턴스입니다.");
		}	System.out.println();
//indexOf : 해당 단어가 어느 위치에서 시작되는지. 
		String subject = "자바 프로그래밍 & 스프링 정석";
		int location = subject.indexOf("프로그래밍"); //공백도 인식, 0부터 시작
		System.out.println(location);	
		
		// 보통 문장 안에 내가 찾는 단어가 있는 확인하는데 많이 사용
		if(subject.indexOf("자바")!= -1) {
			System.out.println("자바와 관련된 책");
		} else {
			System.out.println("자바와 관련 없는 책");
		}
//subString : 검색 위치에 따라 잘라냄 > indexOf와 잘 사용
		String result1 = subject.substring(subject.indexOf("프로그래밍"));
		System.out.println(result1);
		
		String ssn1 = "880815-1234567";
		System.out.println("생년월일 : "+ ssn1.substring(0,6)); //0부터 6전까지
		System.out.println("개별정보 : "+ ssn1.substring(7));	//7부터
//length : 길이
		String[] temp = {"1","2"};
		int val = temp.length;	//배열의 length는 필드 > ()가 없음
		
		System.out.println(ssn1.length());	//이건 메소드 > ()있음
		System.out.println();
//replace : 원하는 데이터 수정
		String oldStr = "java프로그래밍java";
		String newStr = oldStr.replace("java", "자바"); //한문장의 모든 단어 바꿈
		System.out.println(oldStr + " -> "+newStr);	//원본건드리지 않음
	}

}
