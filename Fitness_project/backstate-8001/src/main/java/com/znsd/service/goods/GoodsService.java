package com.znsd.service.goods;

import com.znsd.bean.GoodsBean;

import java.util.List;

public interface GoodsService {
    //全部查询商品
    public List<GoodsBean> findAll();

    //根据商品id 来查询 商品信息
    public GoodsBean findByGId(Integer g_Id);

    //上架商品
    public void save(GoodsBean goodsBean);

    //下架商品 商品id
    public void DelByGId(Integer g_Id);

    //根据商品id来修改
    public void UpdateByGId(GoodsBean goodsBean);

    //根据用户id来修改
    public void UpdateByUId(GoodsBean goodsBean);

}
