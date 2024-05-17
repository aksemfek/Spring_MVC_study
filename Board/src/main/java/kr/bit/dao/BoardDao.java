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

		for (int i = 0; i < 500; i++) {

			boardMapper.addContent(writeContentBean);
		}
	}

	public String getBaordName(int board_info_idx) {
		return boardMapper.getBoardName(board_info_idx);
	}

	public List<Content> getContent(int board_info_idx, RowBounds rowBounds) {

		return boardMapper.getContent(board_info_idx, rowBounds.getOffset(), rowBounds.getLimit());
	}

	public Content getInfo(int content_idx) {
		return boardMapper.getInfo(content_idx);
	}

	public void modifyInfo(Content modifyBean) {
		boardMapper.modifyInfo(modifyBean);
	}

	public void deleteInfo(int content_idx) {
		boardMapper.deleteInfo(content_idx);
	}
	
	public int getCnt(int content_board_idx) {
		return boardMapper.getCnt(content_board_idx);
	}
}
