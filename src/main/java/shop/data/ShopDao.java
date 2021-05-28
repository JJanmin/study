package shop.data;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class ShopDao extends SqlSessionDaoSupport{
	public int getTotalCount()
	{
		return getSqlSession().selectOne("shop.totalCountOfShop");
	}
	
	public void insertShop(ShopDto dto)
	{
		getSqlSession().insert("insertOfShop",dto);
	}
	
	public List<ShopDto> getAllDatas()
	{
		return getSqlSession().selectList("listAllOfShop");
	}
	
	public ShopDto getData(String num)
	{
		return getSqlSession().selectOne("selectOneOfShop",num);
	}
	
	public void updateShop(ShopDto dto)
	{
		getSqlSession().update("updateOfShop", dto);
	}
	
	public void deleteShop(String num)
	{
		getSqlSession().delete("deleteOfShop",num);
	}
}
