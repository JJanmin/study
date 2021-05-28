package com.spring.shop;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import shop.data.ShopDao;
import shop.data.ShopDto;
import upload.util.SpringFileWriter;

@Controller
public class ShopWriteController {
	@Autowired //자동주입
	ShopDao dao;
	
	@GetMapping("/addform")
	public String form(Model model)
	{
		Date date =new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		model.addAttribute("day",sdf.format(date));
		return "shop/addform";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute ShopDto dto, HttpServletRequest request)
	{
		//이미지가 업로드될 경로 구하기
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/photo");
		System.out.println(path);
		
		//이미지를 업로드 하지 않았을 경우 : photo에 "no"라고 저장
		//여러 개인 경우 : 컴마로 연결해서 저장
		String photo="";
		System.out.println("11"+dto.getUpload().get(0).getOriginalFilename());
		//이미지를 넣지 않았을 경우 확인 : 첫 이미지명이 빈문자열
		String s= dto.getUpload().get(0).getOriginalFilename();
		if(s.equals(""))
		photo="no";
		else {
			SpringFileWriter sfw=new SpringFileWriter();
			for(MultipartFile file:dto.getUpload()) {
				//폴더에 이미지를 저장하고 저장된 파일명 리턴
				String fname=sfw.writeFile(file, path);
				photo+=fname+",";
			}
			//마지막 컴마 제거
			photo=photo.substring(0,photo.length()-1);
		}
		//dto에 photo 저장
		dto.setPhoto(photo);
		System.out.println("photo="+photo);
		dao.insertShop(dto);
		
		return "redirect:list";
	}
}
