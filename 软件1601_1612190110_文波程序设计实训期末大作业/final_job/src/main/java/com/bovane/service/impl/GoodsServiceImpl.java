package com.bovane.service.impl;

/*商品服务接口实现，实现增删改查等基本方法并做服务测试*/
import com.bovane.dao.GoodsDao;
import com.bovane.dao.impl.GoodsDaoImpl;
import com.bovane.dao.impl.MyBatisUtis;
import com.bovane.entity.Goods;
import com.bovane.service.GoodsService;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao dao;
    // private GoodsDao dao = new GoodsDaoImpl();

    public GoodsDao getDao() {
        return this.dao;
    }

    public void setDao(GoodsDao dao) {
        this.dao = dao;
    }

    @Override
    public int addGoods(Goods goods) { // 增加商品类别
        int result = 0;
        SqlSession session = MyBatisUtis.createSqlSession();
        try {
            result = dao.insertGoods(session, goods);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public List<Goods> getAll() { // 获得所有商品
        List<Goods> result = new ArrayList<Goods>();
        SqlSession session = MyBatisUtis.createSqlSession();
        try {
            result = dao.selectAll(session);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public int deleteGoods(int id) { // 删除商品
        int result = 0;
        SqlSession session = MyBatisUtis.createSqlSession();
        try {
            result = dao.deleteGoods(session, id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public int updateGoods(Goods goods) { // 修改商品
        int result = 0;
        SqlSession session = MyBatisUtis.createSqlSession();
        try {
            result = dao.updateGoods(session, goods);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    public Goods selectByGoodsID(int id) { // 以ID查询商品
        Goods result = null;
        SqlSession session = MyBatisUtis.createSqlSession();
        try {
            result = dao.selectByGoodsID(session, id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }
}
