package com.znsd.service.user.impl;

import com.znsd.bean.UserBean;
import com.znsd.dao.user.UserMapper;
import com.znsd.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<UserBean> findAll() {
        return userMapper.findAll();
    }
}
