package memory;

public class MethodTest {

	public static void main(String[] args) {

		test1("#",20);
		test1("X",5);
		test1("@",2);
	}

	//인수
	public static void test1(String s,int length) {
		for (int i=0;i<length;i++) {
			System.out.print(s);
		}
		System.out.println();
	}
}
