package kr.bit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.bit.beans.Content;

public interface BoardMapper {

	// mysql에서 sql매퍼에 추가되는 옵션설정할 때 사용
	// useGeneratedKeys = true : 자동으로 생성하는 키 값을 mybatis가 사용할수 있도록 허용
	@Options(useGeneratedKeys = true, keyProperty = "content_idx")
	@Insert("INSERT INTO content_table(content_subject, content_text, content_writer_idx, content_board_idx, content_date) "
			+ "VALUES (#{content_subject}, #{content_text}, #{content_writer_idx}, #{content_board_idx}, CURRENT_DATE())")
	void addContent(Content writeContentBean);

	@Select("select board_info_name from board_info_table where board_info_idx=#{board_info_idx}")
	String getBoardName(int board_info_idx);

	@Select("SELECT a1.content_idx, a1.content_subject, a2.user_name AS content_writer_name, "
			+ "       DATE_FORMAT(a1.content_date, '%Y-%m-%d') AS content_date "
			+ "FROM content_table a1 JOIN user_table a2 " + "ON a1.content_writer_idx = a2.user_idx "
			+ "WHERE a1.content_board_idx = #{board_info_idx} " + "ORDER BY a1.content_idx DESC "
			+ "LIMIT #{offset}, #{limit}")
	List<Content> getContent(@Param("board_info_idx") int board_info_idx, @Param("offset") int offset,
			@Param("limit") int limit);

	@Select("SELECT a2.user_name AS content_writer_name, "
			+ "DATE_FORMAT(a1.content_date, '%Y-%m-%d') AS content_date, "
			+ "a1.content_subject, a1.content_text, a1.content_writer_idx "
			+ "FROM content_table a1 JOIN user_table a2 " + "ON a1.content_writer_idx = a2.user_idx "
			+ "WHERE content_idx = #{content_idx}")
	Content getInfo(int content_idx);
}
