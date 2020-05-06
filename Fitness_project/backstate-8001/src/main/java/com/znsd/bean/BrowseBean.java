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
 * 浏览记录bean
 */
public class BrowseBean {
    // 浏览Id
    private Integer b_Id;
    // 浏览类型（商品 || 课程）
    private String b_Type;
    // 浏览日期
    private String b_CreateDate;
    // 浏览者Id
    private Integer u_Id;
    // 浏览目标Id（课程Id || 商品Id）
    private Integer common_Id;
}
