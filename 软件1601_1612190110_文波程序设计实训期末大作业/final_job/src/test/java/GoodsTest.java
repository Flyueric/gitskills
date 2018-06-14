import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.bovane.dao.impl.GoodsDaoImpl;
import com.bovane.dao.impl.MyBatisUtis;
import com.bovane.entity.Goods;
import com.bovane.entity.GoodsType;
import com.bovane.service.GoodsService;
import com.bovane.service.impl.GoodsServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
/*我可能知道是哪里错了，由于商品列表的时候，没有goodstype这个对象，也就是goods.goodsType是空的，而jsp页面又用到*/
public class GoodsTest {
    private GoodsDaoImpl dao = new GoodsDaoImpl();
    //@Test
    /*public void selectAll() {
        SqlSession session=MyBatisUtis.createSqlSession();
        List<GoodsInfo> goods = dao.selectAll(session);
        session.commit();
        for (GoodsInfo goodsInfo : goods) {
            System.out.println(goodsInfo);
        }*/


}