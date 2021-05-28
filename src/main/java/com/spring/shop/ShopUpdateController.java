package com.spring.shop;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import shop.data.ShopDao;
import shop.data.ShopDto;
import upload.util.SpringFileWriter;

@Controller
public class ShopUpdateController {
	@Autowired
	ShopDao dao;
	
	@GetMapping("/updateform")
	public ModelAndView updateForm(@RequestParam String num)
	{
		ModelAndView mview=new ModelAndView();
		ShopDto dto=dao.getData(num);
		mview.addObject("dto", dto);
		
		mview.setViewName("shop/updateform");
		return mview;
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute ShopDto dto, HttpServletRequest request)
	{
		//이미지가 업로드될 경로 구하기
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/photo");
		
		//이미지를 업로드 하지 않았을 경우 : photo에 null 저장
		//여러 개인 경우 : 컴마로 연결해서 저장
		String photo="";
		//이미지를 넣지 않았을 경우 확인 : 첫 이미지명이 빈문자열
		String s= dto.getUpload().get(0).getOriginalFilename();
		if(s.equals(""))
		photo=null;
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
		//System.out.println("photo="+photo);
		dao.updateShop(dto);
		
		return "redirect:content?num="+dto.getNum();
	}
	

	@GetMapping("/delete")
	public String detail(@RequestParam String num)
	{
		dao.deleteShop(num);
		
		return "redirect:list";
	}
}
