package com.mlj.web;

import com.mlj.service.UserService;
import com.mlj.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入servlet==============");
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
//        String name = URLDecoder.decode(n, "UTF-8");
//        String name=new String(n.getBytes("ISO-8859-1"),"utf-8");

        System.out.println(age);
        System.out.println(name);

        UserService userService = new UserServiceImpl();
        boolean login = userService.login(name, age);
        if (login==true){
            resp.getWriter().print("登陆成功");
        }else{
            resp.getWriter().print("登录失败");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
