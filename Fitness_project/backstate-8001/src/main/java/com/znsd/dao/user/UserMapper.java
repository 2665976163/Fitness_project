package com.znsd.dao.user;

import com.znsd.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public List<UserBean> findAll();

}
