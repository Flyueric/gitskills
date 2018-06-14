package com.bovane.service.impl;

/*商品类型服务接口实现，实现增删改查等基本方法*/
import com.bovane.dao.GoodsTypeDao;
import com.bovane.dao.impl.GoodsTypeDaoImpl;
import com.bovane.dao.impl.MyBatisUtis;
import com.bovane.entity.GoodsType;
import com.bovane.service.GoodsTypeService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {
    @Autowired
    private GoodsTypeDao dao ;
    @Override
    public List<GoodsType> getAll() { // 查询所有类别
        List<GoodsType> types = new ArrayList<GoodsType>();
        SqlSession session = MyBatisUtis.createSqlSession();
        try {
            types = dao.selectAll(session);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(session!=null){
                session.close();}
        }
        return types;
    }

    @Override
    public int addGoodsType(GoodsType goodsType) { // 添加商品类别
        int result = 0;
        SqlSession session = MyBatisUtis.createSqlSession();
        try {
            result = dao.insertGoodsType(session,goodsType);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(session!=null){
                session.close();}
        }
        return result;
    }

    @Override
    public int deleteGoodsType(int id) { // 删除商品类别
        int result = 0;
        SqlSession session = MyBatisUtis.createSqlSession();
        try {
            result = dao.deleteGoodsType(session,id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(session!=null){
                session.close();}
        }
        return result;
    }

    @Override
    public int updateGoodsType(GoodsType goodsType) { // 更新商品类别
        int result = 0;
        SqlSession session = MyBatisUtis.createSqlSession();
        try {
            result = dao.updateGoods(session,goodsType);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(session!=null){
                session.close();}
        }
        return result;
    }
    public GoodsType selectByGoodsTypeID(int id) { // 以id选择单个类型
        GoodsType result = null;
        SqlSession session = MyBatisUtis.createSqlSession();
        try {
            result = dao.selectByGoodsTypeID(session,id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(session!=null){
                session.close();}
        }
        return result;
    }
}
