package com.boot.board.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.boot.board.model.dto.Board;
import com.boot.board.model.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private ServletContext servletContext;
	
	@GetMapping("list")
	public String list(Model model,
			@RequestParam(defaultValue = "") String mode,
			@RequestParam(defaultValue = "") String keyword) {
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("mode", mode);
		params.put("key", keyword);
		List<Board> list = boardService.readBoardList(params);
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@GetMapping("writeForm")
	public String writeForm() {
		
		return "board/writeform";
	}
	
	@PostMapping("write")
	public String write(Board board, MultipartFile upload_file) { //만약에 file들어가면
		// 여기 file
		if(upload_file.getSize() != 0) {
			String uploadPath = servletContext.getRealPath("/file");
			String fileName = upload_file.getOriginalFilename();
			String saveName = UUID.randomUUID()+"";
			File target = new File(uploadPath, saveName);
			
			if(!new File(uploadPath).exists())
				new File(uploadPath).mkdirs();
			try {
				FileCopyUtils.copy(upload_file.getBytes(), target);
				board.setFileName(fileName);
				board.setFileUri(target.getCanonicalPath());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		boardService.writeBoard(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("detail")
	public String detail(Model model, int id) {
		model.addAttribute("board", boardService.readBoard(id));
		return "board/detail";
	}
	
	@GetMapping("updateForm")
	public String updateForm(Model model, int id) {
		model.addAttribute("board", boardService.readBoardById(id));
		return "board/updateform";
	}
	
	@PostMapping("update")
	public String update(Board board) {
		boardService.modifyBoard(board);
		return "redirect:/board/list";
//		return "redirect:/board/detail?id=" + board.getId();
	}
	
	@GetMapping("delete")
	public String delete(int id) {
		boardService.deleteBoard(id);
		return "redirect:/board/list";
	}
	
}
