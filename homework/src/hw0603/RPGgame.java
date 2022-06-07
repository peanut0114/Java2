package hw0603;
//Q2,Q3
public class RPGgame implements Keypad {
	//필드
	int mode;	//게임모드
	
	//생성자
	RPGgame(){
		this.mode = NORMAL_MODE; //노멀모드로 초기화
		System.out.println("**RPGgame 실행**");
	}
	
	@Override
	public void leftUpButton() {
		System.out.println("캐릭터가 위쪽으로 이동한다.");
	}

	@Override
	public void leftDownButton() {
		System.out.println("캐릭터가 아래쪽으로 이동한다.");
	}

	@Override
	public void rightUpButton() {
		if(mode==0) {
			System.out.println("캐릭터가 한 칸 단위로 점프한다.");
		}else if(mode==1) {
			System.out.println("캐릭터가 두 칸 단위로 점프한다.");
		}
	}

	@Override
	public void rightDownButton() {
		if(mode==0) {
			System.out.println("캐릭터가 일반 공격.");
		}else if(mode==1) {
			System.out.println("캐릭터가 HIT 공격.");
		}
	}

	@Override
	public void changeMode() {
		if(mode==0) {
			mode=1;
			System.out.println("MODE CHANGE\n현재모드 > HARD MODE");
		}else if(mode==1) {
			mode=0;
			System.out.println("MODE CHANGE\n현재모드 > NORMAL MODE");
		}
	}

}
