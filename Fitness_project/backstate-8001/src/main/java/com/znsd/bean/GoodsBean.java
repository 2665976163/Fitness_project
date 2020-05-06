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
    // 商家Id
    private UserBean userBean;
    // 商品类型 CommonTypeMiddleBean -> CommonTypeBean sql级联
    private List<CommonTypeMiddleBean> commonTypeMiddleBeanList;
    // 商品封面 sql级联
    private GoodsImgBean goodsImgBean;
    // 商品内图 sql级联
    private List<GoodsImgBean> goodsImgBeanList;
    // 商品参数 sql级联
    private List<GoodsParam> goodsParamList;
    // 购买数量 sql求出
    private String g_PayCount;
    // 商品评分 sql求出
    private String g_Score;
    // 浏览记录(x个用户看过) sql 级联 BrowseBean -> UserBean
    private List<UserBean> userBeanList;
}
