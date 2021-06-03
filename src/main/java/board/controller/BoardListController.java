package board.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.dao.BoardDao;
import spring.dto.BoardDto;

@Controller
public class BoardListController {
	@Autowired
	BoardDao dao;

	@GetMapping("/board/list")
	public ModelAndView list(
			//pageNum==null일때 디폴트값: 1
			@RequestParam(value="pageNum",defaultValue = "1") int currentPage)
	{
		ModelAndView mview=new ModelAndView();
		//총갯수 구하기
		int totalCount=dao.getTotalCount();
		//request 에 저장
		mview.addObject("totalCount", totalCount);

		//페이징에 필요한 코드
		int totalPage;//총 페이지수
		int startPage;//각 블럭의 시작페이지
		int endPage;//각 블럭의 끝페이지
		int start;//각 페이지의 시작번호
		int no;//각 페이지에서 출력을 시작할 번호
		int perPage=5;//한페이지에 보여질 글의 갯수
		int perBlock=5;//한블럭에 보여질 페이지의 갯수
		//총 페이지수 구하기
		//예:perPage가 5인경우 총 글갯수가13개라면 총 몇페이지라야할까?
		totalPage = totalCount / perPage + (totalCount % perPage > 0 ? 1 : 0);

		//예)현재페이지가 3인경우 startPage는 1, endPage=5
		//   현재페이지가 6인경우 startPage는 6, endPage=10
		startPage=(currentPage-1)/perBlock*perBlock+1;
		endPage=startPage+perBlock-1;

		//만약 총 페이지수가 8일경우
		//2번째 블럭은 startPage가 6 endPage 가 10 이 되는데 
		//이때 endPage 는 8로 수정해주어야 한다
		if(endPage > totalPage)
			endPage = totalPage;

		//각 페이지의 시작번호,끝번호 구하기
		//오라클은 첫글이 1번,mysql 은 첫글이 0번
		//현재페이지가 1일경우 start 는 0,2일경우 3...
		start=(currentPage-1)*perPage;

		//각 글앞에 붙일 시작번호구하기
		//예: 총글이 20개일경우 1페이지는 20부터,2페이지는 15부터
		// 출력해서 1씩 감소해가며 출력할것
		no=totalCount-(currentPage-1)*perPage;
		//목록 가져오기
		List<BoardDto> list=dao.getList(start, perPage);

		//출력시 필요한 변수들은 모두 request 에 저장해둔다
		mview.addObject("list",list );
		mview.addObject("no",no);
		mview.addObject("startPage",startPage );
		mview.addObject("endPage",endPage );
		mview.addObject("currentPage",currentPage );
		mview.addObject("totalPage",totalPage );
		
		mview.setViewName("/board/boardlist");
		return mview;
	}
	
	@GetMapping("/board/list2")
	public String list2()
	{
		return "/board/ajaxlist";
	}
}
