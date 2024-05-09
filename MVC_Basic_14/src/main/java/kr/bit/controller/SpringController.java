package kr.bit.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.bit.beans.Data;

@Controller
@SessionAttributes({"sbean","sbean2"}) // ModelAttribute로 주입시, Session으로 영역 지정하면 Session으로 변
public class SpringController {

	// 주의할점 @ModelAttribute를 활용해 객체를 생성해 변환되는 메서드 작성해줘야지 Session 영역으로 변
	@ModelAttribute("sbean")
	public Data dbean() {
		return new Data();
	}
	
	@ModelAttribute("sbean2")
	public Data dbean2() {
		return new Data();
	}
	
	@GetMapping("/t5") // request 영역에 저장
	public String t5(@ModelAttribute("sbean") Data dbean, @ModelAttribute("sbean2") Data dbean2) {

		dbean.setStr1("aa");
		dbean.setStr2("bb");

		dbean2.setStr1("cc");
		dbean2.setStr2("dd");

		return "test5";

	}
	
	@GetMapping("/s5")
	public String s5(@ModelAttribute("sbean") Data dbean, @ModelAttribute("sbean2") Data dbean2) {
		return "spring5";
	}
	
	@GetMapping("/t1")
	public String t1(HttpSession session) {

		session.setAttribute("data1", "spring1");

		return "test1";

	}

	@GetMapping("/t2")
	public String t2(HttpSession session) {
		session.setAttribute("data1", "spring2");
		return "redirect:/s1";
	}

	@GetMapping("/s1")
	public String s1(HttpSession session) {
		String str = (String) session.getAttribute("data1");
		System.out.println(str);
		return "spring1";
	}

	@GetMapping("/t3")
	public String t3(HttpSession session) {
		session.setAttribute("data1", "spring3");
		return "forward:/s1";
	}

	@GetMapping("/t4")
	public String t4(HttpSession session) {
		Data data = new Data();

		data.setStr1("spring4");
		data.setStr2("spring5"); // 객체에 값 저장

		session.setAttribute("bean", data); // 세션영역에 저장

		return "test4";
	}

	@GetMapping("/s4") // session에 저장되어 있는 객체를 사용하고자 할때
	public String s4(@SessionAttribute("bean") Data d) {
		return "spring4";
	}

	

}
