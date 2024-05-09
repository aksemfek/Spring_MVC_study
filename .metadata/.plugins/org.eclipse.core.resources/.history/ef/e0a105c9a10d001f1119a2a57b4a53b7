package kr.bit.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import kr.bit.beans.Data;

@Controller
public class SpringController {

	@GetMapping("/t1")
	public String t1(HttpServletRequest request) {
		request.setAttribute("data1", "spring1");
		return "forward:/final1";
	}

	@GetMapping("/final1")
	public String final1(HttpServletRequest request) {

		String str = (String) request.getAttribute("data1");

		return "final1";
	}

	@GetMapping("/t2")
	public String t2(Model model) {

		model.addAttribute("data2", "spring2");
		return "forward:/final2";
	}
	
	@GetMapping("/final2")
	public String final2(HttpServletRequest request) {
		String str = (String) request.getAttribute("data2");
		
		return "final2";
	}
	
	@GetMapping("/t3")
	public String t2(ModelAndView mv) {

		mv.addObject("data3", "spring3");
		return "forward:/final3";
	}
	// 	값을 세팅만 할 수 있음. model, modelandview
	//  값을 세팅해서 브라우저로 전송할때 : requestScope클래스명
	// 값을 세팅해서 한번더 매핑을 시켜서 데이터 가져올때 getAttribute(HttpServletRequest)
	@GetMapping("/final3")
	public String final3(HttpServletRequest request) {
		
		request.getAttribute("data3");
		
		return "final3";
		
	}
	
	@GetMapping("/t4")
	public String t4(@ModelAttribute("bean") Data d1) {
		d1.setStr1("aa");
		d1.setStr2("bb");
		
		return "forward:/final4";
	}
	
	@GetMapping("/final4")
	public String final4(HttpServletRequest request) {
		Data d1 = (Data)request.getAttribute("bean");
		System.out.println(d1.getStr1());
		System.out.println(d1.getStr2());
		return "final4";
	}
	
}
