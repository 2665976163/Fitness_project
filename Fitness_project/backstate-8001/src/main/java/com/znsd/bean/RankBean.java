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
 * 等级bean
 */
public class RankBean {
    // 等级Id
    private Integer rk_Id;
    // 等级名称
    private String rk_Name;
    // 等级颜色
    private String rk_Color;
    // 等级大小 medium / small / mini
    private String rk_Size;
    // 等级类型：学生等级、课程等级
    private String rk_Type;
    // 创建日期
    private String rk_CreateDate;
    // 最后一次修改日期
    private String rk_lastUpDate;
}
