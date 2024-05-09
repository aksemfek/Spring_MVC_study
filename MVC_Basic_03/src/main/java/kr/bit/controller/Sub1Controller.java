package kr.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Sub1Controller {

	
	@RequestMapping(value = "sub1/spring3", method =  RequestMethod.GET)
	public String spring3() {
		return "sub1/spring3";
	}
	
	@RequestMapping(value = "sub1/spring4", method =  RequestMethod.GET)
	public String spring4() {
		return "sub1/spring4";
	}
}
