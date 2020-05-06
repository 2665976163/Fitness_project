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
 *  评分bean
 */
public class CommonScoreBean {
    // 评分Id
    private Integer cs_Id;
    // 评分类型：课程、商品
    private String cs_Type;
    // 分数
    private Integer cs_Score;
    // 评分日期
    private String cs_CreateDate;
    // Id：课程Id || 商品Id
    private Integer common_Id;
    // 评分用户Id
    private Integer u_Id;
}
