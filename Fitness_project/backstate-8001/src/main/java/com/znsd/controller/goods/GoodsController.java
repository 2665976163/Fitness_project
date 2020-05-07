package com.znsd.controller.goods;


import com.znsd.bean.GoodsBean;
import com.znsd.bean.UserBean;
import com.znsd.service.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.RequestWrapper;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/good")
public class GoodsController {
    @Autowired
    private GoodsService good;

    @RequestMapping("/findAll")
    public String findAll(Map<String,Object> map){
        System.out.println("成功进入查询全部商品");
        List<GoodsBean> list = good.findAll();
        map.put("goodsAll",list);
         return "goods/goods-list";
    }

    @RequestMapping("/findByGId")
    public GoodsBean findByGId(Integer g_Id){
        System.out.println("根据商品id查询商品信息");
        return good.findByGId(g_Id);
    }

    @RequestMapping("/save")
    public void save(){
        //虚拟数据
        GoodsBean goodsBean = new GoodsBean();
        goodsBean.setG_conut("100");
        goodsBean.setG_Detail("描述");
        goodsBean.setG_integral("111");
        goodsBean.setG_Name("哑铃");
        good.save(goodsBean);
    }

    @RequestMapping("/DelByGId/{id}")
    public String DelByGId(@PathVariable("id") Integer g_Id, Map<String,Object> map){
        System.out.println("根据商品id下架改商品"+g_Id);
        good.DelByGId(g_Id);
        //重新查询 并且把结果传回前台
        List<GoodsBean> list = good.findAll();
        map.put("goodsAll",list);
       return "goods/goods-list";
    }

    @RequestMapping("/UpdateByGId")
    public void UpdateByGId(){
        //虚拟数据
        GoodsBean goodsBean = new GoodsBean();
        goodsBean.setG_conut("100");
        goodsBean.setG_Detail("描述");
        goodsBean.setG_integral("111");
        goodsBean.setG_Name("哑铃");
        goodsBean.setG_Id(1);
        good.UpdateByGId(goodsBean);
    }

    @RequestMapping("/UpdateByUId")
    public void UpdateByUId(){
        //虚拟数据
        GoodsBean goodsBean = new GoodsBean();
        goodsBean.setG_conut("100");
        goodsBean.setG_Detail("描述");
        goodsBean.setG_integral("111");
        goodsBean.setG_Name("哑铃");
        UserBean user = new UserBean();
        user.setU_Id(1);
        goodsBean.setUserBean(user);
        good.UpdateByUId(goodsBean);
    }

}
