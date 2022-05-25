package cmdNumGame;
/*
 * 게임 시작될때마다 초기화
 *
 */
public class Game {
	private int rand;		//정답
	private int guessNum[]= new int[10] ;	//추측한 숫자 저장
	private static int index;
	
	public Game () {						//게임 시작시 정답 저장
		rand = (int) (Math.random()*100+1);
		index = -1;
	}
	
	public int getrand() {
		return rand;
	}
	
	public void setGuessNum(int num) {
		this.guessNum[++index]=num;
	}
	public int getGuessNum() {
		return guessNum[index];
	}
	public int getIndex() {
		return index;
	}
}
