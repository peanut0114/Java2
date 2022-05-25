package cmdNumGame;
/*
 * 게임 시작될때마다 초기화
 *
 */
public class Game {
	private int rand;		//정답
	private int guessNum[]= new int[10] ;	//추측한 숫자 저장
	
	public Game () {
		rand = (int) (Math.random()*100+1);
	}
	
	public int getrand() {
		return rand;
	}
	
}
