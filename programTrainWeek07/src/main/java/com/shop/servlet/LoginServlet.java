package com.shop.servlet;
/*
* 这里是servlet，负责处理控制*/
import com.shop.dao.LoginConfirmed;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LoginServlet extends HttpServlet {
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
    }
    @Override // 重写doPost()方法
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        boolean isLogin = false; // 判断账号与密码是否与数据库中相同，验证是否登录成功。
        if((name!=null)&&(pwd!=null)) {
            isLogin = LoginConfirmed.confirmedLogin(name,pwd);
        }
        if(isLogin==true)
            out.print("success");
        else
            out.print("failure!");
    }
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        doPost(request,response);
    }
}
