package com.znsd.dao;


import com.znsd.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户注册登录Mapper
 * @Author:deng
 */
@Mapper
public interface LoginMapper {
    /**
     * 添加用户
     * @param userBean：用户对象
     * @Author:deng
     */
    public void save(UserBean userBean);

    /**
     * 查询用户总数量
     * @return ：用户数量
     * @Author:deng
     */
    public Integer findUserCount();

    /**
     * 根据邮箱和密码查询
     * @param email ：用户邮箱
     * @return ：用户对象
     * @Author:deng
     */
    public UserBean findByEmail(String email);

    /**
     * 根据用户名查询
     * @param name ：用户名
     * @return ：用户对象
     * @Author:deng
     */
    public UserBean findByName(String name);


    /**
     * 根据用户手机号和密码查询
     * @param phone ：用户手机号
     * @return 用户对象
     * @Author:deng
     */
    public UserBean findByPhone(String phone);

    /**
     * 根据用户名查询该用户角色
     * @param rName ：角色名称
     * @param uName ：用户名
     * @return 用户对象
     * @Author:deng
     */
    public UserBean findByRole(String rName,String uName);
}
