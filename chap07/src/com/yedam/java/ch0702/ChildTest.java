package com.yedam.java.ch0702;
/*
 * 상속관계
 * 부모자식 간에 형변환 가능
 * 상속 관계 외에는 강제형변환 불가능
 */
public class ChildTest {

	public static void main(String[] args) {

		Father father = new Father();
		Uncle uncle = new Uncle();
		Child child = new Child();
		Cousin cousin = new Cousin();
		
		GranPa pa = father;	//부모자식 간에 타입변환 가능
		pa.method();
		pa = uncle;
		pa.method();
		pa = child;
		pa.method();
		pa = cousin;
		pa.method();
		
		System.out.println();
	//	Father fa = nucle;	//형제 != 상속관계. 타입변환 불가
	//	fa=child;
	//	fa=cousin;
		
		Father fa = child;
		fa.method();
		
		Child ch = (Child)fa;	//강제형변환 가능 (상속관계 안에서만 가능)
	//	Cousin co = (Cousin)fa;	//강제변환 불가. 직접연관x 
		
		System.out.println();
		Uncle un = cousin;
		un.method();
	//	un = father;		//강제타입변환도 불가능
	//	un = child;
	}

}
