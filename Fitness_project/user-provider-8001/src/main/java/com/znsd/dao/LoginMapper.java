package com.znsd.dao;


import com.znsd.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginMapper {
    /**
     * 添加用户
     * @param userBean
     */
    public void save(UserBean userBean);
    public List<UserBean> findAll();

    /**
     * 根据用户邮箱查询
     * @param email
     * @return
     */
    public UserBean findByEmail(String email);

    /**
     * 根据用户名查询
     * @param name
     * @return
     */
    public UserBean findByName(String name);

    /**
     * 根据用户手机号查询
     * @param phone
     * @return
     */
    public UserBean findByPhone(String phone);
}
