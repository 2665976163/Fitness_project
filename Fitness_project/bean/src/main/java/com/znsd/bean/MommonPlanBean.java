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
 *  订单进度bean
 */
public class MommonPlanBean {
    // 进度Id
    private Integer p_Id;
    // 当前时间
    private String p_ThisDate;
    // 订单Id || 合同Id
    private Integer uc_Id;
    // 进度描述
    private String p_Content;
    // 状态：未付款、已付款、已发货、已取消、已完成 || 已提交、正在审核、审核完毕
    private String p_Status;
    // 进度类型：订单、合同
    private String p_Type;
}
