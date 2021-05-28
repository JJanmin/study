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
		//�̹����� ���ε�� ��� ���ϱ�
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/photo");
		
		//�̹����� ���ε� ���� �ʾ��� ��� : photo�� null ����
		//���� ���� ��� : �ĸ��� �����ؼ� ����
		String photo="";
		//�̹����� ���� �ʾ��� ��� Ȯ�� : ù �̹������� ���ڿ�
		String s= dto.getUpload().get(0).getOriginalFilename();
		if(s.equals(""))
		photo=null;
		else {
			SpringFileWriter sfw=new SpringFileWriter();
			for(MultipartFile file:dto.getUpload()) {
				//������ �̹����� �����ϰ� ����� ���ϸ� ����
				String fname=sfw.writeFile(file, path);
				photo+=fname+",";
			}
			//������ �ĸ� ����
			photo=photo.substring(0,photo.length()-1);
		}
		//dto�� photo ����
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
