package hw0603;
//human 클래스
public class Human {

	private String name;
	private double height;
	private double weight;
	
	Human(String name, double height, double weight){
		this.name = name;
		this.height = height;
		this.weight = weight;
		}
	
	public void getInformation() {
		System.out.printf("%s님의 신장 %.1f, 몸무게 %.1f",
								name,height,weight);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}
