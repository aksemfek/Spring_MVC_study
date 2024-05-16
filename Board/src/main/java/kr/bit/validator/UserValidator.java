package kr.bit.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.bit.beans.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		User user = (User) target;
		String beanName = errors.getObjectName();

		// join.jsp에서 폼에다 데이터 입력 -> modelAttributte로 User클래스의 필드에 데이터 값이 저장되어 있는 상태(값
		// 주입한 상태)

		if (beanName.equals("joinBean")) {

			if (user.getUser_pw().equals(user.getUser_pw2()) == false) {
				errors.rejectValue("user_pw", "NotEqual");
				errors.rejectValue("user_pw2", "NotEqual");
			}
		}
		if(beanName.equals("joinBean")) {
			if(user.isExistId()==false) {
				errors.rejectValue("user_id", "NotCheck");		
			}
		}
	}

}
