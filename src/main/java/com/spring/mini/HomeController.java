package com.spring.mini;



import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.dao.MemberDao;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	MemberDao dao;
	@GetMapping({"/","/home"})
	public String main()
	{
		//tiles layout 설정한곳으로 포워드
		return "/layout/main";
	}
	
	
	@GetMapping("/login")
	public String login()
	{	
		return "/login/loginmain";
	}
	
	@PostMapping("/loginprocess")
	public String loginCheck(@RequestParam String id, @RequestParam String pass, HttpSession session)
	{
		int n=dao.loginCheck(id, pass);
		if(n==1)
		{
			//세션 저장
			session.setAttribute("loginok", "yes");
			session.setAttribute("myid", id);
			return "redirect:home";
		}else {
			return "/login/loginfail";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.removeAttribute("loginok");
		session.removeAttribute("myid");

		return "redirect:home";
	}
	
	
}

