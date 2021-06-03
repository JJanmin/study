package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.dao.BoardDao;
import spring.dto.BoardDto;
import spring.dto.MemberDto;
import upload.util.SpringFileWriter;

@Controller
public class BoardUpdateController {
	@Autowired
	BoardDao dao;
	@GetMapping("/board/updateform")
	public ModelAndView updateform(
			@RequestParam(defaultValue = "1") String pageNum,
			@RequestParam(defaultValue = "0") int reg,
			@RequestParam(defaultValue = "0") int restep,
			@RequestParam(defaultValue = "0") int relevel,
			@RequestParam(defaultValue = "0") int num,
			HttpSession session)
	{
		ModelAndView mview =new ModelAndView();
		BoardDto dto=dao.getData(num);

		mview.addObject("pageNum", pageNum);
		mview.addObject("dto",dto);
		mview.setViewName("/board/updateform");
		return mview;
	}

	@PostMapping("/board/update")
	public String update(@ModelAttribute BoardDto dto,
			@RequestParam String pageNum,
			HttpServletRequest request)
	{
		//이미지가 업로드 될 폴더 구하기
		String path=request.getSession().getServletContext().getRealPath("/WEB-INF/image");
		System.out.println(path);

		//이미지 업로드 하지 않았을 경우 "no"라고 저장
		String upload="";
		String f=dto.getPhoto().get(0).getOriginalFilename();
		if(f.equals(""))
			upload="no";
		else {
			SpringFileWriter sfw=new SpringFileWriter();
			for(MultipartFile file:dto.getPhoto())
			{
				//폴더에 이미지 저장(저장된 이미지명 반환)
				String fileName=sfw.writeFile(file,path);
				upload+=fileName+",";
			}
			//마지막 컴마 제거
			upload=upload.substring(0,upload.length()-1);
		}
		dto.setUploadname(upload);
		dao.updateBoard(dto);

		return "redirect:content?num="+dto.getNum()+"&pageNum="+pageNum;
	}
	
	@GetMapping("/board/delete")
	public String delete(@RequestParam String pageNum,
						@RequestParam int num)
	{
			dao.deleteBoard(num);
			return "redirect:list?pageNum="+pageNum;
		}
	
}

