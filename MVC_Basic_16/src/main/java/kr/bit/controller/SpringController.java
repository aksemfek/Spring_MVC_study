package kr.bit.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PropertySources({ 
	@PropertySource("/WEB-INF/properties/data1.properties"),
	@PropertySource("/WEB-INF/properties/data2.properties") })
//properties => 실행 중 절대 변하지 않는 값들을 properties파일 안에 넣어줘야함
// ex) DB정보, 유효성 검사
public class SpringController {
	
	@Value("${aaa.a1}")  //properties파일에 작성한 값을 주입받는다
	private int a1;
	
	@Value("${aaa.a2}")
	private String a2;
	
	@Value("${bbb.b1}")
	private int b1;
	
	@Value("${bbb.b2}")
	private String b2;
	
	@Value("${ccc.c1}")
	private int c1;
	
	@Value("${ccc.c2}")
	private String c2;
	
	@Value("${ddd.d1}")
	private int d1;
	
	@Value("${ddd.d2}")
	private String d2;
	
	@GetMapping("/t1")
	public String t1() {
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(d1);
		System.out.println(d2);
		
		return "test1";
	}
}
