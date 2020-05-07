package com.znsd.dao.user;

import com.znsd.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;

/**
 * 登录Mapper
 * @Author deng
 */
@Mapper
public interface LoginMapper {
    /**
     * 根据用户名查询
     * @param username ：用户名
     * @return 用户对象
     * @Author deng
     */
    public UserBean findByName(String username);

    /**
     * 根据用户手机号查询
     * @param phone ：手机号
     * @return 用户对象
     * @Author deng
     */
    public UserBean findByPhone(String phone);

    /**
     * 根据邮箱查询
     * @param email ：邮箱
     * @return 用户对象
     * @Author deng
     */
    public UserBean findByEmail(String email);

    /**
     * 根据用户名查询是否是管理员
     * @param username
     * @return
     */
    public UserBean findByRole(String username);
}
