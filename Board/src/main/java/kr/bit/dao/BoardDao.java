package kr.bit.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.bit.beans.Content;
import kr.bit.mapper.BoardMapper;

@Repository
public class BoardDao {

	@Autowired
	private BoardMapper boardMapper;

	public void addContent(Content writeContentBean) {
		boardMapper.addContent(writeContentBean);
	}

	public String getBaordName(int board_info_idx) {
		return boardMapper.getBoardName(board_info_idx);
	}

	public List<Content> getContent(int board_info_idx, RowBounds rowBounds) {

		return boardMapper.getContent(board_info_idx, rowBounds.getOffset(), rowBounds.getLimit());
	}
	
	public  Content getInfo(int content_idx) {
		return boardMapper.getInfo(content_idx);
	}
}
