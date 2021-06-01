package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.dao.BoardDao;
import spring.dto.BoardDto;

@Controller
public class BoardContentController {
	@Autowired
	BoardDao dao;
	
	@GetMapping("/board/content")
	public String content(Model model,
			@RequestParam String pageNum,
			@RequestParam int num,
			@RequestParam(defaultValue = "no")String key)
	{
		//목록에서 올 경우에만 조회수 증가
		if(key.equals("list"))
			dao.updateReadCount(num);
		//dto 가져오기
		BoardDto dto=dao.getData(num);
		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);
		
		return "/board/content";
	}
}
