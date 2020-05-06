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
 * 商品||课程类型关联bean
 */
public class CommonTypeMiddleBean {
    // Id 类型：商品 || 课程
    private String common_Type;
    // 商品Id || 课程Id
    private Integer common_Id;
    // 类型Id（商品 || 课程）
    private Integer ct_Id;
}
