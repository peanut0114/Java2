package hw0603;

public class GameTestQ2 {

	public static void main(String[] args) {
		Keypad game = new RPGgame(); //RPGgame 실행
		
		game.leftUpButton();	//캐릭터가 위쪽으로 이동한다.
		game.rightUpButton();	//캐릭터가 한칸단위로 점프한다.
		game.changeMode();	//현재 모드 : HARD_MODE
		game.rightUpButton();	//캐릭터가 두칸단위로 점프한다.
		game.rightDownButton();	//캐릭터가 HIT 공격.
		game.leftDownButton();	//캐릭터가 아래쪽으로 이동한다.
		game.changeMode();	//현재 모드 : NORMAL_MODE
		game.rightDownButton();	//캐릭터가 일반 공격.
		
		System.out.println("======================");	
	
		game = new ArcadeGame();	//ArcadeGame 실행
		game.leftUpButton();	//캐릭터가 앞쪽으로 이동한다.
		game.rightUpButton();	//캐릭터가 일반 공격
		game.leftDownButton();	//캐릭터가 뒤쪽으로 이동한다.
		game.changeMode();	//현재 모드 : HARD_MODE
		game.rightUpButton();	//캐릭터가 연속 공격.
		game.leftUpButton();	//캐릭터가 앞쪽으로 이동한다.
		game.rightDownButton();	//캐릭터가 Double HIT 공격.
	}

}
