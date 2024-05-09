package kr.bit.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.bit.beans.Data;

@Controller
public class SpringController {
	
	@GetMapping("/login")
	public String t1(Data data) {
		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute Data bean) {
		return "loginResult";
	}
	
}
