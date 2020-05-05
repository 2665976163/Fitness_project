package com.znsd.service;

import com.znsd.bean.UserBean;
import com.znsd.dao.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    /**
     * 注册用户
     * @param userBean
     */
    public boolean register(UserBean userBean){
        UserBean user = loginMapper.findByName(userBean.getU_Name());
        if(user.getU_Name() == null){
            loginMapper.save(userBean);
            return true;
        }else{
            return false;
        }
    }

    /**
     * 登录
     * @return
     */
    public boolean login(UserBean userBean){
        UserBean user = null;
        if(userBean.getU_Name() != null){
            user = loginMapper.findByName(userBean.getU_Name());
        }else if(userBean.getU_Email() != null){
            user = loginMapper.findByEmail(userBean.getU_Email());
        }else if(userBean.getU_Phone() != null){
            user = loginMapper.findByPhone(userBean.getU_Phone());
        }
        if(user != null){
            System.out.println(user);
            return true;
        }
        return false;
    }
}
