package kr.bit.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.synth.SynthScrollPaneUI;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.MvcNamespaceHandler;

import kr.bit.beans.Data;
import kr.bit.beans.Data2;

@Controller
public class SpringController {
	
	@GetMapping("/t1")
	public String t1() {
		return "test1";
	}
	
	@GetMapping("/t2")
	public String t2(HttpServletRequest request) {
		request.setAttribute("data1", 10);
		request.setAttribute("data2", 20);
		
		return "test2";
	}
	
	@GetMapping("/t3")
	public String t3(Model model) {
		model.addAttribute("data1", 30);
		model.addAttribute("data2", 40);
		
		return "test3";
	}
	
	@GetMapping("/t4")
	public ModelAndView t4(ModelAndView model) {
		
		model.addObject("data1", 50);
		model.addObject("data2", 60);
		
		model.setViewName("test4");
		
		return model;
	}
}
