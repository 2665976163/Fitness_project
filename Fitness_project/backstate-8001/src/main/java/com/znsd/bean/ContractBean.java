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
 *  合同bean
 */
public class ContractBean {
    // 合同Id
    private Integer ct_Id;
    // 合同名称
    private String ct_Name;
    // 合同标题
    private String ct_Titile;
    // 合同内容
    private String ct_Content;
    // 合同是否作废
    private String ct_IsDestroy;
    // 承办方名称
    private String ct_RealName;
    // 备注
    private String ct_Remark;
    // 创建日期
    private String ct_CreateDate;
    // 有效期类型：Year、Month、Day
    private String ct_Year_Month_Day;
    // 有效期： 2 Year
    private String ct_ValidDate;
}
