package cmdNumGame;
/*
 * 게임 시작될때마다 초기화
 *
 */
public class Game {
	private int rand;		//정답
	private int guessNum ;	//추측한 숫자 저장
	private static int index; 
	
	public Game () {						//게임 시작시 정답 저장
		rand = (int) (Math.random()*100+1);
		index = 0;
	}
	
	public int getrand() {
		return rand;
	}
	
	public void setGuessNum(int num) {
		this.guessNum=num;
		index++;
	}
	public int getGuessNum() {
		return guessNum;
	}
	public int getIndex() {
		return index;
	}
}
