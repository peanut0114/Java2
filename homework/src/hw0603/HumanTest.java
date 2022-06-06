package hw0603;

public class HumanTest {

	public static void main(String[] args) {
		Human human;
		human = new StandardWeightInfo("홍길동", 168, 61.2);
		human.getInformation();
		human = new ObesityInfo("박둘이", 168, 90);
		human.getInformation();
		
	}

}
