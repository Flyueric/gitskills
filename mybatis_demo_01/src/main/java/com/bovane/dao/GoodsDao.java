package com.bovane.dao;

import com.bovane.entity.GoodsInfo;

import java.util.List;

public interface GoodsDao {
    public List<GoodsInfo> selectAll();
    public int insertGoods(GoodsInfo goodsInfo);
}
