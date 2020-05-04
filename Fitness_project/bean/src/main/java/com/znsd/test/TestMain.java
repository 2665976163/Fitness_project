package com.znsd.test;

import com.znsd.bean.UserBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@SpringBootApplication
@RestController
public class TestMain {

    @Resource
    private TestMapper testMapper;

    public static void main(String[] args) {
        SpringApplication.run(TestMain.class,args);
    }

    @GetMapping("/test")
    public List<UserBean> beanList(){
        return testMapper.findAll();
    }
}
