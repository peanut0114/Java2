package egovframework.example.sample.web;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import egovframework.example.sample.service.SampleVO;

@RestController
public class SampleRestController {

	@PostMapping(path="/json")
	public void jsonController(@RequestBody SampleVO sampleVO){
		System.out.println(sampleVO.getName());
		
	}
	
	@PostMapping(path="/json/map")
	public void jsonController2(@RequestBody HashMap<String, Object> param){
		HashMap<String, Object> map = new HashMap<String,Object>();
		SampleVO sample = new SampleVO();
		
//		vo.setName(sampleVO.getName());
//		System.out.println(vo.getName());
	}
	
}
