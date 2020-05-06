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
 * 评论bean
 */
public class DiscussBean {
    // 评论Id
    private Integer d_Id;
    // 评论类型：课程评论、商品评论
    private String d_Type;
    // 评论内容
    private String d_Content;
    // 是否已读
    private String d_IsRead;
    // 创建日期
    private String d_CreateDate;
    // 课程Id、商品Id 根据d_Type定义
    private String common_Id;
    // 评论用户Id
    private String u_Id;
}
