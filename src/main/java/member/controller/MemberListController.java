package member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import spring.dao.MemberDao;
import spring.dto.MemberDto;

@Controller
public class MemberListController {
	@Autowired
	MemberDao dao;
	
	@GetMapping("/member/list")
	public String memberlist(Model model)
	{	
		List<MemberDto> list=dao.getAllMembers();
		model.addAttribute("list", list);
		return "/member/memberlist";//  폴더명/파일명
	}
	


}
