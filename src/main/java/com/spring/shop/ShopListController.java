package com.spring.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import shop.data.ShopDao;

@Controller
public class ShopListController {
	@Autowired //자동주입(클래스 1개일때만 사용, 인터페이스로 구현한 클래스가 여러개일땐 사용x)
	ShopDao dao;
	@GetMapping("/")
	public ModelAndView list()
	{
		ModelAndView mview=new ModelAndView();
		
		//db에서 전체 갯수 가져오기
		int totalCount=dao.getTotalCount();
		//model에 저장
		mview.addObject("totalCount",totalCount);
		mview.setViewName("shop/list");
		return mview;
	}
}
