package memory;

public class EqualTest {

	public static void main(String[] args) {

		int[] a = new int[5];	//배열은 0으로 초기화
		int[] b = a;			//a의 주소를 받아옴 -> 같은 힙(객체) 참조 : 얕은복사
		int[] c = new int[a.length];	//new:다른객체. a배열과 길이 같은 배열
		System.arraycopy(a, 0, c, 0, a.length);	//11장 
		//a[0]부터 복사, c[0]에서부터 입력, a 길이만큼(전부) 복사 : 깊은복사
		
		b[0] = 100;
		
		System.out.println(a[0]);		
		System.out.println(a==b);	//같은 객체를 참조하는가?
		
		//스트링
		String s1 = new String("hello");
		String s2 = new String("hello");//새로 만들었기 때문에 다른 객체
		System.out.println(s1==s2);		//주소비교. 다른 객체 참조  -> false
		System.out.println(s1.equals(s2));//s1과 s2 문자 내용 비교
		
		String s3 = "hi";	//문자열 상수를 저장하는 곳이 따로 있음
		String s4 = "hi";	//이미 있는 상수 hi를 가져옴
		System.out.println(s3==s4); 	//같은 객체 참조하게 됨
		
		s1 = null;	//참조 끊어버림
		s2 = null;
	}

}
