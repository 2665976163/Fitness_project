package com.znsd.dao.user;

import com.znsd.bean.RankBean;
import com.znsd.bean.RoleBean;
import com.znsd.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户Mapper
 * @Author deng
 */
@Mapper
public interface UserMapper {

    /**
     * 查询所有用户
     * @return 用户对象
     * @Author deng
     */
    public List<UserBean> findAll();

    /**
     * 根据用户id删除用户
     * @param uid
     * @Author deng
     */
    public void delete(Integer uid);
    //添加用户
    public void save(UserBean userBean);
    //修改用户
    public void updateUser(UserBean userBean);
    //修改用户角色
    public void updateUserRole(Integer uid,Integer rid);
    //根据用户id查询
    public UserBean findByUId(Integer uid);

    /**
     * 查询所有角色
     * @return 角色对象
     * @Author deng
     */
    public List<RoleBean> findByAllRole();

    /**
     * 查询所有等级
     * @return 等级对象
     * @Author deng
     */
    public List<RankBean> findByAllRank();

    //根据用户名查询
    public UserBean findByName(String username);
    //根据手机号查询
    public UserBean findByPhone(String phone);
    //根据邮箱查询
    public UserBean findByEmail(String email);
    //根据性别查询
    public UserBean findBySex(String sex);
    //根据地区查询
    public UserBean findByRegion(String region);
    //根据角色id查询角色
    public UserBean findByRoleId(Integer rid);
    //根据等级id查询等级
    public UserBean findByRankId(Integer rkId);




}
