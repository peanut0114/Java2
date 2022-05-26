package com.yedam.java.ch0703;

public class AnimalTest {

	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		
		dog.sound();
		cat.sound();
		System.out.println();
		
		Animal animal = dog;	//타입변환, 다형성
		animal.sound();
		animal = cat;
		animal.sound();
	}
}
