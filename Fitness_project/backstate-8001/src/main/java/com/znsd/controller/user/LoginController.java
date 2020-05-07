package com.znsd.controller.user;

import com.znsd.bean.UserBean;
import com.znsd.service.user.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
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
    public void AdminLogin(String name, String password, HttpServletRequest request){
        System.out.println("========================login"+name+"======"+password);
        UserBean userBean = loginService.login(name);
        if(userBean != null){
            if(password.equals(userBean.getU_Password())){
                boolean isAdmin = loginService.isAdmin(userBean.getU_Name());
                if(isAdmin){
                    System.out.println("登录成功");
                }else{
                    System.out.println("不是管理员");
                }
            }else{
                System.out.println("密码错误");
            }
        }else{
            System.out.println("账号不存在");
        }
    }
}
