package com.bovane.dao;

import com.bovane.entity.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
/*商品接口，有增删改查等基本方法*/
public interface GoodsDao {
    public List<Goods> selectAll(SqlSession session);
    public int insertGoods(SqlSession session, Goods goods);
    public Goods selectByGoodsID(SqlSession session, int id); // 以ID查询
    public int deleteGoods(SqlSession session,int id);
    public int updateGoods(SqlSession session,Goods goods);

}
