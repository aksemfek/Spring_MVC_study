package kr.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;



@Controller
public class SpringController {
	
	@GetMapping("/t1")
	public String t1() {
		return "redirect:/main1";
	}
	
	@GetMapping("/main1")
	public String main1() {
		return "main1";
	}
	
	@GetMapping("/t2")
	public String t2(){
		return"forward:/main2";
	}
	
	@GetMapping("/main2")
	public String main2() {
		return "main2";
	}
}
