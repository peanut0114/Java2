package com.yedam.java.ch1501;

public class MainTest {

	public static void main(String[] args) {
		Bag bag = new Bag();	//bag에 담으면 object에 어떤 형태든 담을 수 있음
		
		bag.set(new Note());
		Note note = (Note) bag.get(); 
		//하지만 Object에 담았기 때문에 꺼내올 때는 강제로 타입변환 필요
		// -> 일을 두번해야하고(변환,리턴) 복잡해지면 꺼내올 때 원 타입을 명확하게 알 수 없음
		String note2 = (String) bag.get(); //문법상 문제가 없음 -> 오류발생
		
		bag.set("신운하");
		String name = (String)bag.get();
		
		
//--------------------------------제네릭타입 사용----------------------------------
		
		Box<Note, String, Integer> box = new Box<>();	//사용 전 어떤 형태로 쓸것인지 
		//기본 타입 사용x 대응되는 래퍼클래스 사용해야함. 
		//세가지 타입 이상은 못 담음. 구현 시에는 지정한 타입만 사용 가능
		box.setT(new Note());
		box.setK(500);
		box.setV("홍길동");
		
		Note memo = box.getT();	//별도의 타입 변환 없이 사용 가능
		int num = box.getK();	//자바에서도 타입에 따른 오류를 미리 찾아줌
		String str = box.getV();
		
		Box<Car, Bus, Texi> vehicle = new Box<>();
		//새로운 변수로 선언해야 새로운 타입 담을 수 있음
		vehicle.setT(new Car());
		vehicle.setK(new Texi());
		vehicle.setV(new Bus());
		
		Car car = vehicle.getT();
		Bus bus = vehicle.getV();
		Texi texi = vehicle.getK();
		
	}

}

class Car {}
class Bus {}
class Texi {}



