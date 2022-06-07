package hw0603;
//Q2,Q3
public interface Keypad {
//사용방법을 정의 -> 동일한 방법의 다른 결과를 낼 때 변수 여럿 지정할 필요없어짐
//https://gmlwjd9405.github.io/2018/07/04/class-diagram.html
//UML을 읽을 수 있어야함
	
	public static final int NORMAL_MODE = 0;
	public static final int HARD_MODE = 1;
	
	public abstract void leftUpButton();
	public abstract void leftDownButton();
	public abstract void rightUpButton();
	public abstract void rightDownButton();
	public abstract void changeMode();
}
