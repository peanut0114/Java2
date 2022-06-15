package com.yedam.java.WrapperStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferStreamExample {
	
	static int data = -1;

	public static void main(String[] args) throws Exception {
		//1) buffer 스트림이 없는 경우 (기존방식)
		//복사하는 파일의 주소 필요
		String originalFilePath1 
		= BufferStreamExample.class.getResource("originalFile1.jpg").getPath();
		//.class : 이 클래스의 모든 정보를 담고있는 클래스 클래스가 생성됨
		//동일한 패키지 안의 파일을 찾는 getResource / 파일의 주소(위치)를 찾는 getPath
		//개발공간과 실제 돌아가는 서버 위치가 달라짐. 개발하면서 설정한 경로가 틀어질 수 있기 때문에(고정x)
		//물리적 위치로 경로를 설정하지 않고, 지금 존재하는 프로젝트의 위치를 가져옴 
		String targetFilePathe1	= "D:/dev/temp/targerFile1.jpg";
		InputStream fis1 = new FileInputStream(originalFilePath1);
		OutputStream fos1 = new FileOutputStream(targetFilePathe1);
		
		long nonBufferTime =  copy(fis1, fos1);
		System.out.println("버퍼를 사용하지 않았을 때 : \n"+nonBufferTime+" ns");
		fis1.close();
		fos1.close();
		
		//2) buffer 스트림이 있는 경우
		String originalFilePath2 
		= BufferStreamExample.class.getResource("originalFile2.jpg").getPath();
		
		String targetFilePathe2	= "D:/dev/temp/targerFile2.jpg";
		InputStream fis2 = new FileInputStream(originalFilePath2);
		OutputStream fos2 = new FileOutputStream(targetFilePathe2);
		
		//보조 버퍼 스트림 붙이기
		BufferedInputStream bis = new BufferedInputStream(fis2);//연결하고자하는 인풋스트림정보
		BufferedOutputStream bos = new BufferedOutputStream(fos2);//아웃풋스트림 연결
		
		nonBufferTime = copy(bis, bos);	//보조 스트림을 통해 값을 받음
		System.out.println("버퍼를 사용했을 때 : \n"+nonBufferTime+" ns");
		fis2.close();
		fos2.close();
	}	//결과 : 100배정도 버퍼가 빠름
	
	
	//외부 이미지 읽어들여서 바로 복사
	public static long copy(InputStream is, OutputStream os) throws Exception {
		long start = System.nanoTime();//읽기 시작하는 시간
		
		while(true) {
			data = is.read();	//읽어들이고
			if(data==-1)break;//끝이아니면
			os.write(data);		//그것만큼 바로 씀
		}
		
		long end = System.nanoTime();//끝낸 시간
		
		return(end -start);	//걸린 시간 반환
	}
}
