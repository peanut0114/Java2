package hw0603;

public class StandardWeightInfo extends Human{
	//생성자
	StandardWeightInfo(String name, double height, double weight) {
		super(name, height, weight);
	}

	//메소드
	
	@Override
	public void getInformation() {
		super.getInformation();
		method();
	}
	
	public double getStandardWeightInfo() {
		return (super.getHeight()-100)*0.9;
	}
	
	public void method() {
		System.out.printf(", 표준체중 %.1f입니다.\n",getStandardWeightInfo());
	}
	
}
