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
 * 用户bean
 */
public class UserBean {
    // 用户Id
    private Integer u_Id;
    // 用户名称
    private String u_Name;
    // 用户性别
    private String u_Sex;
    // 用户邮箱
    private String u_Email;
    // 用户手机号
    private String u_Phone;
    // 用户头像
    private String u_Img;
    // 用户余额
    private String u_Balance;
    // 用户积分
    private String u_Integral;
    // 用户地区
    private String u_Region;
    // 用户个性签名
    private String u_Detali;
    // 用户创建日期
    private String u_CreateDate;
    // 用户最后登录日期
    private String u_LastLoginDate;
    // 用户角色
    private RoleBean roleBean;
    // 用户等级
    private RankBean rankBean;
    // 用户关注
    private List<UserBean> userBeanList;
    // 用户地址
    private List<UserAddressBean> addressBeanList;
}
