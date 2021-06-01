package member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.dao.MemberDao;
import spring.dto.MemberDto;

@Controller
public class MemberWriteController {
	@Autowired
	MemberDao dao;
	@GetMapping("/member/form")
	public String writeform()
	{	
		return "/member/memberform";//  폴더명/파일명
	}
	
	//@ResponseBody : 브라우저에서 매핑주소를 넣으면 json형식으로 결과 나옴
	
	@GetMapping("/member/idcheck")
	public @ResponseBody Map<String, Integer> idcheck(@RequestParam String id)
	{
		Map<String, Integer> map=new HashMap<String, Integer>();
		int count=dao.getIdCount(id);
		map.put("count", count);
		return map; 
	}
	
	@PostMapping("/member/insert")
	public String insert(@ModelAttribute MemberDto dto)
	{
		dao.insertMember(dto);
		
		return "redirect:list";
	}
	
}
