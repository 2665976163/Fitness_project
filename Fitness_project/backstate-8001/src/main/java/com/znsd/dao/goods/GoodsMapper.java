package com.znsd.dao.goods;


import com.znsd.bean.GoodsBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {
    //全部查询商品
    public List<GoodsBean> findAll();

    //根据商品id 来查询 商品信息
    public GoodsBean findByGId(Integer g_Id);

    //上架商品
    public void save(GoodsBean goodsBean);

    //下架商品 商品id
    public void DelByGId(Integer g_Id);

    //根据商品id来修改
    public void UpdateByGId(GoodsBean goods);

    //根据用户id来修改
    public void UpdateByUId(GoodsBean goods);
}
