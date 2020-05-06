package com.znsd.controller.user;

import com.znsd.bean.UserBean;
import com.znsd.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    @ResponseBody
    public void findAll(Map<String,Object> map){
        System.out.println("=======");
        List<UserBean> all = userService.findAll();
        map.put("userList","deng");
        System.out.println(all);
    }

    @RequestMapping("/login")
    @ResponseBody
    public void login(String name,String password){
        System.out.println("--------");
    }

}
