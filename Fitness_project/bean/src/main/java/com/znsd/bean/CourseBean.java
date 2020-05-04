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
 * 课程bean
 */
public class CourseBean {
    // 课程Id
    private Integer c_Id;
    // 课程名称
    private String c_Name;
    // 课程封面
    private String c_ImgPath;
    // 课程价格
    private String c_Price;
    // 课程积分
    private String c_Integral;
    // 上传时间
    private String c_UploadDate;
    // 课程总时长
    private String c_SunTime;
    // 课程描述
    private String c_Detali;
    // 上传用户 sql级联
    private UserBean userBean;
    // 课程等级 sql级联
    private RankBean rankBean;
    // 购买数量 sql 求出
    private String c_PayCount;
    // 商品评分 sql求出
    private String c_Score;
    // 浏览记录(x个用户看过) sql 级联 BrowseBean -> UserBean
    private List<UserBean> userBeanList;
}
