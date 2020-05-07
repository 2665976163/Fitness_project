package com.znsd.service.user.impl;

import com.znsd.bean.UserBean;
import com.znsd.dao.user.LoginMapper;
import com.znsd.service.user.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    /**
     * 登录
     * @param loginField ：用户名/手机号/邮箱
     * @Author deng
     */
    public UserBean login(String  loginField) {
        UserBean byName = loginMapper.findByName(loginField);
        UserBean byEmail = loginMapper.findByEmail(loginField);
        UserBean byPhone = loginMapper.findByPhone(loginField);
        if(byName != null){
            return byName;
        }else if(byEmail !=null){
            return byEmail;
        }else if(byPhone != null){
            return byPhone;
        }
        return null;
    }

    public boolean isAdmin(String username) {
        UserBean admin = loginMapper.findByRole(username);
        if(admin != null){
            return true;
        }
        return false;
    }
}
