package com.znsd.controller;

import com.znsd.bean.UserBean;
import com.znsd.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@RestController
public class LoginController {

    @Value("${redis.expire}")
    private Integer expire;
    @Autowired
    private Jedis jedis;
    @Autowired
    private LoginService loginService;

    @GetMapping("/register/sendVerification")
    @ResponseBody
    public void sendVerification(String qq){
        //验证码
        String verificationCode = String.valueOf((int)((Math.random()*9+1)*1000));
        jedis.set(qq,verificationCode);
        //60秒=1分钟
        //验证码在1分钟后清除
        jedis.expire(qq,expire);
        System.out.println(jedis.get(qq));
    }

    @GetMapping("/register")
    @ResponseBody
    public void register(UserBean userBean,String qq, String verificationCode){
        //获取redis中的验证码
        String redisVer = jedis.get(qq);
        //判断redis中的验证码是否与用户输入的验证码一样
        if(redisVer.equals(verificationCode)){
            userBean.setU_Name("deng");
            userBean.setU_Email(qq);
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

    @GetMapping("/login")
    public void login(UserBean userBean){
        System.out.println("========================login"+userBean);
        boolean login = loginService.login(userBean);
        if(login){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
    }
}
