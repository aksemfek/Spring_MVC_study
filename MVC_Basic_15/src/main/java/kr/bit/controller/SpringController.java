package kr.bit.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.bit.beans.Data;
import kr.bit.beans.Data2;
import kr.bit.beans.Data3;

@Controller
public class SpringController {

	@Autowired
	Data data1; // RootAppContext에 빈으로 등록한 Data 주소값을 자동주입받고 있

	@Resource(name = "session2")
	Data2 data2;

	@Autowired
	Data3 data3;

	@GetMapping("/t1")
	public String t1() {
		data1.setStr1("aa");
		data1.setStr1("bb");

		data2.setStr3("cc");
		data2.setStr4("dd");

		data3.setStr5("ee");
		data3.setStr5("ff"); // 값 주입한 객체들이 SessionScope임 => t1경로 매핑될 때 Bean 객체 주

		return "test1";
	}

	@GetMapping("/s1")
	public String s1(Model model) { // 세션 객체들 data1,2,3을 객체 모델 객체에 담

		model.addAttribute("data1", data1);
		model.addAttribute("data2", data2);
		model.addAttribute("data3", data3);

		return "spring1";
	}
}
