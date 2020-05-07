package com.znsd.controller.user;

import com.znsd.bean.RankBean;
import com.znsd.bean.RoleBean;
import com.znsd.bean.UserBean;
import com.znsd.service.user.LoginService;
import com.znsd.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    /**
     * 管理员登录
     * @param name ：用户名/手机号/qq邮箱
     * @param password ：密码
     * @Author : deng
     */
    @RequestMapping("/login")
    @ResponseBody
    public void AdminLogin(String name, String password, Map<String,Object> map, HttpServletResponse response){
        System.out.println("========================login"+name+"======"+password);
        response.setCharacterEncoding("UTF-8");
        UserBean userBean = loginService.login(name);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(userBean != null){
            if(password.equals(userBean.getU_Password())){
                boolean isAdmin = loginService.isAdmin(userBean.getU_Name());
                if(isAdmin){
                    map.put("username",userBean.getU_Name());
                    writer.println("success");
                }else{
                    writer.println("不是管理员");
                }
            }else{
                writer.println("密码错误");
            }
        }else{
            writer.println("账号不存在");
        }
    }

    /**
     * 查询所有用户
     * @param map
     * @return 返回用户列表页面
     * @Author deng
     */
    @RequestMapping("/findAll")
    public String findAll(UserBean userBean,String role,String rank,Map<String,Object> map){
        System.out.println(role+"====="+rank);
        List<UserBean> all = userService.findAll();
        List<RoleBean> byAllRole = userService.findByAllRole();//所有角色
        List<RankBean> byAllRank = userService.findByAllRank();//所有等级
        map.put("userList",all);
        map.put("roleList",byAllRole);
        map.put("rankList",byAllRank);
        System.out.println(all);
        return "user/user-list.html";
    }

    @RequestMapping("/save")
    @ResponseBody
    public void save(UserBean userBean,HttpServletResponse response){
        System.out.println("save============="+userBean);
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean isTrue = userService.save(userBean);
        if(isTrue){
            writer.println("添加成功");
        }else{
            writer.println("用户名已存在");
        }
    }

    @RequestMapping("/update")
    @ResponseBody
    public void updateUser(UserBean userBean){
        System.out.println("update------"+userBean);
        userService.updateUser(userBean);
    }

    @RequestMapping("/updateUserRole")
    @ResponseBody
    public void updateUserRole(String uid,String rid){
        String[] split = uid.split("\\D");
        List<Integer> list1 = new ArrayList<Integer>();
        for(int i=0;i<split.length;i++){
            if(split[i]!=null && split[i].length()!=0){ //过滤掉数组split里面的空字符串
                list1.add(Integer.valueOf(split[i]));
            }
        }
        for(int i=0; i<list1.size();i++){
            userService.updateUserRole(list1.get(i), Integer.valueOf(rid));
        }
    }
    /**
     * 根据用户id删除用户
     * @param uid ：用户id
     * @Author deng
     */
    @RequestMapping("/delete")
    @ResponseBody
    public void delete(String uid){
        String[] split = uid.split("\\D");
        List<Integer> list1 = new ArrayList<Integer>();
        for(int i=0;i<split.length;i++){
            if(split[i]!=null && split[i].length()!=0){ //过滤掉数组split里面的空字符串
                list1.add(Integer.valueOf(split[i]));
            }
        }
        System.out.println(list1.size());
        for(int i=0; i<list1.size();i++){
            userService.delete(list1.get(i));
        }
    }

    @RequestMapping("/findRole")
    @ResponseBody
    public void findByAllRole(Map<String,Object> map){
        List<RoleBean> byAllRole = userService.findByAllRole();
        map.put("roleList",byAllRole);
        System.out.println(byAllRole);
    }

    @RequestMapping("/findByIf")
    @ResponseBody
    public void findByIf(UserBean userBean,String role,String rank,Map<String,Object> map){
        System.out.println("====="+userBean);
        if(!("等级".equals(rank))){
            System.out.println("等级");
            RankBean rankBean = new RankBean();
            rankBean.setRk_Id(Integer.valueOf(rank));
            userBean.setRankBean(rankBean);
        }
        if(!("角色".equals(role))){
            System.out.println("角色");
            RoleBean roleBean = new RoleBean();
            roleBean.setR_Id(Integer.valueOf(role));
            userBean.setRoleBean(roleBean);
        }
        List<UserBean> userBeanList = userService.findByIf(userBean);
        map.put("userList",userBeanList);
        System.out.println("findByif----"+userBeanList);
    }

    @RequestMapping("/findById")
    @ResponseBody
    public void findById(String id,Map<String,Object> map,HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserBean user = userService.findById(Integer.valueOf(id));
        map.put("users",user);
        writer.println(user);
        System.out.println("findById-------"+user);
    }
}
