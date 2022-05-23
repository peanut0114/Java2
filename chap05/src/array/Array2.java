package array;

public class Array2 {

	public static void main(String[] args) {

		int[] intAry = new int[2]; // 1차원배열

		for (int i = 0; i < intAry.length; i++) {
			System.out.println("intAry[" + i + "]:" + intAry[i]);
		}

		// int[2]배열이 총 3개 존재하는 2차원배열
		int[][] intAry2 = new int[3][2]; // 다차원배열. 앞의 칸: 1차원배열의 개수. 뒤의 칸: 몇개의 int 값(생략가능)

		for (int i = 0; i < intAry2.length; i++) {
			int[] tempAry = intAry2[i];
			for (int j = 0; j < tempAry.length; j++) {
				System.out.println("tempAry[" + j + "]:" + tempAry[j]);
			}
		}

		for (int i = 0; i < intAry2.length; i++) {
			for (int j = 0; j < intAry2[i].length; j++) { // i번째 length!!
				System.out.printf("intAry2[%d][%d]:%d", i, j, intAry2[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		//계단형. 다차원배열의 각 행의 길이(열)를 다르게 넣을 수 있음
		int[][] intAry3 = new int[2][];	//보통 크기 고정X
		intAry3[0] = new int[3];
		intAry3[1] = new int[5];

		for (int i = 0; i < intAry3.length; i++) {
			for (int j = 0; j < intAry3[i].length; j++) {
				System.out.printf("intAry3[%d][%d]:%d ", i, j, intAry3[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		int[][] scores = {{95,80},{92,96,80}};
		for(int i=0; i<scores.length;i++) {
			for(int j=0;j<scores[i].length;j++) {
				System.out.printf("scores[%d][%d]:%d\n",i,j,scores[i][j]);
			}
		}
		
		/*
		 * 향상된 for문
		 * index 사용X (정확한 길이 입력x)
		 * 특정 경우의 for문 간소화시킨 것 (모든 수 출력시 사용)
		 */
		for(int[] tempAry : scores) {	//tempAry:임시변수. scores의 배열을 하나씩 받아옴
			for(int temp : tempAry) {	//tmpaAry 배열의 int값 하나씩 받아옴
				System.out.println(temp);
			}
		}
	}

}
