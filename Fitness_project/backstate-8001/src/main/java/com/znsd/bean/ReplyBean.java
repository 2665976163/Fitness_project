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
 * 回复bean
 */
public class ReplyBean {
    // 主键 回复Id
    private Integer ry_Id;
    // 回复内容
    private String ry_Content;
    // 是否已读
    private String ry_IsRead;
    // 评论Id
    private Integer d_Id;
    // 当前用户Id
    private Integer this_u_Id;
    // 目标用户Id
    private Integer target_u_Id;

}
