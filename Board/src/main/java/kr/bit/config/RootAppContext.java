package kr.bit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.bit.beans.User;

@Configuration
public class RootAppContext {  //root-context.xml
	
	@Bean("loginBean")
	@SessionScope
	public User loginBean() {
		return new User();
	}
	
}
