package com.znsd.service.user;

import com.znsd.bean.RankBean;
import com.znsd.bean.RoleBean;
import com.znsd.bean.UserBean;

import java.util.List;

public interface UserService {

    public List<UserBean> findAll();

    public void delete(Integer uid);
    public boolean save(UserBean userBean);
    public void updateUser(UserBean userBean);
    public void updateUserRole(Integer uid,Integer rid);

    public List<RoleBean> findByAllRole();

    public List<RankBean> findByAllRank();

    public List<UserBean> findByIf(UserBean userBean);
    public UserBean findByName(String username);
    public UserBean findById(Integer uid);



}
