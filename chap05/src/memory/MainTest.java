package memory;
/*
 * 187p
 */
public class MainTest {

	public static void main(String[] args) {
		int sum = 0;
		if(args!=null) {
			for(int i=0 ; i<args.length;i++) {
				System.out.println(args[i]);
				sum += Integer.parseInt(args[i]);
			}
		}
		System.out.println("합계 = "+sum);
	}

}
