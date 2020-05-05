package com.znsd.controller;

import com.znsd.bean.UserBean;
import com.znsd.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

/**
 * 注册登录Controller
 * @Author : deng
 */
@RestController
public class LoginController {

    @Value("${redis.expire}")
    private Integer expire;
    @Autowired
    private Jedis jedis;
    @Autowired
    private LoginService loginService;

    /**
     * 注册时根据qq邮箱发送验证码
     * @param email ：用户的qq邮箱
     * @Author : deng
     */
    @GetMapping("/register/sendVerification")
    @ResponseBody
    public void sendVerification(String email){
        //验证码
        String verificationCode = String.valueOf((int)((Math.random()*9+1)*1000));
        jedis.set(email,verificationCode);
        loginService.sendQqEmail(email,verificationCode,expire);
        //60秒=1分钟
        //验证码在1分钟后清除
        jedis.expire(email,expire);
        System.out.println(jedis.get(email));
    }

    /**
     *  注册账号
     * @param userBean ：用户信息
     * @param email ：用户qq邮箱
     * @param verificationCode ：验证码
     * @Author : deng
     */
    @GetMapping("/register")
    @ResponseBody
    public void register(UserBean userBean,String email, String verificationCode){
        //获取redis中的验证码
        String redisVer = jedis.get(email);
        //判断redis中的验证码是否与用户输入的验证码一样
        if(redisVer.equals(verificationCode)){
            userBean.setU_Email(email);
            boolean register = loginService.register(userBean);
            if(register){
                System.out.println("注册成功");
            }else{
                System.out.println("用户名已存在");
            }
        }else{
            System.out.println("验证码错误");
        }
    }

    /**
     * 管理员登录
     * @param name ：用户名/手机号/qq邮箱
     * @param password ：密码
     * @Author : deng
     */
    @GetMapping("/admin/login")
    public String AdminLogin(String name,String password){
        System.out.println("========================login"+name+"======"+password);
        UserBean userBean = loginService.login(name, password);
        if(userBean != null){
            boolean isAdmin = loginService.isAdmin(userBean.getU_Name());
            if(isAdmin){
                System.out.println("登录成功");
                return "redirect:http://127.0.0.1:8080/index.html";
            }else{
                System.out.println("不是管理员");
            }
        }else{
            System.out.println("账号或密码错误");
        }
        return "";
    }
}
