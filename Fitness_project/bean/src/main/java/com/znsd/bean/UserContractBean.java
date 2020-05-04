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
 *  用户合同bean
 */
public class UserContractBean {
    // 用户合同Id
    private Integer uct_Id;
    // 履行人真实姓名
    private String uct_RealName;
    // 履行人手机号
    private String uct_Phone;
    // 审核者Id
    private Integer uct_checkId;
    // 合同签订日期
    private String uct_createDate;
    // 合同生效日期
    private String uct_effect_time;
    // 合同失效日期
    private String uct_lost_effect_time;
    // 身份证号码
    private String uct_Identity;
    // 是否失效
    private String uct_cancel;
    // 履行人 sql级联
    private UserBean userBean;
    // 合同 sql级联
    private ContractBean contractBean;
    // 审核进度 sql级联
    private List<MommonPlanBean> mommonPlanBeanList;

}
