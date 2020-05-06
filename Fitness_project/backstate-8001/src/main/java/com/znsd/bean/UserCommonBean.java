package com.znsd.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// 无参构造
@NoArgsConstructor
// 全参构造
@AllArgsConstructor
// get、set、toString ...
@Data
/**
 *  订单bean
 */
public class UserCommonBean {
    // 订单Id
    private Integer uc_Id;
    // 订单类型：商品 || 课程
    private String uc_Type;
    // 根据订单类型决定Id类型：商品Id || 课程Id
    private Integer common_Id;
    // 支付方式：积分、余额
    private String uc_PayMethod;
    // 购买数量
    private String uc_Count;
    // 用户Id
    private Integer u_Id;
    // 用户地址
    private String uc_Address;
    // 商品参数
    private String uc_Param;
    // 支付金额
    private String uc_money;
    // 订单状态 sql级联
    private List<MommonPlanBean> mommonPlanBeanList;

}
