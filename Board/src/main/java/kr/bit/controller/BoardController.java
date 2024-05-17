package kr.bit.controller;

import java.awt.print.Pageable;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.bit.beans.Content;
import kr.bit.beans.User;
import kr.bit.dao.BoardDao;
import kr.bit.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@Resource(name = "loginBean")
	private User loginBean;

	@GetMapping("/main")
	public String main(@RequestParam("board_info_idx") int board_info_idx,
			@RequestParam(value = "page", defaultValue = "1") int page, Model model) {

		model.addAttribute("board_info_idx", board_info_idx);

		String boardName = boardService.getBoardName(board_info_idx); // 팀명 추출메서드
		model.addAttribute("boardName", boardName);

		List<Content> contentLi = boardService.getContent(board_info_idx, page);
		model.addAttribute("contentLi", contentLi); // 게시글 목록

//		Page pBean=boardService.getCnt(board_info_idx, page);
//		model.addAttribute("pBean", pBean);
		model.addAttribute("page",page);

		return "board/main";
	}

	@GetMapping("/read")
	public String read(@RequestParam("board_info_idx") int board_info_idx, @RequestParam("content_idx") int content_idx,
			@RequestParam("page") int page, Model model) {

		model.addAttribute("board_info_idx", board_info_idx);
		model.addAttribute("content_idx", content_idx);

		Content readContent = boardService.getInfo(content_idx);
		model.addAttribute("readContent", readContent);

		model.addAttribute("loginBean", loginBean);
		model.addAttribute("page", page);

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
	public String modify(@RequestParam("board_info_idx") int board_info_idx,
			@RequestParam("content_idx") int content_idx, @ModelAttribute("modifyBean") Content modifyBean,
			@RequestParam("page") int page, Model model) {

		model.addAttribute("board_info_idx", board_info_idx);
		model.addAttribute("content_idx", content_idx);
		model.addAttribute("page", page);

		// 수정할 글 정보(글쓴이, 제목, 내용 등) 를 가져와서 업이트 시킨 후 뿌림
		Content temp = boardService.getInfo(content_idx);

		modifyBean.setContent_writer_name(temp.getContent_writer_name());
		modifyBean.setContent_date(temp.getContent_date());
		modifyBean.setContent_subject(temp.getContent_subject());
		modifyBean.setContent_text(temp.getContent_text());
		modifyBean.setContent_writer_idx(temp.getContent_writer_idx());
		modifyBean.setContent_board_idx(board_info_idx);
		modifyBean.setContent_idx(content_idx);

		return "board/modify";
	}

	@PostMapping("/modify_pro")
	public String modify_pro(@Valid @ModelAttribute("modifyBean") Content modifyBean, BindingResult result,
			@RequestParam("page") int page, Model model) {
		model.addAttribute("page", page);
		
		if(result.hasErrors()) {
			return "board/modify";
		}
//		boardService.modifyInfo(modifyBean);
		return "board/modify_success";
	}

	@GetMapping("/delete")
	public String delete() {
		return "board/delete";
	}

	@GetMapping("/not_writer")
	public String not_writer() {
		return "board/not_writer";
	}
}
