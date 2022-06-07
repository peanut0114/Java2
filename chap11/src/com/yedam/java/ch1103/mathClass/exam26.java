package com.yedam.java.ch1103.mathClass;
//Math 메소
public class exam26 {

	public static void main(String[] args) {
		//절대값
		int v1 = Math.abs(-5);			
		double v2 = Math.abs(-3.14);
		System.out.println("v1="+v1);
		System.out.println("v2="+v2);
		
		//올림값 : 오른쪽으로!
		double v3 = Math.ceil(5.3);		
		double v4 = Math.ceil(-5.3);
		System.out.println("v3="+v3);
		System.out.println("v4="+v4);
		//버림값 : 왼쪽으로!
		double v5 = Math.floor(5.3);	
		double v6 = Math.floor(-5.3);
		System.out.println("v5="+v5);
		System.out.println("v6="+v6);
		
		//최대값 : 앞뒤값을 계속 넣어서 비교해서 사용
		int v7 = Math.max(5, 9);		
		double v8 = Math.max(5.3, 2.5);
		System.out.println("v7="+v7);
		System.out.println("v8="+v8);
		//최소값
		int v9 = Math.min(5, 9);		
		double v10 = Math.min(5.3, 2.5);
		System.out.println("v9="+v9);
		System.out.println("v10="+v10);
		
		//랜덤값 : 비율 조절 못함 -> 하고싶을 땐 랜덤클래스!
		double v11 = Math.random();		
		System.out.println("v11="+v11);
		
		int num = (int)(Math.random()*10)+1; //1~10랜덤수
		
		//가까운 정수의 실수값 : .5는 애매함
		double v12 = Math.rint(5.3);	
		double v13 = Math.rint(5.7);
		System.out.println("v12="+v12);
		System.out.println("v13="+v13);
		
		//반올림 : 소수점 첫째자리에서 반올림함
		long v14 = Math.round(5.3);		
		long v15 = Math.round(5.7);
		System.out.println("v14="+v14);
		System.out.println("v14="+v14);
		//소수점 셋째자리에서 반올림하고싶으면 
		double value = 12.3456;
		double temp1 = value * 100;		//소수점의 위치 이동
		long temp2 = Math.round(temp1);	//반올림 후 
		double v16 = temp2/100.0;		//원래 숫자로 바꿔줌
		System.out.println("v16="+v16);
		
		}

}
