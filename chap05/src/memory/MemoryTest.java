package memory;

public class MemoryTest {

	public static void main(String[] args) {

		int a = 10;
		int b = 20;
		
		test1(a,b);					//20:30
		
		System.out.println(a+":"+b);//10:20
		
		int[] sc = new int[2];	// new : 힙에 생성됨
		sc[0]=100;
		sc[1]=110;
		test2(sc);
		System.out.println(sc[0]+":"+sc[1]);
	}

	//힙 인수는 지워지지 않고 main으로 반환됨
	public static void test2(int[] sc) {
		sc[0] = sc[0] + 100;
		sc[1] = sc[1] + 100;
	}
	
	//스택 인수는 main으로 반환되지 않음
	public static void test1(int a, int b) {		
		a = a + 10;
		b = b + 10;
		System.out.println(a+":"+b);
		
	}
	
}
