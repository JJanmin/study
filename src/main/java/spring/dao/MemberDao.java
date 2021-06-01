package spring.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import spring.dto.MemberDto;

@Repository //xml �ڵ���� dao=repository controller�� controller
public class MemberDao extends SqlSessionDaoSupport{
	//id�� �����ϸ� 1, �������� ������ 0
	public int getIdCount(String id)
	{
		return getSqlSession().selectOne("idCheckOfMember",id);
	}
	
	public void insertMember(MemberDto dto)
	{
		getSqlSession().insert("insertOfMember",dto);
		
	}
	
	public List<MemberDto> getAllMembers()
	{
		return getSqlSession().selectList("listAllOfMember");
	}
	//���̵�� ����� ��� ������ 1 ��ȯ, Ʋ���� 0 ��ȯ 
	public int loginCheck(String id, String pass)
	{
		HashMap<String,String> map=new HashMap<String, String>();
		map.put("id", id);
		map.put("pass",pass);
		return getSqlSession().selectOne("loginCheckOfMember",map);
	}
	public MemberDto getMember(String num)
	{
		return getSqlSession().selectOne("selectOneOfMember",num);
	}
	
	public int getpassCheck(String pass,String num)
	{
		HashMap<String,String> map=new HashMap<String, String>();
		map.put("num", num);
		map.put("pass",pass);
		return getSqlSession().selectOne("passCheckOfMember",map);
	}
	
	public void updateOfMember(MemberDto dto)
	{
		getSqlSession().update("updateOfMember",dto);
	}
	public void deleteOfMember(String num)
	{
		getSqlSession().delete("deleteOfMember",num);
	}
}
