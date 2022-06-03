package com.yedam.java.ch1101;
/* 실질적으로 같은 타입이면서 같은 필드를 가지고 있는지알려면
 * 이퀄즈 논리적 동등, 해시코드 물리적 동등 비교
 * 해시코드만으로 비교하면 다른 클래스의 동일한 형태의 int 필드를 같다고 인식하게 됨
*/
import java.util.HashMap;
import java.util.Map;

public class KeyTest {

	public static void main(String[] args) {
		//map : 값을 하나의 세트로 가짐 일종의 there ((이건뭔데..
		Map<Key, String> map = new HashMap<Key, String>();
		
		map.put(new Key(1),"홍길동");	//key는 유니크해야함
		
		String value = map.get(new Key(1));	//필드가 동일하게 1들어감
		//위 의 두 new Key는 해시코드가 다름. 동일한 메모리가 아니라면 동등x
		//같은 클래스의 같은 필드값을 같은 인스턴스로 인식하게 하기 위해서는 오버라이딩 해줘야 함.
		//String은 new쓰면 다르게 인식함 그냥 ""로 넣어야 함
		
		System.out.println(value);
		System.out.println(map);
	}

}

