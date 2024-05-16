package kr.bit.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.bit.beans.BoardInfo;
import kr.bit.beans.User;
import kr.bit.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor {

	private TopMenuService topMenuService;

	@Resource(name="loginBean")
	private User loginBean;

	public TopMenuInterceptor(TopMenuService topMenuService, User loginBean) {
		this.topMenuService = topMenuService;
		this.loginBean = loginBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		List<BoardInfo> team=topMenuService.getTopMenuList();
		request.setAttribute("team", team);
		request.setAttribute("loginBean", loginBean);
		
		return true;
	}

}
