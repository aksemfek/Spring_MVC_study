package kr.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpringController {
	
	@RequestMapping(value = "/spring1", method = RequestMethod.GET)
	public String Spring1() {
		return "spring1"; //spring1.jsp 화면 이동
	}
	
	@RequestMapping(value = "/spring2", method = RequestMethod.GET)
	public String Spring2() {
		return "spring2";
	}
	 
}
