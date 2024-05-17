package kr.bit.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.bit.beans.Content;
import kr.bit.beans.User;
import kr.bit.service.BoardService;

public class WriterInterceptor implements HandlerInterceptor {

	private User loginBean;
	private BoardService boardService;

	public WriterInterceptor(User loginUser, BoardService boardService) {
		this.loginBean = loginUser;
		this.boardService = boardService;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String str = request.getParameter("content_idx");
		int content_idx=Integer.parseInt(str);
		
		Content content=boardService.getInfo(content_idx);
		
		if(content.getContent_writer_idx() != loginBean.getUser_idx()) {
			String str2 = request.getContextPath();
			
			response.sendRedirect(str2 + "/board/not_writer");
			return false;
		}
		return true;
	}

}
