package com.bov.servlet;

import com.bov.entity.User;
import com.bov.services.UserServices;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
/*用户登录注册所对应的servlet*/
public class LoginServlet extends HttpServlet{
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) {
        doReg(request,response);
    }
    public void doGet(HttpServletRequest request,HttpServletResponse response) {
        PrintWriter out = null;
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        UserServices services = new UserServices();
        User user = new User();
        if((name!=null)&&(pwd!=null)) {
            user.setUserName(name);
            user.setPassword(pwd);
        }
        boolean isLogin = services.login(user);
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(isLogin==true) {
            out.print("Login successfully!"); }
        else {
            out.print("Login failed");
        }

    }
    public void doReg(HttpServletRequest request,HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        String rowAge = request.getParameter("age");
        int age = Integer.parseInt(rowAge);
        String email = request.getParameter("email");
        User user = new User(userName,pwd,sex,age,email);
        UserServices services = new UserServices();
        int result = services.register(user);
        PrintWriter out = null;
        try {
            out= response.getWriter();
            if(result>0){
                response.sendRedirect("login.jsp");
            }else if(result==0){
                out.println("<script>alert('×¢²áÊ§°Ü');history.go(-1);<script/>");
            }else{
                out.println("<script>alert('×¢²áÊ§°Ü,ÓÃ»§ÃûÒÑ¾­´æÔÚ');history.go(-1);<script/>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
