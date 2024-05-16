package kr.bit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.bit.beans.BoardInfo;

public interface TopMenuMapper {
	
	/**
	 * 함수호출 시 위 쿼리문이 실행된다 -> 쿼리문 결과값들이 List에 저장됨
	 * 
	 */
	@Select("select board_info_idx, board_info_name from board_info_table order by board_info_idx")
	List<BoardInfo> getTopMenuList();
	
	
	
}
