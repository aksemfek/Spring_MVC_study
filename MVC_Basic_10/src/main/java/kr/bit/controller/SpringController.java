package kr.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.bit.beans.Data;

@Controller
public class SpringController {
	
	@GetMapping("/t1")
	public String t1(Data data) {
		data.setStr1("str1");
		data.setStr1("str2");
		data.setStr1("str3");
		data.setStr1("str4");
		
		return "test1";
	}
	
}
