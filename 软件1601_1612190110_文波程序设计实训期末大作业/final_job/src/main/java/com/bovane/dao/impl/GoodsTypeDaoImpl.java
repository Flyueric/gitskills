package com.bovane.dao.impl;

import java.util.List;
import com.bovane.dao.GoodsTypeDao;
import com.bovane.entity.GoodsType;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
/*商品类型接口实现，具体实现增删改查等基本方法*/
 @Repository
public class GoodsTypeDaoImpl extends MybatisBaseDao implements GoodsTypeDao {

    @Override
    public List<GoodsType> selectAll(SqlSession session) { // 查询所有类别
        return super.selectList(session, "GoodsTypeMapper.selectAll");
    }
    @Override
    public int insertGoodsType(SqlSession session,GoodsType goodsType) { // 增加类别
        int result = 0;
        result = super.insert(session,"GoodsTypeMapper.insertGoodsType",goodsType);
        return result;
    }

    @Override
    public int deleteGoodsType(SqlSession session,int id) { // 删除类别
        int result = 0;
        result = super.insert(session,"GoodsTypeMapper.deleteGoodsType",id);
        return result;
    }
    @Override
    public int updateGoods(SqlSession session,GoodsType goodsType) { // 编辑类别
        int result = 0;
        result = super.insert(session,"GoodsTypeMapper.updateGoodsType",goodsType);
        return result;
    }
    public GoodsType selectByGoodsTypeID(SqlSession session,int id) {
        GoodsType result = null;
        result = (GoodsType) super.selectOne(session,"GoodsTypeMapper.selectByGoodsTypeID",id);
        return result;
    }

}
