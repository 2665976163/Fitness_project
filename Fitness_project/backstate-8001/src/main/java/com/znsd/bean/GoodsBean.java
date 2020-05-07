package com.znsd.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// 无参构造
@NoArgsConstructor
// 全参构造
@AllArgsConstructor
// get、set、toString ...
@Data
/**
 * 商品bean
 */
public class GoodsBean {
    // 商品Id
    private Integer g_Id;
    // 商品名称
    private String g_Name;
    // 商品描述
    private String g_Detail;
    // 商品价格
    private String g_price;
    // 商品积分价格
    private String g_integral;
    // 库存
    private String g_conut;
    // 商家Id  userBean.u_Id
    private UserBean userBean;
   //商品参数id  GoodsParam..pId
    private GoodsParam goodsParam;
}
