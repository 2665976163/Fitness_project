package com.znsd.controller.user;

import com.google.gson.Gson;
import com.znsd.bean.RoleBean;
import com.znsd.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    @ResponseBody
    public void findAll(HttpServletResponse response){
        try {
            PrintWriter writer = response.getWriter();
            List<RoleBean> role = userService.findByAllRole();
            Gson gson = new Gson();
            String s = gson.toJson(role);
            System.out.println(s);
            writer.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
