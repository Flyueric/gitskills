package com.bovane.dao.impl;

import com.bovane.dao.GoodsDao;
/*商品接口实现类，具体实现增删改查等基本方法*/
import com.bovane.entity.Goods;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class GoodsDaoImpl extends MybatisBaseDao implements GoodsDao {
    @Override
    public List<Goods> selectAll(SqlSession session) { // 查询所有商品
        List<Goods> goodses = super.selectList(session, "GoodsMapper.selectAll");
        return goodses;
    }
    @Override
    public int insertGoods(SqlSession session,Goods goods) { // 插入商品
        int result = super.insert(session, "GoodsMapper.insertGoods", goods);
        return result;
    }
    @Override
    public int deleteGoods(SqlSession session,int id) { // 删除商品
        int result = super.insert(session, "GoodsMapper.deleteGoods",id);
        return result;
    }
    @Override
    public Goods selectByGoodsID(SqlSession session,int id) { // 根据ID选择商品
        Goods goods = (Goods) super.selectOne(session,"GoodsMapper.selectByGoodsID",id);
        return goods;
    }
    @Override
    public int updateGoods(SqlSession session,Goods goods) { // 修改商品
        int result = 0;
        result = super.update(session,"GoodsMapper.updateGoods",goods);
        return result;
    }
}
