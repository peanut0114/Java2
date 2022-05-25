package cmdNumGame;
/*
 * 
 */
public class GameSystem {

	private static int turn;	 //한 게임 내 시도 횟수
	Game game =  new Game();
	
	public GameSystem () {	//프로그램시작
		turn = 0;
	}
	
	public void upDown(int num) {
		turn++;
		
		if(num==game.getrand()) {
			System.out.println("**정답입니다!**");
		}
			
	}
}
