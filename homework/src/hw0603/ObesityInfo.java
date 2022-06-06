package hw0603;

public class ObesityInfo extends StandardWeightInfo {
	//생성자
	ObesityInfo(String name, double height, double weight) {
		super(name, height, weight);
	}

	//메소드
	@Override
	public void getInformation() {
		super.getInformation();
	}
	
	public double getObesity() {	//비만도 계산
		double standW = super.getStandardWeightInfo();
		return (super.getWeight()-standW)/standW*100;
	}
	
	public String getBmi() {	//비만도 분류
		double bmi = getObesity();	//비만도 계산값 가져옴
		String result;
		
		if(bmi<=18.5) {
			result = "저체중";
		}else if(18.5<bmi && bmi<23.0) {
			result = "정상";
		}else if(23.0<=bmi && bmi<25.0) {
			result = "과체중";
		}else if(25.0<=bmi) {
			result = "비만";
		}else {
			result = "BMI 측정 오류";
		}
		return result;
	}

	@Override
	public void method() {
		System.out.printf(", %s입니다.",getBmi());
	}
	
}
