package hw0523;

/*
 * 1. 등록기능
 * 2. 전체조회 (점수 입력순 출력)
 * 3. 분석기능 (최고점, 최저점, 최고최저 제외한 평균점)
 */

public class ScoreList {

	int index;
	int scores[];
	
	ScoreList(){
		index = -1;
	}
	
	// 1. 학생수 입력
	void getNum(int size) {
		scores = new int[size];
	}
	
	//2. 학생점수 등록
	void getScore(int num) {
		if(index+1 <scores.length) {
			scores[++index] = num;		
		}else {
			System.out.println("더이상 입력할 수 없습니다.");
		}
	}
	
	//3. 학생점수 전체조회
	void viewScore() {
		for(int i=0 ; i<= index ; i++) {
			System.out.printf("%d) 점수 : %d점\n",i+1,scores[i]);
		} 
	}
	

	//4-1. 최고점
	int max() {
		int max = scores[0];
		for (int i=0 ; i<=index ; i++) {
			if(max < scores[i]) {
				max = scores[i];
			}
		}
		return max;
	}
	
	//4-2. 최저점
	int min() {
		int min = scores[0];
		for (int i=0 ; i<=index ; i++) {
			if(min > scores[i]) {
				min = scores[i];
			}
		}
		return min;
	}
	
	//4-3. 최고, 최저 뺀 평균값
	double avg() {
		int sum = 0;
		for (int i=0 ; i<=index ; i++) {
			sum += scores[i];
		}
		if(index<0) {
			return 0;
		}
		if(index<2) {
			return sum/(index+1);
		}
		sum -= max();
		sum -= min();
		return (double)sum/(index-1);	//
	}
	
	//4. 
	void result() {
		System.out.println("최댓값 : "+max());
		System.out.println("최솟값 : "+min());
		System.out.printf("평균 : %.2f",avg());
	}
}
