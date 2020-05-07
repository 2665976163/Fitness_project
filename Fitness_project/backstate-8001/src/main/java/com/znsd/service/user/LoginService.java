package com.znsd.service.user;


import com.znsd.bean.UserBean;

public interface LoginService {
    public UserBean login(String loginField);
    public boolean isAdmin(String username);
}
