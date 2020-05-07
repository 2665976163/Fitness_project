package com.znsd.service.user.impl;

import com.znsd.bean.RankBean;
import com.znsd.bean.RoleBean;
import com.znsd.bean.UserBean;
import com.znsd.dao.user.UserMapper;
import com.znsd.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户Service
 * @Author deng
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有用户
     * @return 用户对象
     * @Author deng
     */
    @Override
    public List<UserBean> findAll() {
        return userMapper.findAll();
    }

    /**
     * 根据用户id删除用户
     * @param uid ：用户id
     * @Author deng
     */
    @Override
    public void delete(Integer uid) {
        userMapper.delete(uid);
    }

    //添加用户
    @Override
    public boolean save(UserBean userBean) {
        UserBean byName = userMapper.findByName(userBean.getU_Name());
        if(byName == null){
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String formatDate = simpleDateFormat.format(date);
            userBean.setU_CreateDate(formatDate);
            userBean.setU_Integral(0+"");//积分
            userBean.setU_Balance(0+"");//余额
            userMapper.save(userBean);
            return true;
        }
        return false;
    }
    //修改用户
    @Override
    public void updateUser(UserBean userBean) {
        userMapper.updateUser(userBean);
    }
    //修改用户角色
    @Override
    public void updateUserRole(Integer uid, Integer rid) {
        userMapper.updateUserRole(uid,rid);
    }

    /**
     * 查询所有角色
     * @return 角色对象
     * @Author deng
     */
    @Override
    public List<RoleBean> findByAllRole() {
        return userMapper.findByAllRole();
    }

    /**
     * 查询所有等级
     * @return 等级对象
     * @Author deng
     */
    @Override
    public List<RankBean> findByAllRank() {
        return userMapper.findByAllRank();
    }

    @Override
    public List<UserBean> findByIf(UserBean userBean) {
        List<UserBean> userBeans = new ArrayList<>();
        //根据用户名查询
        if(userBean.getU_Name() != null && !("".equals(userBean.getU_Name())) && !("null".equals(userBean.getU_Name()))){
            UserBean byName = userMapper.findByName(userBean.getU_Name());
            userBeans.add(byName);
        }
        //根据地区查询
        if(userBean.getU_Region() != null && !("".equals(userBean.getU_Region())) && !("null".equals(userBean.getU_Region()))){
            UserBean byRegion = userMapper.findByRegion(userBean.getU_Region());
            userBeans.add(byRegion);
        }
        //根据性别查询
        if(userBean.getU_Sex() != null && !("".equals(userBean.getU_Sex())) && !("null".equals(userBean.getU_Sex()))){
            UserBean bySex = userMapper.findBySex(userBean.getU_Sex());
            userBeans.add(bySex);
        }
        //根据手机号查询
        if(userBean.getU_Phone() != null && !("".equals(userBean.getU_Phone())) && !("null".equals(userBean.getU_Phone()))){
            UserBean byPhone = userMapper.findByPhone(userBean.getU_Phone());
            userBeans.add(byPhone);
        }
        //根据邮箱查询
        if(userBean.getU_Email() != null && !("".equals(userBean.getU_Email())) && !("null".equals(userBean.getU_Email()))){
            UserBean byEmail = userMapper.findByEmail(userBean.getU_Email());
            userBeans.add(byEmail);
        }
        //根据角色id查询
        if(userBean.getRoleBean().getR_Id() != null && !("".equals(userBean.getRoleBean().getR_Id())) && !("null".equals(userBean.getRoleBean().getR_Id()))){
            UserBean byRankId = userMapper.findByRankId(userBean.getRoleBean().getR_Id());
            userBeans.add(byRankId);
        }
        //根据等级id查询
        if(userBean.getRankBean().getRk_Id() != null && !("".equals(userBean.getRankBean().getRk_Id())) && !("null".equals(userBean.getRankBean().getRk_Id()))){
            UserBean byRankId = userMapper.findByRankId(userBean.getRankBean().getRk_Id());
            userBeans.add(byRankId);
        }
        return userBeans;
    }

    //根据用户名查询用户
    @Override
    public UserBean findByName(String username) {
        return userMapper.findByName(username);
    }

    @Override
    public UserBean findById(Integer uid) {
        return userMapper.findByUId(uid);
    }
}
