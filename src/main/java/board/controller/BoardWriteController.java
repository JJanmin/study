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
import upload.util.SpringFileWriter;

@Controller
public class BoardWriteController {
	@Autowired
	BoardDao dao;
	
	@GetMapping("/board/form")
	public ModelAndView form(
			@RequestParam(defaultValue = "1") String pageNum,
			@RequestParam(defaultValue = "0") int reg,
			@RequestParam(defaultValue = "0") int restep,
			@RequestParam(defaultValue = "0") int relevel,
			@RequestParam(defaultValue = "0") int num,
			HttpSession session)

	{
		ModelAndView mview =new ModelAndView();
		//세션에 저장된 아이디
		String id=(String)session.getAttribute("myid");
		//아이디에 해당하는 이름
		String name=dao.searchName(id);
		//답글일 경우 제목에 [답글] 이전제목으로 저장
		String subject="";
		if(num!=0) {
			subject="[답글]"+dao.getData(num).getSubject();
		}
		mview.addObject("name", name);
		mview.addObject("subject", subject);
		mview.addObject("pageNum", pageNum);
		mview.addObject("reg", reg);
		mview.addObject("restep", restep);
		mview.addObject("relevel", relevel);
		mview.addObject("num", num);
		
		mview.setViewName("/board/writeform");
		return mview;
	}
	
	@PostMapping("/board/insert")
	public String insert(@ModelAttribute BoardDto dto,
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
		//dto에 업로드 파일명 저장
		dto.setUploadname(upload);
		//db에 insert
		dao.insertBoard(dto);
		
		return "redirect:list?pageNum="+pageNum;//답글일경우 보던 페이지로
	}
}
