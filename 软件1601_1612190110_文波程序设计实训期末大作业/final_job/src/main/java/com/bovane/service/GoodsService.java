package com.bovane.service;

/*商品服务接口，有增删改查等基本方法*/
import com.bovane.entity.Goods;
import java.util.List;

public interface GoodsService {
    public int addGoods(Goods goods);
    public List<Goods> getAll();
    public int deleteGoods(int id);
    public int updateGoods(Goods goods);
    public Goods selectByGoodsID(int id);
}
