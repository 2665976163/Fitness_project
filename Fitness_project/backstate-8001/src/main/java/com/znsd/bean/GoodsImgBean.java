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
 * 商品图片bean
 */
public class GoodsImgBean {
    // 图片自增Id
    private Integer gi_Id;
    // 商品Id
    private Integer g_Id;
    // 商品图片类型：封面：套图
    private String g_Type;
    // 图片地址
    private String g_ImgPath;
}
