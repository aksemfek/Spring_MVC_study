package kr.bit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.bit.beans.User;

public class LoginInterceptor implements HandlerInterceptor {

	private User loginBean;

	public LoginInterceptor(User loginBean) {
		this.loginBean = loginBean;
	}

	// 로그인 여부에 따라 주소를 입력해도 못들어가도록 막을거
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (loginBean.isUserLogin() == false) {
			String str = request.getContextPath(); // 첫 경로 알아내서

			response.sendRedirect(str + "/user/not_login"); // 로그인 안되어있으면 이 주소로 강제 이동
			return false;
		}
		return true;
	}
}
