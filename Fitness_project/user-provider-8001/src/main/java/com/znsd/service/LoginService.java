package com.znsd.service;

import com.znsd.bean.RoleBean;
import com.znsd.bean.UserBean;
import com.znsd.dao.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * 用户登录与注册Service
 *@Author : deng
 */
@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    /**
     *
     * @param userBean：用户信息
     * @return boolean 为true则注册成功，false为注册失败
     * @Author : deng
     */
    public boolean register(UserBean userBean){
        UserBean user = loginMapper.findByName(userBean.getU_Name());
        if(user == null){
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String time = format.format(date);
            userBean.setU_CreateDate(time);
            userBean.setU_Integral(0+"");//积分
            userBean.setU_Balance(0+"");//余额
            loginMapper.save(userBean);
            return true;
        }else{
            return false;
        }
    }

    /**
     * 登录
     * @return ：返回用户对象
     * @Author : deng
     */
    public UserBean login(String name,String password){
        UserBean byName = loginMapper.findByNameAndPass(name,password);
        UserBean byEmail = loginMapper.findByEmail(name,password);
        UserBean byPhone = loginMapper.findByPhone(name,password);
        if(byName != null){
            return byName;
        }else if(byEmail != null){
            return byEmail;
        }else if(byPhone != null){
            return byPhone;
        }
        return null;
    }

    /**
     * 判断登录的用户是否是管理员
     * @return ：boolean，为true则是管理员，false不是管理员
     * @Author : deng
     */
    public boolean isAdmin(String name){
        UserBean adminUser = loginMapper.findByRole("管理员", name);
        if(adminUser != null){
            System.out.println(adminUser);
            return true;
        }
        return false;
    }

    /**
     * 发送验证码到qq邮箱
     * @param email
     * @Author : deng
     */
    public void sendQqEmail(String email,String verificationCode,Integer expire) {
        //创建Properties类用于记录邮箱的一些属性
        Properties props = new Properties();
        //表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth","true");
        //此处填写SMTP服务器
        props.put("mail.smtp.host","smtp.qq.com");
        //端口号，qq邮箱端口587
        props.put("mail.smtp.port","587");
        //此处填写，写信人的账号
        props.put("mail.user","3286942815@qq.com");
        //密码：授权码
        props.put("mail.password","seldqhymdgmzcjgc");
        Authenticator authenticator = new Authenticator() {
            //进行登录邮箱时的用户身份认证
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //用户名、密码
                String username = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(username,password);
            }
        };
        //使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props,authenticator);
        //创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        try {
            //设置发件人
            InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
            message.setFrom(form);
            //设置收件人的邮箱
            InternetAddress to = new InternetAddress(email);
            message.setRecipient(MimeMessage.RecipientType.TO,to);
            //设置邮件标题
            message.setSubject("注册三度CC账号验证码");
            message.setContent("验证码在"+expire+"秒内有效，"+verificationCode,"text/html;charset=UTF-8");
            //发送邮件
            Transport.send(message);
        } catch (AddressException e) {
            System.out.println("发送失败！"+e.getMessage());
            e.printStackTrace();
        } catch (MessagingException e) {
            System.out.println("发送失败！"+e.getMessage());
            e.printStackTrace();
        }
    }
}
