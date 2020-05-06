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
 * 用户关注bean
 */
public class AttentionBean {
    // 用户Id
    private Integer u_Id;
    // 博主Id
    private Integer u_Target_Id;
    // 关注日期
    private String a_CreateDate;
}
