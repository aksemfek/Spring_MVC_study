package kr.bit.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.bit.beans.Data;
import kr.bit.beans.Data2;
import kr.bit.beans.Data3;
import kr.bit.beans.Data4;

@Controller
public class SpringController {
	
	@Autowired
	Data data1; // IoC컨테이너에 빈으로 등록한 Data객체의 주소값이 data1 필드에 자동 주입
	
	@Resource(name = "request2")
	Data2 data2;// IoC컨테이너에 빈으로 등록(@Bean)한 - 이름을 지정(request2)-Data2객체의 주소값이 data2 필드에 자동 주입
	
	@Autowired
	Data3 data3;
	
	@Resource(name="request4")
	Data4 data4;
	
	@GetMapping("/t1")
	public String t1() {
		data1.setStr1("스프링1");
		data1.setStr2("스프링2");
		
		data2.setStr3("스프링3");
		data2.setStr4("스프링4");
		
		data3.setStr5("스프링5");
		data3.setStr6("스프링6");
		
		data4.setStr7("스프링7");
		data4.setStr8("스프링8");
		
		return "forward:/final1";
	}
	
	@GetMapping("/final1")
	public String final1(Model model) {
		
		// model 객체에 data
		
		model.addAttribute("data1",data1);
		model.addAttribute("data2" ,data2);
		model.addAttribute("data3",data3);
		model.addAttribute("data4",data4);
		
		return "final";
		
	}
}
