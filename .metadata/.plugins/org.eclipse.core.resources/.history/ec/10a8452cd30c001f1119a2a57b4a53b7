package kr.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpringController {

	@RequestMapping(value = "/spring1", method = RequestMethod.GET)
	public String spring1() {
		return "spring1";
	}
	
	@RequestMapping(value = "/spring2", method = RequestMethod.POST)
	public String spring2() {
		return "spring2";
	}
	
	@GetMapping("/spring4")
	public String spring4() {
		return "spring4";
	}
	
	@PostMapping("/spring5")
	public String spring5() {
		return "spring5";
	}
	
	@RequestMapping(value = "/spring7", method = {RequestMethod.GET,RequestMethod.POST})
	public String spring7() {
		return "spring7";
	}
	
	@GetMapping("/spring8")
	public String spring8() {
		return "spring8";
	}
	
	@PostMapping("/spring8")
	public String spring88() {
		return "spring8";
	}
}
