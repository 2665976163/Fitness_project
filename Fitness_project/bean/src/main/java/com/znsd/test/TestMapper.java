package com.znsd.test;

import com.znsd.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    List<UserBean> findAll();
}
