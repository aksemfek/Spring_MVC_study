package kr.bit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import kr.bit.beans.Data;
import kr.bit.beans.Data2;

@Configuration
public class RootAppContext { // root-context.xml
	
	@RequestScope // 요청 발생할때마다 bean 객체가 생성되어 자동으로 주입
	@Bean
	public Data data() {
		return new Data();
	}
	
	@Bean("request2")
	@RequestScope
	public Data2 data2() {
		return new Data2();
	}

}
