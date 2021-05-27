package shop.data;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class ShopDao extends SqlSessionDaoSupport{
	public int getTotalCount()
	{
		return getSqlSession().selectOne("shop.totalCountOfShop");
	}

}
