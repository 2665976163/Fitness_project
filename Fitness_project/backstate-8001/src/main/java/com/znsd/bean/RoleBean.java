package com.znsd.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 无参构造
@NoArgsConstructor
// 全参构造
@AllArgsConstructor
// get、set、toString  ...
@Data
/**
 * 角色Bean
 */
public class RoleBean {
    // 角色Id
    private Integer r_Id;
    // 角色名称
    private String r_Name;
    // 角色创建日期
    private String r_CreateDate;
    // 角色最后一次修改日期
    private String r_lastUpDate;
}
