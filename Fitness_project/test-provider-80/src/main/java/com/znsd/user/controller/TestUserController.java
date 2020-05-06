package com.znsd.user.controller;

import com.znsd.bean.UserBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class TestUserController {
    private static String code;

    @GetMapping("/register/sendVerification")
    public void initCode(String email){
        code = email+((int)(Math.random()*9+1)*1000);
        System.out.println("生成验证码："+code);
    }

    @PostMapping("/register")
    public void initUser(UserBean userBean, String code) throws Exception {
        System.out.println(userBean.getU_Email());
        System.out.println(code);
        if((userBean.getU_Email()+code).equals(TestUserController.code)){
            System.out.println("注册成功！");
        }else{
            throw new Exception();
        }
    }

    @PostMapping("/login")
    public void login(String name,String pswd){

    }
}
