package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.dao.BoardDao;
import spring.dto.BoardDto;

@RestController
public class BoardRestController {
	@Autowired
	BoardDao dao;
	
	@GetMapping("/ajax/list1")
	public List<BoardDto> list1()
	{
		return dao.getPhotoDatas();//
	}
	
	@GetMapping("/ajax/list2")
	public List<BoardDto> list2()
	{
		return dao.getAllDatas();//
	}
	
	@GetMapping("/ajax/detail")
	public BoardDto detail(@RequestParam int num)
	{
		return dao.getData(num);//
	}
	@Autowired
	JavaMailSender mailSender;
	
	@PostMapping("/mail/message")
	public Map<String, String> mailsend(
			@RequestParam String addr,@RequestParam String message
			)
	{
		Map<String, String> map=new HashMap<String, String>();
		MimeMessage mes=mailSender.createMimeMessage();
		try {
			mes.setSubject("스프링으로부터 온 메일");//메일 제목
			mes.setText(message);//메일 본문
			//받을 메일 주소
			mes.setRecipients(MimeMessage.RecipientType.TO, 
					InternetAddress.parse(addr));
			//메일 전송
			mailSender.send(mes);
			
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			map.put("mes", addr+" 로 메일 보내기 성공!!!");
		}		
		
		return map;
	}

}

