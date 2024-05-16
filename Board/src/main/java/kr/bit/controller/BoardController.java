package kr.bit.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.bit.beans.Content;
import kr.bit.dao.BoardDao;
import kr.bit.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/main")
	public String main(@RequestParam("board_info_idx") int board_info_idx,
			@RequestParam(value = "page", defaultValue = "1") int page, Model model) {

		model.addAttribute("board_info_idx", board_info_idx);

		String boardName = boardService.getBoardName(board_info_idx); // 팀명 추출메서드
		model.addAttribute("boardName", boardName);

		List<Content> contentLi = boardService.getContent(board_info_idx, page);
		model.addAttribute("contentLi", contentLi); // 게시글 목록

		return "board/main";
	}

	@GetMapping("/read")
	public String read() {
		return "board/read";
	}

	@GetMapping("/write")
	public String write(@ModelAttribute("writeBean") Content writeBean,
			@RequestParam("board_info_idx") int board_info_idx) {

		writeBean.setContent_board_idx(board_info_idx); // 글쓰기 한 팀 세팅

		return "board/write";
	}

	@PostMapping("/write_pro") // 입력한 제목, 내용, 팀명 Content에 있는 필드에 주입
	public String write_pro(@Valid @ModelAttribute("writeBean") Content writeBean, BindingResult result) {
		if (result.hasErrors()) {
			return "board/write";
		}

		boardService.addContent(writeBean); // 작성하기 누르면 db에 삽입(글제목, 내용)
		return "board/write_success";
	}

	@GetMapping("/modify")
	public String modify() {
		return "board/modify";
	}

	@GetMapping("/delete")
	public String delete() {
		return "board/delete";
	}
}
