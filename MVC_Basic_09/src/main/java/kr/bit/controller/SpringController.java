package kr.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.bit.beans.Data;

@Controller
public class SpringController {

	@GetMapping("/t1")
	public String t1(Data bean) { // 경로매핑 후에 필드에 값을 세
		bean.setName("길동");
		bean.setId("aa");
		bean.setPw("1234");
		bean.setAdr1("seoul");
		bean.setAdr2("gangnam");

		return "test1";
	}
	
	@GetMapping("/t2")
	public String t2(Data bean) { // 경로매핑 후에 필드에 값을 세
		bean.setName("관우");
		bean.setId("b");
		bean.setPw("2345");
		bean.setAdr1("seoul");
		bean.setAdr2("seocho");

		return "test2";
	}
	
	@GetMapping("/t3")
	public String t3(@ModelAttribute("modelBean") Data bean) {
		bean.setName("비룡");
		bean.setId("cc");
		bean.setPw("3456");
		bean.setAdr1("seoul");
		bean.setAdr2("mapo");

		return "test3";
	}
	
	@GetMapping("/t4")
	public String t4(Model model) {
		Data bean = new Data();
		bean.setName("유비");
		bean.setId("dd");
		bean.setPw("4567");
		bean.setAdr1("seoul");
		bean.setAdr2("yongsan");
		
		model.addAttribute("modelBean", bean);

		return "test4";
	}
}