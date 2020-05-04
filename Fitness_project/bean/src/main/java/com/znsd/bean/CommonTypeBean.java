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
 * 商品||课程类型bean
 */
public class CommonTypeBean {
    // common类型Id
    private Integer ct_Id;
    // common类型：商品 || 课程
    private String ct_Type;
    // 类型名称：日常用品、锻炼器材、技术协会
    private String ct_Name;
    // 创建日期
    private String ct_CreateDate;
    // 最后修改日期
    private String ct_LastUpDate;
}
