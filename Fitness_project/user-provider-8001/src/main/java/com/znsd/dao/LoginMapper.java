package com.znsd.dao;


import com.znsd.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户注册登录Mapper
 */
@Mapper
public interface LoginMapper {
    /**
     * 添加用户
     * @param userBean
     */
    public void save(UserBean userBean);


    /**
     * 根据邮箱和密码查询
     * @param email
     * @return
     */
    public UserBean findByEmail(String email,String password);

    /**
     * 根据用户名查询
     * @param name
     * @return
     */
    public UserBean findByName(String name);

    /**
     * 根据用户名和密码查询
     * @param name
     * @return
     */
    public UserBean findByNameAndPass(String name,String password);

    /**
     * 根据用户手机号和密码查询
     * @param phone
     * @return
     */
    public UserBean findByPhone(String phone,String password);

    /**
     * 根据用户名查询该用户角色
     * @param rName
     * @param uName
     * @return
     */
    public UserBean findByRole(String rName,String uName);
}
