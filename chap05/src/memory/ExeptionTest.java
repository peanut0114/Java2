package memory;

public class ExeptionTest {

	public static void main(String[] args) {

		int[] a = new int[5];
		System.out.println(a[0]);
		//System.out.println(a[5]);
		
		int[] b = null;
		if (b!=null) {
			System.out.println(b[0]);
		}
		
	}

}
