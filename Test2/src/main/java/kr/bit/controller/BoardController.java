package kr.bit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.bit.entity.Board;
import kr.bit.mapper.BoardMapper;

@Controller
public class BoardController {

	@Autowired
	BoardMapper boardMapper;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/boardList")
	public @ResponseBody List<Board> boardList() {
		List<Board> list = boardMapper.getLists();
		return list;
	}

	@RequestMapping("/boardInsert")
	public @ResponseBody void boardInsert(Board vo) {
		boardMapper.boardInsert(vo);
	}

	@RequestMapping("/boardDelete")
	public @ResponseBody void boardDelete(@RequestParam("idx") int idx) {
		boardMapper.boardDelete(idx);
	}
	
	@RequestMapping("/boardUpdate")
	public @ResponseBody void boardUpdate(Board vo) {
		boardMapper.boardUpdate(vo);
	}
}