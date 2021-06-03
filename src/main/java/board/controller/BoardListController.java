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
			//pageNum==null�϶� ����Ʈ��: 1
			@RequestParam(value="pageNum",defaultValue = "1") int currentPage)
	{
		ModelAndView mview=new ModelAndView();
		//�Ѱ��� ���ϱ�
		int totalCount=dao.getTotalCount();
		//request �� ����
		mview.addObject("totalCount", totalCount);

		//����¡�� �ʿ��� �ڵ�
		int totalPage;//�� ��������
		int startPage;//�� ���� ����������
		int endPage;//�� ���� ��������
		int start;//�� �������� ���۹�ȣ
		int no;//�� ���������� ����� ������ ��ȣ
		int perPage=5;//���������� ������ ���� ����
		int perBlock=5;//�Ѻ��� ������ �������� ����
		//�� �������� ���ϱ�
		//��:perPage�� 5�ΰ�� �� �۰�����13����� �� ������������ұ�?
		totalPage = totalCount / perPage + (totalCount % perPage > 0 ? 1 : 0);

		//��)������������ 3�ΰ�� startPage�� 1, endPage=5
		//   ������������ 6�ΰ�� startPage�� 6, endPage=10
		startPage=(currentPage-1)/perBlock*perBlock+1;
		endPage=startPage+perBlock-1;

		//���� �� ���������� 8�ϰ��
		//2��° ���� startPage�� 6 endPage �� 10 �� �Ǵµ� 
		//�̶� endPage �� 8�� �������־�� �Ѵ�
		if(endPage > totalPage)
			endPage = totalPage;

		//�� �������� ���۹�ȣ,����ȣ ���ϱ�
		//����Ŭ�� ù���� 1��,mysql �� ù���� 0��
		//������������ 1�ϰ�� start �� 0,2�ϰ�� 3...
		start=(currentPage-1)*perPage;

		//�� �۾տ� ���� ���۹�ȣ���ϱ�
		//��: �ѱ��� 20���ϰ�� 1�������� 20����,2�������� 15����
		// ����ؼ� 1�� �����ذ��� ����Ұ�
		no=totalCount-(currentPage-1)*perPage;
		//��� ��������
		List<BoardDto> list=dao.getList(start, perPage);

		//��½� �ʿ��� �������� ��� request �� �����صд�
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
