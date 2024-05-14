package kr.bit.validator;

import javax.validation.Validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.bit.beans.Data;

public class DataValidator implements Validator {

	/**
	 * <validator 커스터마이징> 1. Validator 인터페이스 구현 2. controller에 인터페이스 등록
	 */

	@Override
	public boolean supports(Class<?> clazz) {
		// 유효성 검사할 데이터를 가지고 있는 객체가 유효성 검사가 가능한지 확인
		return Data.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// 유효성 검사하는 메서드
		ValidationUtils.rejectIfEmpty(errors, "num2", "error2"); // num2가 empty면 에러이름은 error2로 함
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "num3", "error3"); 
		
		Data d = (Data)target;
		
		String str1 = d.getNum2();
		String str2 = d.getNum3();
		if(str1.length()>5) {
			errors.rejectValue("num2", "error4"); //num2 길이가 5자리 넘어가면 error4라는 이름으로 에러정의
		}
		
		if(str2.contains("-")==false) {
			errors.rejectValue("num3", "error5");
		}
	}

}
