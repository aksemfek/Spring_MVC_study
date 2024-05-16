package kr.bit.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import kr.bit.beans.Content;
import kr.bit.beans.User;
import kr.bit.dao.BoardDao;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {

	@Value("${page.listcount}")
	private int page_listcount;

	@Value("${page.pa}")
	private int page_pa;

	@Autowired
	private BoardDao boardDao;

	@Resource(name = "loginBean")
	private User loginBean;

	public void addContent(Content writeContentBean) { // 제목 내용 저장
		writeContentBean.setContent_writer_idx(loginBean.getUser_idx()); // 글작성자 idx값에 세팅
		boardDao.addContent(writeContentBean);
	}

	public String getBoardName(int board_info_idx) { // 팀이름 추출
		return boardDao.getBaordName(board_info_idx);
	}

	public List<Content> getContent(int board_info_idx, int page) {

		int start = (page - 1) * page_listcount;

		RowBounds rowBounds = new RowBounds(start, page_listcount);

		return boardDao.getContent(board_info_idx, rowBounds);
	}
}
