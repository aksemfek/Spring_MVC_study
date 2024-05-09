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
	public String t1() {
		return "test1";
	}

	

	@PostMapping("/test1_proc") //form에 쓴 값이 주입됨
	public String test1_proc(@Valid Data data1, BindingResult result) {
		//@Valid: 메서드에 주입받는 빈에 유효성 검사를 실시하겠다라는 선언!!
		//BindingResult: 유효성 검사를 실행한 결과정보가 저장되어있음 -> jsp파일...
		/*System.out.println(data1.getNum1());
		System.out.println(data1.getNum2());
		System.out.println(result);*/
		
		if(result.hasErrors()) {
			for(ObjectError obj : result.getAllErrors()) {
				System.out.println("코드: "+ obj.getCode()); //에러코드 어케 출력되는지 확인
				System.out.println("이름: "+obj.getObjectName());
				System.out.println("메시지:" +obj.getDefaultMessage());
				
				String [] str=obj.getCodes();
				for(String s:str) {
					System.out.println(s);
				}
				if(str[0].equals("Size.data.num2")) {
					System.out.println("num2 글자수 잘못됨!! 다시써라!!!!");
				}
				else if(str[0].equals("Max.data.num1")) {
					System.out.println("num1값 최대100이야!! 다시써줘");
				}
			}
			return "test1";  //유효성검사에 위배되면 다시 form형태로 감
		}
		return "test2"; //유효성검사에 맞으면 test2.jsp가서 내가 입력한 값을 띄운다
	}
}
