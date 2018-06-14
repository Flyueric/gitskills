package com.bovane.controller;

import com.bovane.service.UserService;
import com.bovane.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class UserControl {
    UserService userService = new UserServiceImpl();

    @RequestMapping("/admin/users/login.do")
    public String login(HttpServletRequest request,HttpServletResponse response, String name, String password) throws ServletException,IOException {
        HttpSession session = request.getSession();
        Boolean isLogin = userService.login(name,password);
        if(isLogin == true) {
            session.setAttribute("userName",name);
            response.sendRedirect("show.jsp");
        }
        return null;
    }
}
