package com.yedam.java.ch1002;
/*
 * 예외 처리 -> try-catch-finally 코드
 */
public class MainTest {

	public static void main(String[] args) {
		try {
			//원래 실행하고자 한 코드
		} catch(Exception e) {
			//예외가 발생한 경우 처리코드
		} finally {
			//정상적이든 예외가 발생했든 반드시 실행되어야하는 코드 (선택사항)
		}
		
		String data1 = null;
		String data2 = null;
		
		try {
			int value = Integer.parseInt(data2);
			
			data1 = args[0];
			data2 = args[1];
		} 
		catch(ArrayIndexOutOfBoundsException e) {	//반드시 따로 처리할 예외는 catch로 따로 먼저 적고
			e.printStackTrace();	//예외 클래스가 갖고있는 정보를 출력
			System.out.println("실행 매개값의 수가 부족합니다.");
			return;	//현 위치 메소드를 종료 -> 메인이 바로 종료됨
		} 
		catch(NumberFormatException e) {
			System.out.println("숫자 형식에 맞춰 입력해주세요");
			
		}
		catch(Exception e) {	//항상 마지막에 들어가야 //위의 예외상황이 아닌 기타 예외 상태는 여기서 처리
			System.out.println("기타 예외");
			return;
		}
		finally {	//자원 정리할 때 자주 사용 RAM 등등
			System.out.println("필수 구문");
		}
		
		try {
			findClass();	//throws 넘겨준 예외를 다 catch문으로 적어야 함
		} catch (ClassNotFoundException e) {	//처리해야할 예외 정해져있음
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		System.out.println("메인 메소드 종료");
	}

	//실행예외는 문법적으로 문제없지만 예외처리를 필수로 하는 것도 존재
	//예외 떠넘기기 throws > 일시적 보류. 메소드를 호출하는 곳에서 처리하도록. (main에도 넘길 수 있음. 자바 요구로 어쩔수 없이.. but 예외처리 안하는것과 같음)
	//왜 try catch 안 하고 메소드 밖으로 떠넘기나? -> 예외를 어떻게 처리하는지는 회사마다 다 다름. 사용하는 쪽에서 조절 가능하도록 넘김.
	public static void findClass() throws ClassNotFoundException, NullPointerException{	//여러개 선언 가능
		//클래스의 메타정보를 가지는 클래스 Class (클래스 이름,필드,메소드 정보 등)
		Class clazz = Class.forName("java.lang.String"); //클래스의 풀 내임으로 가져욤
		//new의 개념X. 다른 클래스인 String의 정보를 가짐. ""안의 내용 못 읽음.실행해보아야 예외인지 아닌지 알 수 있음
		//문법적으론 문제 없지만 개발자의 경험. 문자열의 오타가 나거나 풀네임을 알지 못한다거나 하는 많은 예외가 발생했음
		//자바가 예외처리를 하도록 업데이트를 함.
	}

}




