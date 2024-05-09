package kr.bit.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.bit.beans.Data;
import kr.bit.beans.Data2;

@Controller
public class SpringController {
	
	@GetMapping("/t1")
	public String t1(Data data, Model model) {
		
		data.setS1("d2");
		data.setS2("d2");
		data.setS3("d2");
		data.setS4("d2");
		
		String[] str = {"d1", "d3"};
		data.setS5(str);
		data.setS6(str);
		data.setS7(str);
		data.setS8(str);
		
		data.setS9("d2");
		data.setS10("d2");
		data.setS11("d2");
		data.setS12("d2");
		
		String str2[] = {"d1", "d2", "d3"};
		model.addAttribute("li1", str2);
		
		ArrayList<String> li2 = new ArrayList<String>();
		li2.add("d1");
		li2.add("d2");
		li2.add("d3");
		model.addAttribute("li2", li2);	
		
		Data2 b1 = new Data2();
		Data2 b2 = new Data2();
		Data2 b3 = new Data2();
		
		b1.setS1("one");
		b1.setS2("d1");

		b2.setS1("two");
		b2.setS2("d2");
		
		b3.setS1("three");
		b3.setS2("d3");
		
		ArrayList<Data2> li3 = new ArrayList<Data2>();
		li3.add(b1);
		li3.add(b2);
		li3.add(b3);
		model.addAttribute("li3", li3);	

		return "test1";
		
	}
	
}
