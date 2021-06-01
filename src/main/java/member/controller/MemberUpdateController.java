package member.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.dao.MemberDao;
import spring.dto.MemberDto;

@Controller
public class MemberUpdateController {
	@Autowired
	MemberDao dao;

	@GetMapping("/member/updateform")
	 public ModelAndView updateform(@RequestParam String num) 
	{
	 ModelAndView mview=new ModelAndView(); 
	 MemberDto dto=dao.getMember(num);
	 mview.addObject("dto",dto);
	 mview.setViewName("/member/updateform"); 
	 return mview;
	 }
	 
	
	@PostMapping("/member/update")
	public String update(@ModelAttribute MemberDto dto)
	{
		int n=dao.getpassCheck(dto.getPass(), dto.getNum());
		if(n==1)
		{
			dao.updateOfMember(dto);
			return "redirect:list";
			
		}else {
			
			return "/member/passfail";
		}
	}
	
	@GetMapping("/member/delete")
	public String delete(HttpSession session,@RequestParam String num)
	{
		String loginId=(String)session.getAttribute("myid");
		if(loginId==null||!loginId.equals("admin"))
		{
			return "/member/deletefail";
		}else{
			dao.deleteOfMember(num);
			return "redirect:list";
		}
		
	}
}
