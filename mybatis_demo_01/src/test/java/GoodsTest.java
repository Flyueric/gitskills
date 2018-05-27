import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.bovane.entity.GoodsInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
public class GoodsTest {
    public void selectAll() {
        String resource = "config/Configuration.xml"; // 配置文件
        Reader reader; // 字符流对象
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlsession = null;
        try {
            reader = Resources.getResourceAsReader(resource); // 加载全局配置文件
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlsession = sqlSessionFactory.openSession();
            List<GoodsInfo> goods = sqlsession.selectList("GoodsInfoMapper.selectAll"); // 加载映射文件
            for (GoodsInfo goodsInfo : goods) {
                System.out.println(goodsInfo);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (sqlsession != null) {
                sqlsession.close();
            }
        }

    }

    @Test
    public void selectByGoodsName() {
        String resource = "config/Configuration.xml";
        Reader reader;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlsession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlsession = sqlSessionFactory.openSession();
            GoodsInfo goods = sqlsession.selectOne("GoodsInfoMapper.selectByGoodsName", "ball");
            System.out.println(goods);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (sqlsession != null) {
                sqlsession.close();
            }
        }

    }
    @Test
    public void insertGoods() {
        String resource = "config/Configuration.xml";
        Reader reader;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlsession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlsession = sqlSessionFactory.openSession();
            GoodsInfo goodsInfo=new GoodsInfo();
            goodsInfo.setGoodsName("ball");
            goodsInfo.setGoodsPrice("100");
            goodsInfo.setGoodsDesc("Vane");
            goodsInfo.setTypeID(1);
            int result = sqlsession.insert("GoodsInfoMapper.insertGoods",goodsInfo);
            sqlsession.commit();
            System.out.println(result);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            sqlsession.rollback();
        } finally {
            if (sqlsession != null) {
                sqlsession.close();
            }
        }

    }
    @Test
    public void updateGoods() {
        String resource = "config/Configuration.xml";
        Reader reader;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlsession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlsession = sqlSessionFactory.openSession();
            GoodsInfo goodsInfo=new GoodsInfo();
            goodsInfo.setId(2);
            goodsInfo.setGoodsName("ball");
            goodsInfo.setGoodsPrice("100");
            goodsInfo.setGoodsDesc("BoVane");
            goodsInfo.setTypeID(1);
            int result = sqlsession.update("GoodsInfoMapper.updateGoods",goodsInfo);
            sqlsession.commit();
            System.out.println(result);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            sqlsession.rollback();
        } finally {
            if (sqlsession != null) {
                sqlsession.close();
            }
        }

    }
    @Test
    public void deleteGoods() {
        String resource = "config/Configuration.xml";
        Reader reader;
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession sqlsession = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlsession = sqlSessionFactory.openSession();

            int result = sqlsession.delete("GoosInfoMapper.deleteGoods",6);
            sqlsession.commit();
            System.out.println(result);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            sqlsession.rollback();
        } finally {
            if (sqlsession != null) {
                sqlsession.close();
            }
        }

    }
}
