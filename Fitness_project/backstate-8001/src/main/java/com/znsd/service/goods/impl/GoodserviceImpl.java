package com.znsd.service.goods.impl;

import com.znsd.bean.GoodsBean;
import com.znsd.dao.goods.GoodsMapper;
import com.znsd.service.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodserviceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goods;

    @Override
    public List<GoodsBean> findAll() {
        return goods.findAll();
    }

    @Override
    public GoodsBean findByGId(Integer g_Id) {
        return goods.findByGId(g_Id);
    }

    @Override
    public void save(GoodsBean goodsBean) {
        goods.save(goodsBean);
    }

    @Override
    public void DelByGId(Integer g_Id) {
        goods.DelByGId(g_Id);
    }

    @Override
    public void UpdateByGId(GoodsBean goodBean) {
        goods.UpdateByGId(goodBean);
    }

    @Override
    public void UpdateByUId(GoodsBean goodBean) {
        goods.UpdateByUId(goodBean);
    }


}
