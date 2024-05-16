package kr.bit.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.bit.beans.User;
import kr.bit.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Resource(name="loginBean")  //RootAppContext에 세션영역에 설정한 빈 이름과 같기때문에 주소값 자동주입
	private User loginBean;
	
	public boolean existId(String user_id) {
		
		String user_name=userDao.existId(user_id);
		if(user_name==null) {
			return true; //  사용할 수 있는 아이디면
		}
		return false; 
	}
	
	public void addUser(User joinBean) {
		userDao.addUser(joinBean);
	}
	
	public void getLoginUser(User loginProBean) {
		
		User loginProBean2=userDao.getLoginUser(loginProBean);
		
		if(loginProBean2!=null) { 
			loginBean.setUser_idx(loginProBean2.getUser_idx()); 
			//로그인되어있는 사람의 idx값 가져와서 User의 클래스의 필드(user_idx)에 세팅
			loginBean.setUser_name(loginProBean2.getUser_name());
			loginBean.setUserLogin(true);  //로그인이 되어있는 상태이므로 true
			
			
			//비번, 아이디가 일치하면 -> 로그인이 된 상태라면
			//세션영역에 담은 loginBean객체로부터 idx, name, 로그인 여부확인을 설정할거임
		}
		
	}

}
