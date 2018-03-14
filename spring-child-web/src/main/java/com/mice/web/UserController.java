package com.mice.web;

import com.mice.domain.UserBean;
import com.mice.service.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by AmbitiousMice on 2018/1/9.
 */
@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String login(UserBean user, HttpServletRequest servletRequest){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPassword());
        subject.login(token);
        servletRequest.getSession().setAttribute("user",user);
        return "success";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "index";
    }

    @RequestMapping("/admin")
    public String admin(HttpServletRequest request){
        return "success";
    }

    @RequestMapping("/student")
    public String student(HttpServletRequest request){
        return "success";
    }

    @RequestMapping("/teacher")
    public String teacher(HttpServletRequest request){
        return "success";
    }


}
