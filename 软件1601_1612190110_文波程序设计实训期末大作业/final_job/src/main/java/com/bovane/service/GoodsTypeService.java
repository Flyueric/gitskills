package com.bovane.service;
/*商品类型服务接口，有增删改查等基本方法*/
import com.bovane.entity.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    public List<GoodsType> getAll();
    public int addGoodsType(GoodsType goodsType);
    public int deleteGoodsType(int id);
    public int updateGoodsType(GoodsType goodsType);
    public GoodsType selectByGoodsTypeID(int id);
}
