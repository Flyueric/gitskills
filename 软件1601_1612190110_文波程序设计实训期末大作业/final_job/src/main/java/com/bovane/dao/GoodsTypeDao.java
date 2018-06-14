package com.bovane.dao;

import java.util.List;

import com.bovane.entity.GoodsType;
import org.apache.ibatis.session.SqlSession;
/*商品类型接口，有增删改查等基本方法*/
public interface GoodsTypeDao {
    public List<GoodsType> selectAll(SqlSession session);
    public int insertGoodsType(SqlSession session,GoodsType goodsType);
    public int deleteGoodsType(SqlSession session,int id);
    public int updateGoods(SqlSession session,GoodsType goodsType);
    public GoodsType selectByGoodsTypeID(SqlSession session,int id);
}
