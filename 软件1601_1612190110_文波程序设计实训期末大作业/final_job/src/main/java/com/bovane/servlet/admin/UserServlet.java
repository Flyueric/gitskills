package com.bovane.servlet.admin;

import com.bovane.service.UserService;
import com.bovane.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doLogin(request,response);
    }
    public void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Boolean isLogin = userService.login(name,password);
        // 若登录成功，则将名字作为标识放入session中
        if(isLogin==true) {
            session.setAttribute("userName",name);
            response.sendRedirect("show.jsp");
        }
        else
            out.print("登录失败！");
    }
}
