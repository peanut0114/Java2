package com.yedam.java.ch0606;

class A {}	//default

class B {	//동일한 패키지 내 사용 가능
	A a;	
	
	B(A a){
		this.a=a;
	}
	
	void method() {
		A a;
	}
}
