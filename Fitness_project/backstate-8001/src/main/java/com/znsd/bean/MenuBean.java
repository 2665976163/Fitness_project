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
 *  菜单bean
 */
public class MenuBean {
    // 菜单Id
    private Integer m_Id;
    // 菜单名称
    private String m_Name;
    // 菜单位置：主页顶部、侧边栏
    private String m_Site;
    // 菜单跳转路径
    private String m_Path;
    // 创建日期
    private String m_CreateDate;
    // 最后修改日期
    private String m_LastUpdate;
    // 子菜单
    private List<MenuBean> menuBeanList;
}
