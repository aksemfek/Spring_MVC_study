package kr.bit.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class SpringController {

	// properties 빈으로 등록한 객체 주소값 주입받음
	@Autowired
	ReloadableResourceBundleMessageSource res;

	@GetMapping("/t1")
	public String t1(Model model, Locale locale) {
		
		System.out.println(locale);

		String str1 = res.getMessage("aaa.a1", null, null);
		String str2 = res.getMessage("bbb.b1", null, null);

		Object[] args = { 30, "seoul" };
		String str3 = res.getMessage("aaa.a2", args, null);

		String str4 = res.getMessage("aaa.a3",args, locale);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);


		model.addAttribute("args", args);

		return "test1";

	}

}
