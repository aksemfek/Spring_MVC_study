package kr.bit.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.bit.beans.Data;

@Controller
public class SpringController {

	@GetMapping("/t1")
	public String t1(Data data) {
		return "test1";
	}

	@PostMapping("/test1_proc")
	public String test1_proc(@Valid Data data, BindingResult result) {
		if(result.hasErrors()) {
			return "test1"; // error 메세지 띄울거임 -> 유효성 검사에 위배
		}
		return "test2"; // 입력한 값 띄움
	}

}
