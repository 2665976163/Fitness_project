package com.znsd.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 无参构造
@NoArgsConstructor
// 全参构造
@AllArgsConstructor
// get、set、toString ...
@Data
/**
 * 商品参数bean
 */
public class GoodsParam {
    // 商品参数Id
    private Integer p_Id;
    // 商家id
    private Integer u_Id;
    // 商品类型名称：哑铃
    private String p_TypeName;
    // 参数内容：30Kg
    private String p_Content;
    // 价格（不同参数可能价格不同）
    private String p_Price;
    // 参考图片
    private String p_ImgPath;
}
